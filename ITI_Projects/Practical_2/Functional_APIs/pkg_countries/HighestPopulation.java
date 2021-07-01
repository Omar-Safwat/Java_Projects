import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HighestPopulation {
    public static void highestPopulation(Map<Country, List<City>> cityMap) {
       
        cityMap.entrySet()
                .stream()
                //for each entry set
                .forEach(e -> {
                    //Extract the city with highest population from the List<City>
                    City highestCity = e.getValue().stream().max(Comparator.comparingInt(City::getPopulation)).get();
                    System.out.println("\n{Country: " + e.getKey().getName() + ", City with largest population: " + highestCity.getName() + "}");
                });
    } 

    public static void main(String[] args) {
        List<City> cities = City.readFromCSV("Cities.csv");
        List<Country> countries = Country.readFromCSV("Countries.csv");
        Map<Country, List<City>> cityMap = new HashMap<>();
        
        countries.stream()
        //For each country return List of cities with same country code
        .forEach(cntry -> {
            cityMap.put(cntry, cities.stream().filter(
                                                cty -> cty.getCountryCode().equals(cntry.getCode())
                                                ).distinct().collect(Collectors.toList()));
        });
        highestPopulation(cityMap);
    }
}
