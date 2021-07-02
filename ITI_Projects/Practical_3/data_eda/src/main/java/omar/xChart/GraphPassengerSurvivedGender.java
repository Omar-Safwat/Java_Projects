package omar.xChart;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.knowm.xchart.*;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GraphPassengerSurvivedGender {
    public GraphPassengerSurvivedGender() {
    }

    public static void main(String[] args) {
        GraphPassengerSurvivedGender countSurvivedGender = new GraphPassengerSurvivedGender();
        countSurvivedGender.graphPassengerSurvivedGender(GraphPassengerSurvivedGender.getPassengersFromJsonFile());
        
    }

    public void graphPassengerSurvivedGender(List<Passenger> dataSet) {
        Long maleSurvived = dataSet.stream().filter(p -> p.getSex().equalsIgnoreCase("male") && p.getSurvived().equals("1")).count();
        Long femaleSurvived = dataSet.stream().filter(p -> p.getSex().equalsIgnoreCase("female") && p.getSurvived().equals("1")).count();

        // Create Chart
        PieChart chart = new PieChartBuilder ().width (800).height (600).title (getClass ().getSimpleName ()).build ();
        // Customize Chart
        Color[] sliceColors = new Color[]{new Color (180, 68, 50), new Color (130, 105, 120), new Color (80, 143, 160)};
        chart.getStyler ().setSeriesColors (sliceColors);
        // Series
        chart.addSeries ("Males survival count", maleSurvived);
        chart.addSeries ("Females survival count", femaleSurvived);
        // Show it
        new SwingWrapper (chart).displayChart ();
    } 

    public static List<Passenger> getPassengersFromJsonFile() {
        List<Passenger> allPassengers = new ArrayList<Passenger> ();
        ObjectMapper objectMapper = new ObjectMapper ();
        //Ignore null values
        objectMapper.configure (DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try (InputStream input = new FileInputStream ("src/main/resources/data/titanic_csv.json")) {
            //Read JSON file
            allPassengers = objectMapper.readValue (input, new TypeReference<List<Passenger>> () {
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
        return allPassengers;
    }

}


