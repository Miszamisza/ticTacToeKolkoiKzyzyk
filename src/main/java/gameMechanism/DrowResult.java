package gameMechanism;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class DrowResult extends JFrame implements ActionListener {

    protected void drowResult() {
        if (0==7){

        }

        JButton b = new JButton ("Ok");
        JPanel jPanel = new JPanel ();
        JWindow jWindow = new JWindow ();

        b.addActionListener (this);
        jPanel.add (b);
        jPanel.setVisible (true);
        jPanel.setSize (40, 40);
        jWindow.add (jPanel);
        jWindow.setVisible (true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand ();
        if (s.equals ("Ok")) {
            setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        }
    }
}
