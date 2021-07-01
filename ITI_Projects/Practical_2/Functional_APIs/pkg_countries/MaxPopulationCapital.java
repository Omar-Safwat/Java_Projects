import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MaxPopulationCapital {
    public static void maxPopulationCapital(List<Country> countries, List<City> cities) {

        Map<Country, City> capitalMap = new HashMap<>();

        // Map each country to its capital city (as objects)
        for(Country cntry : countries) {
            capitalMap.put(cntry, cities.get(cntry.getCapital()));
        }

        System.out.println(
            //Stream Each map entry
            capitalMap.entrySet().stream()
            //Collect Capital with max population
            .collect(
                // Compare City objects by attribute population
                Collectors.maxBy(
                    Map.Entry.comparingByValue(
                        Comparator.comparingInt(City::getPopulation)
                        )
                )
            ).get()); 
    } 
    
    public static void main(String[] args) {
        List<City> cities = City.readFromCSV("Cities.csv");
        List<Country> countries = Country.readFromCSV("Countries.csv");
        maxPopulationCapital(countries, cities);
    }
}
