package graficInterface;
import javax.swing.*;

public class ActionFrame extends JFrame {

    public static void
    run(final JFrame f, final int width, final int height  ){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                f.setTitle(f.getClass().getSimpleName());
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                f.setSize(width,height);
                f.setVisible(true);
            }
        });

    }
}