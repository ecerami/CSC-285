package org.example;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Read Primitive Data Types from File.
 */
public class PrimitiveReader {
    private final File file;
    private final double[] data;

    /**
     * Constructor.
     *
     * @param file File.
     */
    public PrimitiveReader(File file) throws IOException {
        this.file = file;

        //  Create the IO Classes
        FileInputStream inputStream = new FileInputStream(file);
        DataInputStream dataReader = new DataInputStream(inputStream);

        //  Read size of array from file
        int arraySize = dataReader.readInt();
        this.data = new double[arraySize];

        //  Read in the array
        for (int i = 0; i < arraySize; i++) {
            double value = dataReader.readDouble();
            this.data[i] = value;
        }

        //  Don't forget to close the file
        dataReader.close();
    }

    /**
     * Get Data.
     *
     * @return ArrayList of Double Objects.
     */
    public double[] getData() {
        return data;
    }

    /**
     * Main Runner.
     */
    public static void main(String[] args) throws IOException {
        File file = new File("data.raw");
        PrimitiveReader reader = new PrimitiveReader(file);
        double[] data = reader.getData();
        for (double item : data) {
            System.out.println(item);
        }
    }
}
