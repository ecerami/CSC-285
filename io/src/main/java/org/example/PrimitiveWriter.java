package org.example;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Write Primitive Data Types to File.
 */
public class PrimitiveWriter {
    private final File file;
    private final double[] data;

    /**
     * Constructor.
     *
     * @param file File output.
     * @param data Data to write out.
     */
    public PrimitiveWriter(File file, double[] data) {
        this.file = file;
        this.data = data;
    }

    /**
     * Write the data to file.
     *
     * @throws IOException IO Error.
     */
    public void write() throws IOException {
        //  Create the IO Classes
        FileOutputStream outputStream = new FileOutputStream(this.file);
        DataOutputStream dataWriter = new DataOutputStream(outputStream);

        //  Write the size of the array
        dataWriter.writeInt(this.data.length);

        //  Write double data to file
        for (double number : this.data) {
            dataWriter.writeDouble(number);
        }

        //  Don't forget to close the file
        dataWriter.close();
    }

    /**
     * Main Runner.
     */
    public static void main(String[] args) throws IOException {
        File file = new File("data.raw");
        double[] data = {43, 432, 3432, 74, 21, 54};
        PrimitiveWriter writer = new PrimitiveWriter(file, data);
        writer.write();
        System.out.println("Data written to:  " + file);
    }
}
