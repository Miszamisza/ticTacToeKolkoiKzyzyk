package graficInterface;

import gameMechanism.BoardOnePlayer;
import gameMechanism.BoardTwoPlayers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TicTacToeMenu extends JFrame implements ActionListener {

    private JButton jButton;

    private String[] labels = {"Jeden gracz", "Dwóch graczy", "Koniec"};


    public TicTacToeMenu(){
        int buttonPlaceY = 200;
        for (String label : labels) {
            jButton = new JButton (label);
            add (jButton);
            jButton.setBounds (280, buttonPlaceY, 200, 60);
            jButton.addActionListener (this);
            buttonPlaceY += 70;
        }

        setLayout (null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String label = ((JButton)e.getSource()).getText();
        if (label.equals ("Jeden gracz")){
            dispose ();
            new Thread() {
                @Override
                public void run() {
                    javafx.application.Application.launch(BoardOnePlayer.class);
                }
            }.start();
            BoardOnePlayer boardOnePlayer = BoardOnePlayer.boardOnePlayer;
        }

        else if (label.equals ("Dwóch graczy")){
            dispose ();
            new Thread() {
                @Override
                public void run() {
                    javafx.application.Application.launch(BoardTwoPlayers.class);
                }
            }.start();
            BoardTwoPlayers boardOnePlayers = BoardTwoPlayers.boardTwoPlayers;
        }

        else if (label.equals ("Koniec")){
            System.exit (0);
        }
    }

    public static void main(String[] args) {
        ActionFrame.run (new TicTacToeMenu(), ActionFrame.WIDTH, ActionFrame.HEIGHT);
    }
}
