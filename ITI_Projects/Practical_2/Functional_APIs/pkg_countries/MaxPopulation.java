import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MaxPopulation {
    public static void maxPopulation(List<Country> countries) {
        // List of countries population
        System.out.println("\nCountry with max population: " + 
        countries.stream().max(Comparator.comparingDouble(Country::getPopulation)).get());
    } 

    public static void main(String[] args) {
        List<Country> countries = Country.readFromCSV("Countries.csv");
        maxPopulation(countries);
    }    
}
