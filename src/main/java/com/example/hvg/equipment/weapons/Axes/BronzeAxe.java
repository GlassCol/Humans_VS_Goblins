package com.example.hvg.equipment.weapons.Axes;

public class BronzeAxe implements Axe {
    private final int strength = 2;

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public String toString() {
        return "Bronze Axe: +2 Strength";
    }
}
