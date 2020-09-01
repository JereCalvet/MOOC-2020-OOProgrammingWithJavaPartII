package ticTacToe.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Jere
 */
public class TurnManager {

    private final List<Player> players;
    private int currentTurn;

    public TurnManager(Player... players) {
        this.players = new ArrayList<>(Arrays.asList(players));
        this.currentTurn = 0;
    }

    public Player whoseTurnIs() {
        return players.get(currentTurn);
    }

    public void nextTurn() {
        currentTurn = currentTurn < players.size() - 1 ? ++currentTurn : 0;
    }
}
