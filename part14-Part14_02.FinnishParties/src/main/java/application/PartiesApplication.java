package application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

    private List<String> readFile() {
        List<String> file = new ArrayList<>();
        try {
            file = Files.lines(Paths.get("partiesdata.tsv")).collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return file;
    }

    private int[] getYears() {
        String yearsAsString[] = readFile().get(0).split("\t");
        int yearsWithOutPartyText = yearsAsString.length - 1;
        int[] years = new int[yearsWithOutPartyText];

        for (int i = 0; i < years.length; i++) {
            years[i] = Integer.parseInt(yearsAsString[i + 1]);
        }
        
        return years;
    }

    private Double manipulateScore(String scoreAsString) {
        try {
            return Double.valueOf(scoreAsString);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    private Map<Integer, Double> getMapYearScore(String partyName) {
        Map<Integer, Double> yearScore = new HashMap<>();
        int[] years = getYears();

        readFile().stream()
                .map(row -> row.split("\t"))
                .forEach(row -> {
                    if (row[0].equals(partyName)) {
                        for (int i = 1; i < row.length; i++) {
                            yearScore.put(years[i - 1], manipulateScore(row[i]));
                        }
                    }
                });
        return yearScore;
    }

    private Map<String, Map<Integer, Double>> mapInfo() {
        List<String> file = readFile();
        Map<String, Map<Integer, Double>> infoMapped = new HashMap<>();
        
        file.stream().map(row -> row.split("\t"))
                .forEach(row -> infoMapped.putIfAbsent(row[0], getMapYearScore(row[0])));
        infoMapped.remove("Party");

        return infoMapped;
    }

    private void addInfoToGraphic(LineChart<Number, Number> graphic) {
        Map<String, Map<Integer, Double>> values = mapInfo();

        values.keySet().stream().forEach(party -> {
            XYChart.Series data = new XYChart.Series();
            data.setName(party);

            values.get(party).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });

            graphic.getData().add(data);
        });
    }

    @Override
    public void start(Stage window) throws Exception {
        NumberAxis xAxies = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxies = new NumberAxis(0, 30, 5);
        xAxies.setLabel("Year");
        yAxies.setLabel("Support");

        LineChart<Number, Number> graphic = new LineChart<>(xAxies, yAxies);
        graphic.setTitle("Relative support of the parties");
        addInfoToGraphic(graphic);

        window.setScene(new Scene(graphic, 800, 600));
        window.setTitle("Finnish parties application");
        window.show();
    }
}
