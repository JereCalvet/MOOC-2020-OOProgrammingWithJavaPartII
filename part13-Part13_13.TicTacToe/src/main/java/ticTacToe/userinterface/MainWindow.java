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
public class MainWindow extends Application {

    @Override
    public void start(Stage window) throws Exception {
        BorderPane mainLayout = new BorderPane();
        GridPane gameBoardLayout = new GridPane();
        
        Label turnInformationLabel = new Label("Turn: ");
        //buttons of the board
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
        gridButton1.setFont(Font.font("Monospaced", 40));
        gridButton2.setFont(Font.font("Monospaced", 40));
        gridButton3.setFont(Font.font("Monospaced", 40));
        gridButton4.setFont(Font.font("Monospaced", 40));
        gridButton5.setFont(Font.font("Monospaced", 40));
        gridButton6.setFont(Font.font("Monospaced", 40));
        gridButton7.setFont(Font.font("Monospaced", 40));
        gridButton8.setFont(Font.font("Monospaced", 40));
        gridButton9.setFont(Font.font("Monospaced", 40));
                
        window.setTitle("TicTacToe application");
        window.setScene(new Scene(mainLayout));
        window.show();
    }
}
