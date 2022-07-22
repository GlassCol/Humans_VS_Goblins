package com.example.hvg.equipment.armors;


import com.example.hvg.equipment.Equipment;

public interface Armor extends Equipment {

    default boolean isArmor() {
        return true;
    }

}
