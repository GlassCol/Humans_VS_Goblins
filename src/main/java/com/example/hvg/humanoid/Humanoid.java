package com.example.hvg.humanoid;

import com.example.hvg.equipment.Equipment;

/**
 * The Humanoid interface is the main class which will be iterated over in the game
 *
 * @author Cole Glass
 */
public interface Humanoid {
    /**
     * Attacks the humanoid passed to the method and then returns it
     *
     * @param humanoid : Humanoid
     * @return humanoid : Humanoid
     */
    Humanoid attack(Humanoid humanoid);

    /**
     * returns the current health of a humanoid
     *
     * @return health : int
     */
    int getCurrentHealth();

    /**
     * returns the humanoid's name
     *
     * @return name : String
     */
    String getName();

    /**
     * Determines whether a drop should drop
     *
     * @return boolean
     */
    default boolean shouldDrop() {
        return false;
    }

    /**
     * returns the starting health of a humanoid
     *
     * @return startingHP : int
     */
    int getStartingHealth();

    /**
     * Sets the health of a humanoid
     * @param i : int
     */
    void setHealth(int i);

    /**
     * returns the strength of the humanoid
     *
     * @return strength : int
     */
    int getStrength();

    /**
     * Returns whether the humanoid is a human
     *
     * @return false : boolean
     */
    default boolean isHuman() {
        return false;
    }

    /**
     * Gets the defence of the humanoid (default returns 0 as goblins do not have armor)
     *
     * @return defence : int
     */
    default int getDefence() {
        return 0;
    }

    int getXCoordinate();

    int getYCoordinate();

    /**
     * Returns a drop when the humanoid dies
     *
     * @return drop : Equipment
     */
    Equipment drops();

    /**
     * picks up dropped equipment (Does nothing if not human)
     *
     * @param drop : Drop
     */
    default void pickUp(Equipment drop) {}

}
