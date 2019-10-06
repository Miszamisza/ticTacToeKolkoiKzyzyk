package graficInterface;

import gameMechanism.Board;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TicTacToeMenu extends JFrame implements ActionListener {

    private int buttonPlaceX = 200;

    private JButton jButton;

    String[] labels = {"Jeden gracz", "Dwóch graczy", "Koniec"};


    public TicTacToeMenu(){
        for (int i = 0; i < labels.length; i++) {
            jButton = new JButton(labels[i]);
            add(jButton);
            jButton.setBounds(280,buttonPlaceX,200, 60);
            jButton.addActionListener (this);
            buttonPlaceX +=70;
        }
        setLayout (null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String label = ((JButton)e.getSource()).getText();
        if (label.equals ("Jeden gracz")){
        }

        else if (label.equals ("Dwóch graczy")){
            new Thread() {
                @Override
                public void run() {
                    javafx.application.Application.launch(Board.class);
                }
            }.start();
            Board board = Board.board;
        }

        else if (label.equals ("Koniec")){
        }
    }

    public static void main(String[] args) {
        ActionFrame.run (new TicTacToeMenu(), Board.WIDTH, Board.HEIGHT);
    }
}
