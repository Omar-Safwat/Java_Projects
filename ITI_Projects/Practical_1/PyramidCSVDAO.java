import java.util.ArrayList;
import java.util.List;

public class PyramidCSVDAO implements ReaderCSV{
    private List<Pyramid> pyramids;

    public PyramidCSVDAO() {
        List<Pyramid> pyramids = new ArrayList<>();
    }

    public List<Pyramid> readPyramidsFromCSV(String fileName) {
        List<String[]> records = ReaderCSV.readCSV(fileName);
        List<Pyramid> dataSet = new ArrayList<>();

        for(String[] row : records) {
            Pyramid newObject = this.createPyramid(row);

                // Heights less than 1 are skipped
                if((int) Double.parseDouble(row[7]) >= 1) dataSet.add(newObject); 
            }
        return dataSet;
        }

    public Pyramid createPyramid(String[] metadata) {
        Pyramid newPyramid = new Pyramid(Double.parseDouble(metadata[7]), metadata[2], metadata[0], metadata[4]); 
        return newPyramid;
    }
}
