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

    /**
     * Get Movie Name.
     * @return Movie Name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get Movie Description.
     * @return Movie Description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get Image URL.
     * @return Image URL.
     */
    public String getImgUrl() {
        return imgUrl;
    }
}
