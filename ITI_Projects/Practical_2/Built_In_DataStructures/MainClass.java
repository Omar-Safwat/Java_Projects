import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass {
    public static void main(String[] args) {
        PyramidCSVDAO pDAO = new PyramidCSVDAO();
        List<Pyramid> pyramids = pDAO.readPyramidsFromCSV("pyramids.csv");
        
        // Sort the pyramids List
        Collections.sort(pyramids);
        int i = 0;
        System.out.println("\nData set:\n");
        for(Pyramid p : pyramids) {
            System.out.println("# " + (i++) + " " + p);
        }

        // Map each Site to number of pyramids
        Map<String, Integer> siteHash = new HashMap<>();

        for(Pyramid p : pyramids) {
            String site = p.getSite();
            // If HashMap already contains the key, then incement it
            int val = siteHash.containsKey(site) ? siteHash.get(site) : 0;
            siteHash.put(site, val + 1);
        }

        // Print the HashMap to screen
        System.out.println("\nMap:\n" + siteHash);
    }
}