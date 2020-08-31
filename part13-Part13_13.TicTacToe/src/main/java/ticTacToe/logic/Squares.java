package ticTacToe.logic;

import static ticTacToe.logic.State.*;

/**
 *
 * @author Jere
 */
public class Squares {

    private State squareState;

    public Squares() {
        this.squareState = UNMARKED;
    }

    public State getSquareState() {
        return squareState;
    }

    public void setSquareState(State squareState) {
        this.squareState = squareState;
    }    
}
