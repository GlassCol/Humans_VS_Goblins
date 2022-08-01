package com.example.hvg.equipment.weapons.Swords;

public class IronSword implements Sword {

    private final int strength = 3;

    @Override
    public int getStrength() {
        return this.strength;
    }
    @Override
    public String toString() {
        return "Iron Sword: +3 Strength";
    }
}

