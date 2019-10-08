package gameMechanism;

import graficInterface.ActionFrame;

class WinCheck {

    static String winner;
    private final static int WIDTH = 400;
    private final static int HEIGHT = 300;

    static void winCheck(int[] helpBoard){

        if (helpBoard[0] == 2 && helpBoard[1] == 2 && helpBoard[2] == 2 ||
                helpBoard[3] == 2 && helpBoard[4] == 2 && helpBoard[5] == 2 ||
                helpBoard[6] == 2 && helpBoard[7] == 2 && helpBoard[8] == 2 ||
                helpBoard[0] == 2 && helpBoard[4] == 2 && helpBoard[8] == 2 ||
                helpBoard[0] == 2 && helpBoard[3] == 2 && helpBoard[6] == 2 ||
                helpBoard[1] == 2 && helpBoard[4] == 2 && helpBoard[7] == 2 ||
                helpBoard[2] == 2 && helpBoard[5] == 2 && helpBoard[8] == 2 ||
                helpBoard[2] == 2 && helpBoard[4] == 2 && helpBoard[6] == 2){

            winner = "X";
           ActionFrame.run (new DrowResult (), WIDTH, HEIGHT);
        }
        else if (helpBoard[0] == 1 && helpBoard[1] == 1 && helpBoard[2] == 1 ||
                helpBoard[3] == 1 && helpBoard[4] == 1 && helpBoard[5] == 1 ||
                helpBoard[6] == 1 && helpBoard[7] == 1 && helpBoard[8] == 1 ||
                helpBoard[0] == 1 && helpBoard[4] == 1 && helpBoard[8] == 1 ||
                helpBoard[0] == 1 && helpBoard[3] == 1 && helpBoard[6] == 1 ||
                helpBoard[1] == 1 && helpBoard[4] == 1 && helpBoard[7] == 1 ||
                helpBoard[2] == 1 && helpBoard[5] == 1 && helpBoard[8] == 1 ||
                helpBoard[2] == 1 && helpBoard[4] == 1 && helpBoard[6] == 1){

            winner = "O";
            ActionFrame.run (new DrowResult (), WIDTH, HEIGHT);
        }
    }

}
