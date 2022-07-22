package com.example.hvg.equipment;

public interface Equipment {
    /**
     * Gets the attacking strength of the equipment
     *
     * @return strength : int
     */
    default int getStrength() {
        return 0;
    }

    /**
     * Gets the defensive ability of the item
     *
     * @return 0 : int
     */
    default int getDefence() {
        return 0;
    }

    /**
     * Displays the equipment and all of it's stats
     *
     * @return string : String
     */
    @Override
    String toString();

}
