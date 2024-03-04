import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Example:  Writing to a File.
 */
public class ExampleWriter {
    public static void main(String[] args) throws IOException {
        String fileName = "hello.txt";
        System.out.println("Writing to:  " + fileName);

        //  Create the IO Classes
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        //  Write strings to file
        bufferedWriter.write("Hello, World!\n");
        bufferedWriter.write("Here is another line.");

        //  Don't forget to close the file
        bufferedWriter.close();
    }
}
