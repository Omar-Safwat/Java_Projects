import java.util.List;
import java.util.stream.Collectors;

public class AvgPopulation {
    public static void avgPopulation(List<Country> countries) {
        // List of countries population
        System.out.println("\nAverage Population across all countries: " + 
        countries.stream().collect(Collectors.averagingDouble(Country::getPopulation)).longValue());
    }

    public static void main(String[] args) {
        List<Country> countries = Country.readFromCSV("Countries.csv");
        avgPopulation(countries);
    }
}
