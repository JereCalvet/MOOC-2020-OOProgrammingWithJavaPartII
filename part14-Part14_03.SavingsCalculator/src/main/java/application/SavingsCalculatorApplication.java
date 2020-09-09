package application;

import application.logic.SavingsCalculator;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Comparator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {
    
    private SavingsCalculator calculatorLogic;

    public SavingsCalculatorApplication() {
        this.calculatorLogic = new SavingsCalculator();
    }
    
    private String roundDouble(Double valueToRound) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        return df.format(valueToRound.doubleValue());
    }
    
    private XYChart.Series generateDataMonthlySavings() {
        XYChart.Series dataMonthlySavings = new XYChart.Series();
        calculatorLogic.getNextYearsAmountNoRates().entrySet().forEach(entry -> dataMonthlySavings.getData().add(new XYChart.Data(entry.getKey(), entry.getValue())));
        return dataMonthlySavings; 
    }
    
    private XYChart.Series generateDataAnualInterestRate() {
        calculatorLogic.calculateYearlyAmountWithRates();
        XYChart.Series dataYearlyInterestRate = new XYChart.Series();
        calculatorLogic.getNextYearsAmountWithRates().entrySet().forEach(entry -> dataYearlyInterestRate.getData().add(new XYChart.Data(entry.getKey(), entry.getValue())));
        return dataYearlyInterestRate; 
    }
    
    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        VBox dragSliders = new VBox();
        BorderPane monthlySavingsLayout = new BorderPane();
        monthlySavingsLayout.setPadding(new Insets(20, 20, 20, 20));
        Label monthlySavingAmountDisplayLabel = new Label("25.0");
        Slider monthlySavingSlider = new Slider(25, 250, 25);
        monthlySavingSlider.setShowTickLabels(true);
        monthlySavingSlider.setShowTickMarks(true);
        monthlySavingsLayout.setLeft(new Label("Monthly savings"));
        monthlySavingsLayout.setCenter(monthlySavingSlider);
        monthlySavingsLayout.setRight(monthlySavingAmountDisplayLabel);
        monthlySavingSlider.valueProperty().addListener((changed, oldValue, newValue) -> monthlySavingAmountDisplayLabel.setText(roundDouble(newValue.doubleValue()))); 
        monthlySavingSlider.setOnMouseReleased(dragOver -> calculatorLogic.setMonthlySavings(monthlySavingSlider.getValue()));
        //Double.valueOf(roundDouble()))          
        BorderPane anualInterestRateLayout = new BorderPane();
        anualInterestRateLayout.setPadding(new Insets(20, 20, 20, 20));
        Label anualInterestRateAmountDisplayLabel = new Label("0.0");
        Slider anualInterestRateSlider = new Slider(0, 10, 0);
        anualInterestRateSlider.setShowTickMarks(true);
        anualInterestRateSlider.setShowTickLabels(true);
        anualInterestRateLayout.setLeft(new Label("Yearly interest rate"));
        anualInterestRateLayout.setCenter(anualInterestRateSlider);
        anualInterestRateLayout.setRight(anualInterestRateAmountDisplayLabel);
        anualInterestRateSlider.valueProperty().addListener((changed, oldValue, newValue) -> anualInterestRateAmountDisplayLabel.setText(roundDouble(newValue.doubleValue()))); 
        anualInterestRateSlider.setOnMouseReleased(dragOver -> {calculatorLogic.setMonthlySavings(monthlySavingSlider.getValue()); //Double.valueOf(roundDouble(
                                                                calculatorLogic.setYearlyInterestRate(anualInterestRateSlider.getValue()); //Double.valueOf(roundDouble(
        });
         
        dragSliders.getChildren().add(monthlySavingsLayout);
        dragSliders.getChildren().add(anualInterestRateLayout);

        calculatorLogic.calculateYearlyAmountNoRates();
        calculatorLogic.calculateYearlyAmountWithRates();
        
        Double maxValueForTheYAxis = calculatorLogic.getNextYearsAmountWithRates().values().stream().max(Comparator.comparing(Double::doubleValue)).orElse(0.0);
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis(0, maxValueForTheYAxis, 2500);
        xAxis.setLabel("Years");
        yAxis.setLabel("Savings");
        LineChart<Number, Number> graphic = new LineChart<>(xAxis, yAxis);
        graphic.setTitle("Savings counter");
        graphic.getData().add(generateDataMonthlySavings());
        graphic.getData().add(generateDataAnualInterestRate());
        
        BorderPane mainLayout = new BorderPane();
        mainLayout.setCenter(graphic);
        mainLayout.setTop(dragSliders);

        window.setTitle("Savings calculator application");
        window.setScene(new Scene(mainLayout, 800, 600));
        window.show();
    }
}
