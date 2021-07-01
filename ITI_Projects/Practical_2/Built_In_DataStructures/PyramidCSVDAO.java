import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PyramidCSVDAO implements ReaderCSV{
    private List<Pyramid> pyramids;

    public PyramidCSVDAO() {
        List<Pyramid> pyramids = new ArrayList<>();
    }
    
    public Pyramid createPyramid(String[] metadata) {
        return new Pyramid(Double.parseDouble(metadata[7]), metadata[2], metadata[0], metadata[4]); 
    }

    public List<Pyramid> readPyramidsFromCSV(String fileName) {
        List<String[]> records = ReaderCSV.readCSV(fileName);
        List<Pyramid> dataSet = new ArrayList<>();

        for(String[] row : records) {
            Pyramid newPyramid = createPyramid(row);
            boolean skip = false;
            // Rows with heights less than 1 are skipped
            if((int) Double.parseDouble(row[7]) < 1) {
                continue;
                }
            dataSet.add(newPyramid); 
            }
        return dataSet;    
        }
}
