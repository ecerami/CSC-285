package org.example;

import java.io.Serializable;

/**
 * Product Class.
 */
public class Product implements Serializable {
    public String name;
    public String category;
    public double price;

    /**
     * Constructor.
     *
     * @param name     Product Name, e.g. iPad.
     * @param category Product Category, e.g. Electronics.
     * @param price    Product Price, e.g. 499.00.
     */
    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
}
