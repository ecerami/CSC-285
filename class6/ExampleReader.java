import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Example:  Reading from a file.
 */
public class ExampleReader {

    public static void main(String[] args) throws IOException {
        String fileName = "hello.txt";
        System.out.println("Reading from:  " + fileName);

        // Create the IO Classes
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        //  Read in the Lines
        String line = bufferedReader.readLine();
        while (line != null) {
            System.out.println(line);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
    }
}
