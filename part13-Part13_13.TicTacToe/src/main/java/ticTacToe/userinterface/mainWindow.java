package ticTacToe.userinterface;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Jere
 */
public class mainWindow extends Application {

    @Override
    public void start(Stage window) throws Exception {
        BorderPane mainLayout = new BorderPane();
        GridPane gameBoardLayout = new GridPane();
        
        Label turnInformationLabel = new Label("Turn: ");
        //buttons of the board
        Button button1 = new Button();
        Button button2 = new Button();
        Button button3 = new Button();
        Button button4 = new Button();
        Button button5 = new Button();
        Button button6 = new Button();
        Button button7 = new Button();
        Button button8 = new Button();
        Button button9 = new Button();
        
        gameBoardLayout.add(button1, 0, 0);
        gameBoardLayout.add(button2, 1, 0);
        gameBoardLayout.add(button3, 2, 0);
        gameBoardLayout.add(button4, 0, 1);
        gameBoardLayout.add(button5, 1, 1);
        gameBoardLayout.add(button6, 2, 1);
        gameBoardLayout.add(button7, 0, 2);
        gameBoardLayout.add(button8, 1, 2);
        gameBoardLayout.add(button9, 2, 2);
        
        mainLayout.setTop(turnInformationLabel);
        mainLayout.setCenter(gameBoardLayout);
        
        //styling
        gameBoardLayout.setPadding(new Insets(20, 20, 20, 20));
        gameBoardLayout.setHgap(10);
        gameBoardLayout.setVgap(10);
        turnInformationLabel.setFont(Font.font("Monospaced", 40));
        button1.setFont(Font.font("Monospaced", 40));
        button2.setFont(Font.font("Monospaced", 40));
        button3.setFont(Font.font("Monospaced", 40));
        button4.setFont(Font.font("Monospaced", 40));
        button5.setFont(Font.font("Monospaced", 40));
        button6.setFont(Font.font("Monospaced", 40));
        button7.setFont(Font.font("Monospaced", 40));
        button8.setFont(Font.font("Monospaced", 40));
        button9.setFont(Font.font("Monospaced", 40));
                
        window.setTitle("TicTacToe application");
        window.setScene(new Scene(mainLayout));
        window.show();
    }
}
