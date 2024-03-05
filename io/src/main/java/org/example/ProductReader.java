package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Reads Serialized Products from File.
 */
public class ProductReader {
    private final ArrayList<Product> productList;

    /**
     * Constructor.
     *
     * @param file File.
     * @throws IOException            IO Error.
     * @throws ClassNotFoundException Serialization Error.
     */
    public ProductReader(File file) throws IOException, ClassNotFoundException {
        //  Create the IO Classes
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        //  Read Student from File
        productList = (ArrayList<Product>) objectInputStream.readObject();

        //  Don't forget to close the file
        objectInputStream.close();
    }

    /**
     * Main Runner.
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("products.raw");
        ProductReader reader = new ProductReader(file);
        ArrayList<Product> productList = reader.getProductList();
        for (Product product : productList) {
            System.out.println(product.name);
            System.out.println(product.category);
            System.out.println(product.price);
            System.out.println("------------");
        }

    }

    /**
     * Get the Product List.
     *
     * @return ArrayList of Product Objects.
     */
    public ArrayList<Product> getProductList() {
        return productList;
    }
}
