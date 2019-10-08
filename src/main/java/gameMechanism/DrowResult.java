package gameMechanism;

import graficInterface.ActionFrame;
import graficInterface.TicTacToeMenu;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class DrowResult extends JFrame implements ActionListener {

    private JButton jButton;

    public DrowResult(){
        int buttonPlaceX = 80;
        String[] labels = {"Jeszcze raz", "Koniec"};
        for (String label : labels) {
            jButton = new JButton (label);
            add (jButton);
            jButton.setBounds (buttonPlaceX, 150, 120, 40);
            jButton.addActionListener (this);
            buttonPlaceX += 140;
        }

        setLayout (null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand ();
        if (s.equals ("Jeszcze raz")) {
            dispose ();
            ActionFrame.run (new TicTacToeMenu (), ActionFrame.WIDTH, ActionFrame.HEIGHT);
        }
        else if (s.equals ("Koniec")){
            ActionFrame.close (TicTacToeMenu.getFrames ());
        }
    }
}
