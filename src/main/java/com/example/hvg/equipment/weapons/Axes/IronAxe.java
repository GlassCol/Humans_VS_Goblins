package com.example.hvg.equipment.weapons.Axes;

public class IronAxe implements Axe {

    private final int strength = 3;

    /**
     * Gets the strength of this weapon
     *
     * @return this.Strength : int
     */
    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public String toString() {
        return "Iron Axe: +3 Strength";
    }
}
