package graficInterface;
import javax.swing.*;
import java.awt.*;

public class ActionFrame extends JFrame {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 700;

    public static void
    run(final JFrame f, final int width, final int height  ){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                f.setTitle(f.getClass().getSimpleName());
                f.setLocation (500,150);
                f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                f.setSize(width,height);
                f.setVisible(true);
            }
        });

    }

    public static void
    close(final Frame[] f){
        System.exit (0);
    }
}