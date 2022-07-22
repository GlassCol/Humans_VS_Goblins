package com.example.hvg.equipment.weapons.Shields;

public class WoodenShield implements Shield {
    private final int defence = 1;

    @Override
    public int getDefence() {
        return defence;
    }

    @Override
    public String toString() {
        return "Wooden Shield: +1 Defence";
    }
}
