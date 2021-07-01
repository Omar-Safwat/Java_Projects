import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        PyramidCSVDAO pyramidDAO = new PyramidCSVDAO();
        List<Pyramid> pyramids = pyramidDAO.readPyramidsFromCSV("pyramids.csv");
        
        int i = 0;
        for(Pyramid p : pyramids) {
            System.out.println("# " + (i++) + " " + p);
        }
    }
}