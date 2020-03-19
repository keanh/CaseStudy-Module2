import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class GiaoDien extends JFrame {
    private JTextArea myEnglishWord;
    private JTextArea myVietNameseWord;
    private JButton translateButton;
    private JPanel rootPanel;
    private JButton addButton;
    private JButton fixButton;
    private JButton removeButton;
    private JButton button1;
    private String path = "D:\\Module 2\\Case Study\\CaseStudy\\Data";
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    File file = new File(path);

    public GiaoDien (){
        ArrayList<Dictionary> list = new ArrayList<>();
        add(rootPanel);
        setTitle("My simple dictionary");
        setSize(500,500);
        translateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null){
                        String[] word =line.split(",");
                        Dictionary dictionary = new Dictionary(word[0],word[1]);
                        list.add(dictionary);
                    }
                    bufferedReader.close();

                    for (Dictionary word: list){
                        if (word.getVietnameseWord().equals(myEnglishWord.getText())){
                            myVietNameseWord.setText(word.getEnglishWord());
                        }else if (word.getEnglishWord().equals(myEnglishWord.getText())){
                            myVietNameseWord.setText(word.getVietnameseWord());
                        }
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }
}
