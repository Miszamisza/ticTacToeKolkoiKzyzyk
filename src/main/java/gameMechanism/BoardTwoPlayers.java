package gameMechanism;

import graficInterface.ActionFrame;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.*;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class BoardTwoPlayers extends Application implements EventHandler<ActionEvent> {

    int [] helpBoard = new int[9];
    private int counter = 0;
    private int help = 0;
    private List<String> check = new ArrayList<String> ();

    public static final CountDownLatch latch = new CountDownLatch(1);
    public static BoardTwoPlayers boardTwoPlayers = null;


    public static void setStartUpTest(BoardTwoPlayers boardTwoPlayers1) {
        boardTwoPlayers = boardTwoPlayers1;
        latch.countDown();
    }

    public BoardTwoPlayers() {
        setStartUpTest(this);
    }


    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane ();
        BoardTwoPlayers boardTwoPlayers = new BoardTwoPlayers ();
        boardTwoPlayers.addButton (gridPane, 3);

        primaryStage.setTitle ("TicTacToe");
        primaryStage.setScene (new Scene (gridPane, ActionFrame.WIDTH, ActionFrame.HEIGHT));
        primaryStage.setX (500);
        primaryStage.setY (150);
        primaryStage.show ();

    }

    private void addButton(GridPane gridPane, int i) {
        int id = 0;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                Button button = new Button ("");
                button.setPrefSize (200, 200);
                gridPane.add (button, j, k);
                gridPane.setLayoutX (100);
                gridPane.setLayoutY (40);
                button.setOnAction (this);
                button.setId (String.valueOf (id));
                id++;
            }
        }
    }


    @Override
    public void handle(ActionEvent event) {
        Button button = (Button) event.getSource ();
        if (counter % 2 == 0) {
            if (checkThatButtonIsAlreadyClick (button.getId ())) {
                check.add (button.getId ());
                button.setText ("X");
                counter++;
                helpBoard[Integer.parseInt (button.getId ())] = 2;
                help = counter;
                WinCheck.winCheck (helpBoard);
            }
        } else {
            if (checkThatButtonIsAlreadyClick (button.getId ())) {
                check.add (button.getId ());
                button.setText ("O");
                counter++;
                helpBoard[Integer.parseInt (button.getId ())] = 1;
                help = counter;
                WinCheck.winCheck (helpBoard);
            }
        }

        button.setVisible (true);
    }

    private boolean checkThatButtonIsAlreadyClick(String buttonId) {
        boolean result = false;
        for (int i = 0; i < check.size (); i++) {
            if (check.get (i).equals (buttonId)) {
                result = true;
            }
        }

        return !result;
    }
}

