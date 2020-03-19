import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GiaoDien extends JFrame {
    private JButton translateButton;
    private JPanel rootPanel;
    private JButton addButton;
    private JButton fixButton;
    private JButton removeButton;
    private String path = "D:\\Module 2\\Case Study\\CaseStudyWithSwing\\Text";
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private JTextArea wordToTranslate;
    private JTextArea wordTranslated;
    private JButton removeTextButton;

    ArrayList<Dictionary> list = new ArrayList<>();
    File file = new File(path);
    Dictionary dictionary = new Dictionary();

    public GiaoDien (){
        add(rootPanel);
        setTitle("My simple dictionary");
        setSize(700,500);
        translateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    readFile();
                    boolean check = search(wordToTranslate.getText());
                    if (!check){
                        wordTranslated.setText("Từ cần tìm không tồn tại");
                    }
                    removeAllWord();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    readFile();
                    dictionary.setEnglishWord(wordToTranslate.getText().toLowerCase());
                    dictionary.setVietnameseWord(wordTranslated.getText().toLowerCase());
                    addWord(dictionary);
                    writeFile();
                    removeAllWord();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        fixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    readFile();
                    fixWord(wordToTranslate.getText(),wordTranslated.getText());
                    writeFile();
                    removeAllWord();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    readFile();
                    removeWord(wordToTranslate.getText().toLowerCase(),wordTranslated.getText().toLowerCase());
                    writeFile();
                    removeAllWord();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        removeTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wordToTranslate.setText("");
                wordTranslated.setText("");
            }
        });
    }

    public void readFile() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(file));
        String line = "";
        while ((line = bufferedReader.readLine()) != null){
            String[] word =line.split(",");
            Dictionary dictionary = new Dictionary(word[0],word[1]);
            list.add(dictionary);
        }
        bufferedReader.close();
        sort();
    }

    public void sort(){
        Collections.sort(list, new Comparator<Dictionary>() {
            @Override
            public int compare(Dictionary o1, Dictionary o2) {
                return (o1.getEnglishWord().compareTo(o2.getEnglishWord()));
            }
        });
    }

    public void writeFile() throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(file));
        for (Dictionary dictionary:list){
            bufferedWriter.write(String.valueOf(dictionary));
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public boolean addWord(Dictionary word){
        if (!list.contains(word)){
            return list.add(word);
        }return false;
    }

    public void removeAllWord(){
        list.removeAll(list);
    }

    public boolean removeWord(String EnglishWord, String VietNameseWord){
        for (Dictionary word:list){
            if (word.getEnglishWord().equals(EnglishWord) && word.getVietnameseWord().equals(VietNameseWord)){
                list.remove(word);
                return true;
            }
        }
        return false;
    }

    public void fixWord(String EnglishWord, String VietNameseWord){
        for (Dictionary word:list){
            if (wordToTranslate.getText().toLowerCase().equals(word.getEnglishWord())){
                word.setVietnameseWord(wordTranslated.getText().toLowerCase());
            }else if (wordTranslated.getText().toLowerCase().equals(word.getVietnameseWord())){
                word.setEnglishWord(wordTranslated.getText().toLowerCase());
            }
        }
    }

    public boolean search(String input){
        ApproximatString approximatString = new ApproximatString(wordToTranslate.getText());
        for (Dictionary word: list){
            if (word.getVietnameseWord().equals(wordToTranslate.getText().toLowerCase())){
                wordTranslated.setText(word.getEnglishWord());
                return true;
            }else if (word.getEnglishWord().equals(wordToTranslate.getText().toLowerCase())){
                wordTranslated.setText(word.getVietnameseWord());
                return true;
            }else{
               boolean checkEnglishWord = approximatString.SoSanh(word.getEnglishWord());
               if (checkEnglishWord){
                   wordTranslated.setText("Có phải ý của bạn là " + word);
                   return true;
               }
            }
        }
        return false;
    }

}
