package edu.bhcc;

/**
 * Human Class used in Role Playing Game (RPG).
 */
public class Human {
    private final String name;
    private int numHitPoints;

    /**
     * Constructor.
     *
     * @param name         Character Name.
     * @param numHitPoints Initial number of hit points.
     */
    public Human(String name, int numHitPoints) {
        this.name = name;
        this.numHitPoints = numHitPoints;
    }

    /**
     * Get Character Name.
     *
     * @return character name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get Current Number of Hit Points.
     *
     * @return current number of hit points.
     */
    public int getNumHitPoints() {
        return numHitPoints;
    }

    /**
     * Take Damage.
     *
     * @param damage number of points of damage.
     */
    public void takeDamage(int damage) {
        this.numHitPoints -= damage;
    }
}