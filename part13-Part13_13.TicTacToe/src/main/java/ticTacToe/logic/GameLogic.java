package ticTacToe.logic;

import static ticTacToe.logic.State.*;
import java.util.Arrays;

/**
 *
 * @author Jere
 */
public class GameLogic {

    private final Square[] board;
    private final Player playerX;
    private final Player playerO;
    private final TurnManager turn;
    private boolean gameOver;
    
    public GameLogic() {
        this.board = createBoard();
        this.playerX = new Player('X');
        this.playerO = new Player('O');
        this.turn = new TurnManager(playerX, playerO);
        this.gameOver = false;
    }

    private Square[] createBoard(){
        Square[] newBoard = new Square[9];
        
        for (int i = 0; i < newBoard.length; i++) {
            newBoard[i] = new Square();
        }
        return newBoard;
    }
    
    private boolean areThereAnyFreeSquares() {
        return Arrays.asList(board).stream().filter(square -> square.getSquareState().equals(UNMARKED)).findAny().isPresent();
    }

    private boolean checkLineSameSimbol(Square first, Square second, Square third) {
        if (first.getSquareState() != UNMARKED && second.getSquareState() != UNMARKED && third.getSquareState() != UNMARKED) {
            if (first.getSquareState() == second.getSquareState() && second.getSquareState() == third.getSquareState()) {
                return true;
            }
        } 
        return false;
    }
    
    private boolean checkRows() {
        if (checkLineSameSimbol(board[0], board[1], board[2])) return true;
        if (checkLineSameSimbol(board[3], board[4], board[5])) return true;
        if (checkLineSameSimbol(board[6], board[7], board[8])) return true;
        return false;
    }
    
    private boolean checkColums() {
        if (checkLineSameSimbol(board[0], board[3], board[6])) return true;
        if (checkLineSameSimbol(board[1], board[4], board[7])) return true;
        if (checkLineSameSimbol(board[2], board[5], board[8])) return true;
        return false;
    }
    
    private boolean checkDiagonals() {
        if (checkLineSameSimbol(board[0], board[4], board[8])) return true;
        if (checkLineSameSimbol(board[2], board[4], board[6])) return true;
     return false;
    }
    
    private boolean AnyPlayerWon() {
        if (checkRows()) return true;
        if (checkColums()) return true;
        if (checkDiagonals()) return true;
        
        return false;
    }
    
    private void markSquare(Player player, int square) {
        switch (player.getMark()) {
            case 'X':
                board[square].setSquareState(X);
                break;
            case 'O':
                board[square].setSquareState(O);
                break;
            }
    }
        
    public Player getPlayerTurn() {
        return turn.whoseTurnIs();
    } 
    
    public boolean isGameOver() {
        return gameOver;
    }
    
    public String gameInfo() {
        return isGameOver() ? "The end!" : "Turn: " + turn.whoseTurnIs().getMark();
    }
          
    public boolean play(Player player, int square) { 
        if (turn.whoseTurnIs().equals(player) && board[square - 1].getSquareState() == UNMARKED && !gameOver) { 
            markSquare(player, square - 1);
            turn.nextTurn();
            if (AnyPlayerWon() || !areThereAnyFreeSquares()) {
                gameOver = true;
            }
            return true;
        }
        return false;       
    }
}
