package com.example.hvg.equipment.weapons.Swords;

import com.example.hvg.equipment.weapons.Weapon;

public interface Sword extends Weapon {
    int getStrength();

    /**
     * Returns the defence rating of a sword of which the default is 1. (Might change for other in future)
     *
     * @return 1 : int
     */
    default int getDefence() {
        return 1;
    }

}
