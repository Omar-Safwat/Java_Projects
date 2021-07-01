import java.util.List;

public class ListPopulation {
    public static void listPopulation(List<Country> countries) {
        // List of countries population
        countries.stream().forEach(c -> System.out.println("\n{Country: " + c.getName() + ", Population: " + (long) c.getPopulation()));
    }

    public static void main(String[] args) {
        List<Country> countries = Country.readFromCSV("Countries.csv");
        listPopulation(countries);
    }
}
