package prabu.personal.solutions.games.tictactoe;

public class Position {
    int fillMark;
    String fillName;

    public Position() {
        this.fillMark = 0;
    }

    public String getFillName() {
        return fillName;
    }

    public void setFillName(String fillName) {
        this.fillName = fillName;
    }

    public int getFillMark() {
        return fillMark;
    }

    public void setFillMark(int fillMark) {
        this.fillMark = fillMark;
    }
}
