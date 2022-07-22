package com.example.hvg.equipment.armors;

public class IronArmor implements Armor {
    private final int defence = 3;

    @Override
    public int getDefence() {
        return this.defence;
    }

    @Override
    public String toString() {
        return "Iron Armor: +3 Defence";
    }
}
