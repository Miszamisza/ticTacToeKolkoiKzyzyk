package gameMechanism;

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

public class Board extends Application implements EventHandler<ActionEvent> {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 700;
    int [] helpBoard = new int[9];
    private int counter = 0;
    private int help = 0;
    private List<String> check = new ArrayList<String> ();

    public static final CountDownLatch latch = new CountDownLatch(1);
    public static Board board = null;

    public static Board waitForStartUpTest() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return board;
    }

    public static void setStartUpTest(Board board1) {
        board = board1;
        latch.countDown();
    }

    public Board() {
        setStartUpTest(this);
    }


    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = new GridPane ();
        Board board = new Board ();
        board.addButton (gridPane, 3);

        primaryStage.setTitle ("TicTacToe");
        primaryStage.setScene (new Scene (gridPane, WIDTH, HEIGHT));
        primaryStage.show ();

    }

    private void addButton(GridPane gridPane, int i) {

        int id = 0;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                Button button = new Button ("");
                button.setPrefSize (200, 200);
                gridPane.add (button, j, k);
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
            if (checkThatButtonIsAlreadyClick (button.getId ()) == false) {
                check.add (button.getId ());
                button.setText ("X");
                counter++;
                helpBoard[counter] = 2;
                help = counter;
            }
        } else {
            if (checkThatButtonIsAlreadyClick (button.getId ()) == false) {
                check.add (button.getId ());
                button.setText ("O");
                counter++;
                helpBoard[counter] = 1;
                help = counter;
            }
        }

        button.setVisible (true);
    }

    public boolean checkThatButtonIsAlreadyClick(String buttonId) {
        boolean result = false;
        for (int i = 0; i < check.size (); i++) {
            if (check.get (i).equals (buttonId)) {
                result = true;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Application.launch (args);
    }
}

