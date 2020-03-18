import javax.swing.*;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GiaoDien giaoDien = new GiaoDien();
                giaoDien.setVisible(true);
            }
        });
    }
}
