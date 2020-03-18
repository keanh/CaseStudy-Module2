import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();
        int choice = -1;
        while (choice != 0){
            client.menu();
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    client.translate();
                    break;
                case 2:
                    client.add();
                    break;
                case 3:
                    client.fixWord();
                    break;
                case 4:
                    client.remove();
                    break;
                case 5:
                    client.getList();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
