package com.example.hvg.equipment.armors;

public class ClothArmor implements Armor {
    private final int defence = 1;

    @Override
    public int getDefence() {
        return this.defence;
    }

    @Override
    public String toString() {
        return "Cloth Armor: +1 Defence";
    }
}
