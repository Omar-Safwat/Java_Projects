import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Country implements ReaderCSV{
    private String code, name,continent;
    private int population, capital;
    private double area, gpd;

    public Country(String code, String name, String continent, int population, double area, double gpd, int capital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.capital = capital;
        this.area = area;
        this.gpd = gpd;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getGpd() {
        return gpd;
    }

    public void setGpd(double gpd) {
        this.gpd = gpd;
    }

    public static Country createCountry(String[] meta) {
        return new Country(meta[0], meta[1], meta[2], Integer.parseInt(meta[3]), Double.parseDouble(meta[4]), Double.parseDouble(meta[5]), Integer.parseInt(meta[6]));
    }

    public static List<Country> readFromCSV(String fileName) {

        List<String[]> records = ReaderCSV.readCSV(fileName);
        List<Country> dataSet = new ArrayList<>();

        for(String[] row : records) {
            Country newObject = Country.createCountry(row);
            boolean skip = false;

            for(int j = 3; j < row.length; j++) {
                // Rows with numbers less than 0 are skipped
                if((int) Double.parseDouble(row[j]) < 1) {
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
