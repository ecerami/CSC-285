package org.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Serializes Products to a File.
 */
public class ProductWriter {
    private final File file;
    private final ArrayList<Product> productList;

    /**
     * Constructor.
     *
     * @param file        File.
     * @param productList Product List.
     */
    public ProductWriter(File file, ArrayList<Product> productList) {
        this.file = file;
        this.productList = productList;
    }

    public void write() throws IOException {
        //  Create the IO Classes
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutStream = new ObjectOutputStream(fileOutputStream);

        //  Write Products to File
        objectOutStream.writeObject(productList);

        //  Don't forget to close the file
        objectOutStream.close();
    }

    /**
     * Main Runner.
     */
    public static void main(String[] args) throws IOException {
        File file = new File("products.raw");
        Product product1 = new Product("iPad Pro", "Electronics", 1099.00);
        Product product2 = new Product("iPad Mini", "Electronics", 599.00);
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        ProductWriter writer = new ProductWriter(file, productList);
        writer.write();
        System.out.println("Contents written to:  " + file);
    }
}
