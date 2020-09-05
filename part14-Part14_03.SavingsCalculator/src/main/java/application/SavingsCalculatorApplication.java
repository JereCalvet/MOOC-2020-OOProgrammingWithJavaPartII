package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();//calculate params (min, max, jump)
        LineChart<Number, Number> graphic = new LineChart<>(xAxis, yAxis);

        VBox dragSliders = new VBox();
        BorderPane monthlySavingsLayout = new BorderPane();
        monthlySavingsLayout.setPadding(new Insets(20, 20, 20, 20));
        Slider monthlySavingSlider = new Slider(25, 250, 25);
        monthlySavingSlider.setShowTickLabels(true);
        monthlySavingSlider.setShowTickMarks(true);
        monthlySavingsLayout.setLeft(new Label("Monthly savings"));
        monthlySavingsLayout.setCenter(monthlySavingSlider);
        monthlySavingsLayout.setRight(new Label(String.valueOf(monthlySavingSlider.getValue())));
        
        BorderPane anualTaxRateLayout = new BorderPane();
        anualTaxRateLayout.setPadding(new Insets(20, 20, 20, 20));
        Slider anualTaxRateSlider = new Slider(0, 10, 0);
        anualTaxRateSlider.setShowTickMarks(true);
        anualTaxRateSlider.setShowTickLabels(true);
        anualTaxRateLayout.setLeft(new Label("Yearly interest rate"));
        anualTaxRateLayout.setCenter(anualTaxRateSlider);
        anualTaxRateLayout.setRight(new Label(String.valueOf(anualTaxRateSlider.getValue())));
        
        dragSliders.getChildren().add(monthlySavingsLayout);
        dragSliders.getChildren().add(anualTaxRateLayout);
        
        BorderPane mainLayout = new BorderPane();
        mainLayout.setCenter(graphic);
        mainLayout.setTop(dragSliders);

        window.setTitle("Savings calculator application");
        window.setScene(new Scene(mainLayout, 800, 600));
        window.show();
    }
}
