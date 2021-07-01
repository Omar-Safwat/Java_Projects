import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class City {
    private int id, population;
    private String name, countryCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public City(int id, int population, String name, String countryCode) {
        this.id = id;
        this.population = population;
        this.name = name;
        this.countryCode = countryCode;
    }

    public static City createCity(String[] meta) {
        return new City(Integer.parseInt(meta[0]), Integer.parseInt(meta[2]), meta[1], meta[3]);
    }

    public static List<City> readFromCSV(String fileName) {

        List<String[]> records = ReaderCSV.readCSV(fileName);
        List<City> dataSet = new ArrayList<>();

        for(String[] row : records) {
            City newObject = City.createCity(row);
            boolean skip = false;
            for(int j = 0; j < 3; j = j + 2) {
                // Rows with numbers less than 0 are skipped
                if(Integer.parseInt(row[j]) < 0) {
                    skip = true;
                    break;
                }
                if(!skip) dataSet.add(newObject);
            }
        }
        return dataSet;
    }

    @Override
    public String toString() {
        return name;
    }
}
