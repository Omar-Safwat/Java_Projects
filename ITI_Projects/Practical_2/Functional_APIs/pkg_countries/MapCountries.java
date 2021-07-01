import java.util.Comparator;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapCountries {
       
    public static void main(String[] args) throws IOException {
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
                        
        // Print The mapping of Country code to list of Cities                                
        cityMap.forEach((k, v) -> System.out.println("{Key: " + k.getCode() + ", value: " + v + "}\n"));
    
        // Sort according to code
        // Read from console  
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader buffReader = new BufferedReader(reader);
        System.out.println("\nEnter a Country Code and I will return its cities ordered according to population:");
        //Map each country to its code
        Map<String, Country> codeMap = new HashMap<>();
        countries.stream()
                .forEach(cntry -> codeMap.put(cntry.getCode(), cntry));
        
        String userInput = buffReader.readLine();


        List<City> sortedCities = cityMap.get(codeMap.get(userInput))
                                    .stream()
                                    .sorted(Comparator.comparingInt(City::getPopulation)).distinct().collect(Collectors.toList());

        sortedCities.forEach(System.out::println);
    }        
}
