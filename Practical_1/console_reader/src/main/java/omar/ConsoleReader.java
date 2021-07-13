package omar;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader buffReader = new BufferedReader(reader);

        //Output file
        File output = new File("src/main/java/omar/OutputFile.txt");
        BufferedWriter buffWriter = new BufferedWriter(new FileWriter(output));
        
        while(true){
            System.out.println("Enter data:");
            String userInput = buffReader.readLine();
            buffWriter.write(userInput+"\n");
            System.out.println("Your data: " + userInput);
            if (userInput.equalsIgnoreCase("stop")) break;
        }
        buffWriter.close();
    }
}