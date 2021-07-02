package omar.data_summary;
import java.io.IOException;
import tech.tablesaw.*;
import tech.tablesaw.api.Table;
import joinery.*;

public class TitanicEDA {
    public TitanicEDA(){

    }

    public static void main(String[] args) throws IOException {

        String filePath = "src/main/resources/data/titanic.csv";
        // Basic data exploration using Joinery package
        DataFrame<Object> df = DataFrame.readCsv(filePath);
        System.out.println("\nJoinery DataFrame output:\n");
        System.out.println("Columns: " + df.columns() + "\n");
        System.out.println("DataFrame shape: " + "(" +df.length() + ", " + df.size() + ")\n");
        DataFrame<Object> numericCols = df.retain("survived", "age", "fare"); 
        System.out.println(numericCols.describe());

        //Using Tablesaw package
        System.out.println("\nTableSaw package output:\n");
        Table titanicTbl = Table.read().csv(filePath);
        System.out.println(titanicTbl.structure());
        
        System.out.println("\nTable dimensions: " + titanicTbl.shape());
        System.out.println("\nTable Summary: " + titanicTbl.select("survived", "age", "fare").summary()); 
    }
}