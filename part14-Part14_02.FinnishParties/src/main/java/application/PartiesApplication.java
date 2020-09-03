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
 /*
Party	1968	1972	1976	1980	1984	1988	1992	1996	2000	2004	2008
KOK	16.1	18.1	20.9	22.9	23.0	22.9	19.1	21.6	20.8	21.8	23.4
SDP	23.9	27.1	24.8	25.5	24.7	25.2	27.1	24.5	23.0	24.1	21.2
KESK	18.9	18.0	18.4	18.7	20.2	21.1	19.2	21.8	23.8	22.8	20.1
VIHR	-	-	-	-	2.8	2.3	6.9	6.3	7.7	7.4	8.9
VAS	16.9	17.5	18.5	16.6	13.1	12.6	11.7	10.4	9.9	9.6	8.8
PS	7.3	5.0	2.1	3.0	5.3	3.6	2.4	0.9	0.7	0.9	5.4
RKP	5.6	5.2	4.7	4.7	5.1	5.3	5.0	5.4	5.1	5.2	4.7
*/
    private void MapInfo() {
        List<String> file = readFile();
        
        Map<String, Map<Integer, Double>> infoMapped = new HashMap<>();
        //load map with party names <party name, map<año, valor>>
        file.stream().map(row -> row.split("\t")).forEach(row -> infoMapped.putIfAbsent(row[0], new HashMap<>()));
        infoMapped.remove("Party");
        String years = file.get(0);
        years.split("\t")
        infoMapped.get(0)
    }
    
    private List<XYChart.Series> handleFile() {
        List<XYChart.Series> result = new ArrayList<>();
        
        List<String> file = readFile();
        
        
        file.stream().map(row -> row.split("\t")).forEach(line -> {
            XYChart.Series kokData = new XYChart.Series();
            kokData.setName(line[0]);
            kokData.getData().add(new XYChart.Data<>(line, line));
            result.add(kokData);
        });
        return result;
    }

    @Override
    public void start(Stage window) throws Exception {
        NumberAxis xAxies = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxies = new NumberAxis(0, 30, 5);
        xAxies.setLabel("Year");
        yAxies.setLabel("Support");

        LineChart graphic = new LineChart(xAxies, yAxies);
        graphic.setTitle("Relative support of the parties");

        window.setScene(new Scene(graphic, 800, 600));
        window.setTitle("Finnish parties application");
        window.show();
    }
}
