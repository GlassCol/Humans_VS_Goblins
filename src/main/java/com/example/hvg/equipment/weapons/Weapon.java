package com.example.hvg.equipment.weapons;

import com.example.hvg.equipment.Equipment;

public interface Weapon extends Equipment {
    //here for potential future use
    default boolean isWeapon(){return true;}
}
