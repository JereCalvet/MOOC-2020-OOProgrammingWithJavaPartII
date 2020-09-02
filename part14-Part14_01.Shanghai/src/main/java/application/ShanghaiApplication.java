package application;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }

    private Map<Integer, Integer> loadData() {
        Map<Integer, Integer> data = new HashMap<>();        
        data.put(2007, 73);
        data.put(2008, 68);
        data.put(2009, 72);
        data.put(2010, 72);
        data.put(2011, 74);
        data.put(2012, 73);
        data.put(2013, 76);
        data.put(2014, 73);
        data.put(2015, 67);
        data.put(2016, 56);
        data.put(2017, 56);

        return data;
    }
    
    @Override
    public void start(Stage window) throws Exception {
        NumberAxis xAxis = new NumberAxis(2005, 2019, 2);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);
        
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

        LineChart<Number, Number> graphic = new LineChart<>(xAxis, yAxis);
        graphic.setTitle("University of Helsinki, Shangai ranking");
        
        XYChart.Series rankingData = new XYChart.Series();
        rankingData.setName("Shangai ranking");
        loadData().entrySet().stream().forEach(valuePair -> rankingData.getData().add(new XYChart.Data(valuePair.getKey(),valuePair.getValue())));
        
        graphic.getData().add(rankingData);
        
        window.setScene(new Scene(graphic, 800, 600));
        window.setTitle("International universities ranking");
        window.show();
    }
}
