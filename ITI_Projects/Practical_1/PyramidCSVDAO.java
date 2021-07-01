import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PyramidCSVDAO {
    private List<Pyramid> pyramids;

    public PyramidCSVDAO() {
        List<Pyramid> pyramids = new ArrayList<>();
    }

    public List<Pyramid> readPyramidsFromCSV(String fileName) {
        try {
            BufferedReader buffReader;
            File file = new File(fileName);
            buffReader = new BufferedReader(new FileReader(file));
            
            // ArrayList as a Data Frame
            List<Pyramid> dataSet = new ArrayList<>();
        
            // Read column names
            String[] columns = buffReader.readLine().split(",");
            //Read the first record
            String line = buffReader.readLine();
            // Read the file
            while(line  != null) {
                String[] record = line.split(",");
                // If height is missing then skip this row
                if (record[7].equals("")) record[7] = "0";
                // Creates pyramid and adds it to dataSet
                Pyramid newPyramid = createPyramid(record);
                dataSet.add(newPyramid);
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
    
    public Pyramid createPyramid(String[] metadata) {
        Pyramid newPyramid = new Pyramid(Double.parseDouble(metadata[7]), metadata[2], metadata[0], metadata[4]); 
        return newPyramid;
    }
}
