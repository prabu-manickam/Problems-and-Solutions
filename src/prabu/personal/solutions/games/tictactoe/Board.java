package prabu.personal.solutions.games.tictactoe;

public class Board {
    Position[][] boardPositions;
    Player currentPlayer;
    int size;

    public Board(int rowAndColumnSize, Player currentPlayer) {
        this.size = rowAndColumnSize;
        boardPositions = new Position[rowAndColumnSize][rowAndColumnSize];
        for(int rowPos = 0; rowPos < rowAndColumnSize; rowPos++) {
            for (int colPos = 0; colPos < rowAndColumnSize; colPos++) {
                boardPositions[rowPos][colPos] = new Position();
            }
        }
        this.boardPositions = boardPositions;
        this.currentPlayer = currentPlayer;
    }

    public Position[][] getBoardPositions() {
        return boardPositions;
    }

    public void setBoardPositions(Position[][] boardPositions) {
        this.boardPositions = boardPositions;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
