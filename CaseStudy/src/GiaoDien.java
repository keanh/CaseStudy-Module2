import javax.swing.*;

public class GiaoDien extends JFrame {
    private JTextArea myEnglishWord;
    private JTextArea myVietNameseWord;
    private JButton translateButton;
    private JPanel rootPanel;

    public GiaoDien (){
        add(rootPanel);
        setTitle("My simple dictionary");
        setSize(500,500);
    }
}
