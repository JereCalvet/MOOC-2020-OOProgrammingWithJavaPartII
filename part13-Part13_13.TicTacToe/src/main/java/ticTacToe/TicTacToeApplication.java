package ticTacToe;

//this is the GUI package. I cant change the name because test wont pass

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ticTacToe.logic.GameLogic;
import ticTacToe.logic.Player;

/**
 *
 * @author Jere
 */
public class TicTacToeApplication extends Application {

    private final GameLogic game;

    public TicTacToeApplication() {
        this.game = new GameLogic();
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }
    
    @Override
    public void start(Stage window) throws Exception {
        //creating components
        BorderPane mainLayout = new BorderPane();
        GridPane gameBoardLayout = new GridPane();

        Label turnInformationLabel = new Label(game.gameInfo());
        Button gridButton1 = new Button();
        Button gridButton2 = new Button();
        Button gridButton3 = new Button();
        Button gridButton4 = new Button();
        Button gridButton5 = new Button();
        Button gridButton6 = new Button();
        Button gridButton7 = new Button();
        Button gridButton8 = new Button();
        Button gridButton9 = new Button();

        gameBoardLayout.add(gridButton1, 0, 0);
        gameBoardLayout.add(gridButton2, 1, 0);
        gameBoardLayout.add(gridButton3, 2, 0);
        gameBoardLayout.add(gridButton4, 0, 1);
        gameBoardLayout.add(gridButton5, 1, 1);
        gameBoardLayout.add(gridButton6, 2, 1);
        gameBoardLayout.add(gridButton7, 0, 2);
        gameBoardLayout.add(gridButton8, 1, 2);
        gameBoardLayout.add(gridButton9, 2, 2);

        //positioning
        mainLayout.setTop(turnInformationLabel);
        mainLayout.setCenter(gameBoardLayout);

        //styling
        gameBoardLayout.setPadding(new Insets(20, 20, 20, 20));
        gameBoardLayout.setHgap(10);
        gameBoardLayout.setVgap(10);
        turnInformationLabel.setFont(Font.font("Monospaced", 40));
        gridButton1.setPrefSize(80, 80);
        gridButton2.setPrefSize(80, 80);
        gridButton3.setPrefSize(80, 80);
        gridButton4.setPrefSize(80, 80);
        gridButton5.setPrefSize(80, 80);
        gridButton6.setPrefSize(80, 80);
        gridButton7.setPrefSize(80, 80);
        gridButton8.setPrefSize(80, 80);
        gridButton9.setPrefSize(80, 80);
        gridButton1.setFont(Font.font("Monospaced", 40));
        gridButton2.setFont(Font.font("Monospaced", 40));
        gridButton3.setFont(Font.font("Monospaced", 40));
        gridButton4.setFont(Font.font("Monospaced", 40));
        gridButton5.setFont(Font.font("Monospaced", 40));
        gridButton6.setFont(Font.font("Monospaced", 40));
        gridButton7.setFont(Font.font("Monospaced", 40));
        gridButton8.setFont(Font.font("Monospaced", 40));
        gridButton9.setFont(Font.font("Monospaced", 40));

        //adding event
        gridButton1.setOnMouseClicked(event -> updateGUI(gridButton1, 1, turnInformationLabel));
        gridButton2.setOnMouseClicked(event -> updateGUI(gridButton2, 2, turnInformationLabel));
        gridButton3.setOnMouseClicked(event -> updateGUI(gridButton3, 3, turnInformationLabel));
        gridButton4.setOnMouseClicked(event -> updateGUI(gridButton4, 4, turnInformationLabel));
        gridButton5.setOnMouseClicked(event -> updateGUI(gridButton5, 5, turnInformationLabel));
        gridButton6.setOnMouseClicked(event -> updateGUI(gridButton6, 6, turnInformationLabel));
        gridButton7.setOnMouseClicked(event -> updateGUI(gridButton7, 7, turnInformationLabel));
        gridButton8.setOnMouseClicked(event -> updateGUI(gridButton8, 8, turnInformationLabel));
        gridButton9.setOnMouseClicked(event -> updateGUI(gridButton9, 9, turnInformationLabel));
        
        window.setTitle("TicTacToe application");
        window.setScene(new Scene(mainLayout));
        window.show();
    }

    private void updateGUI(Button buttonPressed, int buttonNumber, Label infoLabelToUpdate) {
        Player playerPlaying = game.getPlayerTurn();
        if (!game.isGameOver() && game.play(playerPlaying, buttonNumber)) { 
            buttonPressed.setText(String.valueOf(playerPlaying.getMark()));
            infoLabelToUpdate.setText(game.gameInfo());
        }
    }
}
