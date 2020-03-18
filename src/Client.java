import java.io.IOException;
import java.util.Scanner;

public class Client {
    Dictionary dictionary = new Dictionary();
    WordList wordList = new WordList();
    Scanner scanner = new Scanner(System.in);

    public void readFile() throws IOException {
        wordList.readFile();
    }

    public void removeAllList(){
        wordList.removeAllWord();
    }

    public void add() throws Exception {
        readFile();
        System.out.println("Nhập từ tiếng anh");
        String EnglishWord = scanner.nextLine();
        dictionary.setEnglishWord(EnglishWord.toLowerCase());
        System.out.println("Nhập từ tiếng việt");
        String VietNameseWord = scanner.nextLine();
        dictionary.setVietnameseWord(VietNameseWord.toLowerCase());
        wordList.addWord(dictionary);
        wordList.writeFile();
        removeAllList();
    }

    public void getList() throws IOException {
        readFile();
        wordList.getList();
        removeAllList();
    }

    public void remove() throws Exception {
        readFile();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập từ tiếng anh");
        String EnglishWord = scanner.nextLine();
        System.out.println("Nhập từ tiếng việt");
        String VietNameseWord = scanner.nextLine();
        wordList.removeWord(EnglishWord,VietNameseWord);
        wordList.writeFile();
        removeAllList();
    }

    public void fixWord() throws IOException {
        readFile();
        System.out.println("Nhập từ tiếng anh muốn thay đổi");
        String oldEnglishWord = scanner.nextLine();
        System.out.println("Nhập từ tiếng việt muốn thay đổi");
        String oldVietNameseWord = scanner.nextLine();
        System.out.println("Nhập từ tiếng anh muốn đổi");
        String newEnglishWord = scanner.nextLine();
        System.out.println("Nhập từ tiếng việt muốn đổi");
        String newVietNameseWord = scanner.nextLine();
        wordList.fixWord(oldEnglishWord, oldVietNameseWord, newEnglishWord, newVietNameseWord);
        wordList.writeFile();
        removeAllList();
    }

    public void translate() throws IOException {
        readFile();
        System.out.println("Nhập từ bạn muốn dịch");
        String input = scanner.nextLine();
        boolean check = wordList.search(input.toLowerCase());
        if (!check){
            System.out.println("Không tìm thấy");
        }
        removeAllList();
    }

    public void menu(){
        System.out.println("============================");
        System.out.println("1.Dịch từ");
        System.out.println("2.Thêm từ vào file");
        System.out.println("3.Sửa từ trong file");
        System.out.println("4.Xóa từ khỏi file");
        System.out.println("5.Hiển thị các từ trong file");
        System.out.println("6.Thoát khỏi chương trình");
        System.out.println("Mời bạn chọn");
    }
}
