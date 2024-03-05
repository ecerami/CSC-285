package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Write Text to File.
 */
public class TextWriter {
    private final File file;
    private final String[] text;

    /**
     * Constructor.
     *
     * @param file File object.
     * @param text Text to write out.
     */
    public TextWriter(File file, String[] text) {
        this.file = file;
        this.text = text;
    }

    /**
     * Write contents to file.
     *
     * @throws IOException IO Error.
     */
    public void write() throws IOException {
        //  Create the IO Classes
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        //  Write text to file
        for (String line : text) {
            bufferedWriter.write(line + "\n");
        }

        //  Don't forget to close
        bufferedWriter.close();
    }

    /**
     * Main Runner.
     */
    public static void main(String[] args) throws IOException {
        File file = new File("text.txt");
        String[] text = {"You may write me down in history", "With your bitter, twisted lies,",
                "You may trod me in the very dirt", "But still, like dust, I'll rise."};
        TextWriter textWriter = new TextWriter(file, text);
        textWriter.write();
        System.out.println("All done.  Contents written to:  " + file);
    }
}