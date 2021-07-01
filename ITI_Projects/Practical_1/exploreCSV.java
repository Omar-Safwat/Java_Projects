import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class exploreCSV {
    public static void main(String[]args) {
        try {
            BufferedReader buffReader;
            File file = new File("pyramids.csv");
            buffReader = new BufferedReader(new FileReader(file));
        
            // Read the first 4 lines
            List<String[]> dataSet = new ArrayList<>();

            for(int i=0; i < 4; ++i) {
                String line = buffReader.readLine();
                String[] record = line.split(",");
                dataSet.add(record);
            }

            //Print first line "header"
            System.out.print("\nColumns: \n");
            for(String word : dataSet.get(0)) {
                System.out.print(word + ", ");
            }
            buffReader.close();
        } 
        catch(FileNotFoundException fileEx) {
            System.out.println("File exception");
        } 
        catch(IOException ioEx) {
            System.out.println("IO Exception");
        }
    }
}
