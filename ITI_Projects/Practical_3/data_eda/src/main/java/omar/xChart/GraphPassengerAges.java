package omar.xChart;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GraphPassengerAges {

    public GraphPassengerAges() {
    }

    public static void main(String[] args) {
        GraphPassengerAges graphPassengerAges = new GraphPassengerAges();
        graphPassengerAges.graphPassengerAges(GraphPassengerAges.getPassengersFromJsonFile());   
    }

   // Read json file and return a list containing Passenger Objects
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

    public void graphPassengerAges(List<Passenger> dataSet) {
        List<Float> pAges = dataSet.stream ().map(Passenger::getAge).collect (Collectors.toList ());
        //Using XCart to graph the Ages
        // Create Chart
        CategoryChart chart = new CategoryChartBuilder ().width (1024).height (768).title ("Age Histogram").xAxisTitle ("Age").yAxisTitle ("Count").build ();
        // Customize Chart
        Histogram hist1 = new Histogram(pAges, 8);
        chart.getStyler ().setLegendPosition (Styler.LegendPosition.InsideNW);
        chart.getStyler ().setHasAnnotations (true);
        chart.getStyler ().setStacked (true);
        // Series
        chart.addSeries ("Passenger's Ages", hist1.getxAxisData(), hist1.getyAxisData());
        // Show it
        new SwingWrapper (chart).displayChart ();
    }
}
