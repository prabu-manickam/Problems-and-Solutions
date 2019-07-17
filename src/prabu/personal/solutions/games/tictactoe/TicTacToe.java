package prabu.personal.solutions.games.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {

    public static void main(String[] args) throws IOException {
        Player playerX = new Player(-1, -3, "X");
        Player playerO = new Player(1, 3, "O");
	    Board ticTacToe = new Board(3, playerX);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean move = true;
        while(move) {
            System.out.println("What is your move (row,column) Player-"+ticTacToe.getCurrentPlayer().getName());
            String[] movePositionStr = br.readLine().split(",");

            int rowPosition, columnPosition;
            try {
                rowPosition = Integer.valueOf(movePositionStr[0].trim()) - 1;
                columnPosition = Integer.valueOf(movePositionStr[1].trim()) - 1;
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid move");
                continue;
            }
            if(rowPosition >= 0 && rowPosition < ticTacToe.getBoardPositions().length
                    && columnPosition >= 0 && columnPosition < ticTacToe.getBoardPositions().length
                        && ticTacToe.getBoardPositions()[rowPosition][columnPosition].getFillMark() == 0) {
                fillTheBoard(ticTacToe, rowPosition, columnPosition);

                printBoard(ticTacToe);

                boolean win = findAnyWin(ticTacToe);

                if(win) {
                    System.out.print("Holy Bear!!! Player-"+ticTacToe.getCurrentPlayer().getName()+" won the match!!!");
                    move = false;
                } else {
                    if(checkForTie(ticTacToe)) {
                        System.out.print("Maddy Saddy!!! Its a Tie!!!");
                        move = false;
                    } else {
                        ticTacToe.setCurrentPlayer(ticTacToe.getCurrentPlayer().equals(playerX) ? playerO : playerX);
                    }
                }
            } else {
              System.out.println("Please enter a valid move");
            }

        }
    }

    private static boolean checkForTie(Board ticTacToe) {
        //Row Check
        for(int rowPos = 0; rowPos < ticTacToe.getBoardPositions().length; rowPos++) {
            for (int colPos = 0; colPos < ticTacToe.getBoardPositions().length; colPos++) {
                if (ticTacToe.getBoardPositions()[rowPos][colPos].getFillMark() == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printBoard(Board ticTacToe) {
        //Row Check
        for(int rowPos = 0; rowPos < ticTacToe.getBoardPositions().length; rowPos++) {
            for(int colPos = 0; colPos < ticTacToe.getBoardPositions().length; colPos++) {
                System.out.print(" "+(ticTacToe.getBoardPositions()[rowPos][colPos].getFillMark() != 0 ? ticTacToe.getBoardPositions()[rowPos][colPos].getFillName() : " ")+" ");
                if(colPos != ticTacToe.getBoardPositions().length-1) {
                    System.out.print("|");
                }
            }

            System.out.println();
            if(rowPos != ticTacToe.getBoardPositions().length-1) {
                System.out.println("---+---+---");
            }

        }
    }

    private static boolean findAnyWin(Board ticTacToe) {
        //Row Check
        for(int rowPos = 0; rowPos < ticTacToe.getBoardPositions().length; rowPos++) {
            int total = 0;

            for(int colPos = 0; colPos < ticTacToe.getBoardPositions().length; colPos++) {
                total += ticTacToe.getBoardPositions()[rowPos][colPos].getFillMark();
            }

            if(total == ticTacToe.getCurrentPlayer().getFillMark() * ticTacToe.getSize()) {
                return true;
            }
        }

        //Column Check
        for(int rowPos = 0; rowPos < ticTacToe.getBoardPositions().length; rowPos++) {
            int total = 0;

            for(int colPos = 0; colPos < ticTacToe.getBoardPositions().length; colPos++) {
                total += ticTacToe.getBoardPositions()[colPos][rowPos].getFillMark();
            }

            if(total == ticTacToe.getCurrentPlayer().getFillMark() * ticTacToe.getSize()) {
                return true;
            }
        }

        //Cross Check from left
        int total = 0;
        for(int rowPos = 0; rowPos < ticTacToe.getBoardPositions().length; rowPos++) {
            total += ticTacToe.getBoardPositions()[rowPos][rowPos].getFillMark();
        }

        if(total == ticTacToe.getCurrentPlayer().getFillMark() * ticTacToe.getSize()) {
            return true;
        } else total = 0;

        for(int rowPos = 0, colPos = ticTacToe.getBoardPositions().length-1; rowPos < ticTacToe.getBoardPositions().length && colPos >= 0; rowPos++, colPos--) {
            total += ticTacToe.getBoardPositions()[rowPos][colPos].getFillMark();
        }

        if(total == ticTacToe.getCurrentPlayer().getFillMark() * ticTacToe.getSize()) {
            return true;
        } else total = 0;

        return false;
    }

    private static void fillTheBoard(Board ticTacToe, int rowPosition, int columnPosition) {
        ticTacToe.getBoardPositions()[rowPosition][columnPosition].setFillMark(ticTacToe.getCurrentPlayer().getFillMark());
        ticTacToe.getBoardPositions()[rowPosition][columnPosition].setFillName(ticTacToe.getCurrentPlayer().getName());
    }


}
