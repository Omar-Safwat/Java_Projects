package omar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface ReaderCSV {

    public static List<String[]> readCSV(String fileName) {
        try {
            BufferedReader buffReader;
            File file = new File(fileName);
            buffReader = new BufferedReader(new FileReader(file));
            
            List<String[]> dataSet = new ArrayList<>();
            // Skip column names
            buffReader.readLine();
            //Read the first record
            String line = buffReader.readLine();
            // Read the file
            while(line  != null) {
                String[] record = line.split(",");
                // Strip leading and trailing Whitespace
                for(int i = 0; i < record.length; i++) record[i] = record[i].strip();
                // If there is a missing value then skip row
                if (Arrays.stream(record).allMatch(col -> !col.isEmpty())){
                    dataSet.add(record);
                    line = buffReader.readLine();
                    continue;  
                } 
                line = buffReader.readLine();
            }
            buffReader.close();
            return dataSet;
        } 
        catch(FileNotFoundException fileEx) {
            System.out.println("File exception");
            return null;
        } 
        catch(IOException ioEx) {
            System.out.println("IO Exception");
            return null;
        }
    }
}
