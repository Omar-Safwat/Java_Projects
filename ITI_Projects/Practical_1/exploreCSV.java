import java.util.List;

public class exploreCSV implements ReaderCSV{
    
    public static void main(String[]args) {
        List<String[]> dataSet = ReaderCSV.readCSV("pyramids.csv");

        //Print first line "header"
        System.out.print("\nColumns: \n");
        for(String word : dataSet.get(0)) {
            System.out.print(word + ", ");
        }
    }
}
