import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WordList {
    private ArrayList<Dictionary> list ;
    private String path = "D:\\Module 2\\Case Study\\CaseStudy\\Data";
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    File file = new File(path);

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

    public WordList() {
        list = new ArrayList<>();
    }

    public boolean addWord(Dictionary word){
        if (!list.contains(word)){
            return list.add(word);
        }return false;
    }

    public void getList(){
        for (Dictionary dictionary:list){
            System.out.println(dictionary);
        }
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

    public boolean fixWord(String oldEnglishWord, String oldVietnameseWord, String newEnglishWord, String newVietnameseWord){
        for (Dictionary word:list){
            if (word.getEnglishWord().equals(oldEnglishWord) && word.getVietnameseWord().equals(oldVietnameseWord)){
                word.setEnglishWord(newEnglishWord);
                word.setVietnameseWord(newVietnameseWord);
                return true;
            }
        }
        return false;
    }

    public boolean search(String input){
        for (Dictionary word: list){
            if (word.getVietnameseWord().equals(input)){
                System.out.println(word.getEnglishWord());
                return true;
            }else if (word.getEnglishWord().equals(input)){
                System.out.println(word.getVietnameseWord());
                return true;
            }
        }
        return false;
    }
}
