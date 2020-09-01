package ticTacToe.logic;

/**
 *
 * @author Jere
 */
public class Player {
    
    private char mark;

    public Player(char mark) {
        this.mark = mark;
    }

    public char getMark() {
        return mark;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.mark;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (this.mark != other.mark) {
            return false;
        }
        return true;
    }
}
