import javax.swing.SwingUtilities;
import view.Mainframe;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Mainframe();
            }
        });
    }
}
