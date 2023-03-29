package edu.bhcc;

/**
 * Encapsulate a Movie.
 */
public class Movie {
    private String name;
    private String description;
    private String imgUrl;

    /**
     * Constructor.
     */
    public Movie(String name, String description, String imgUrl) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
