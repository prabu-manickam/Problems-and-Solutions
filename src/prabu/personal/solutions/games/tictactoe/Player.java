package prabu.personal.solutions.games.tictactoe;

import java.util.Objects;

public class Player {
    int fillMark;
    String name;

    public Player(int fillMark, int winningMark, String name) {
        this.fillMark = fillMark;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFillMark() {
        return fillMark;
    }

    public void setFillMark(int fillMark) {
        this.fillMark = fillMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }
}
