package src.Equipment.Weapons.Swords;

import src.Equipment.Weapons.Weapon;

public interface Sword extends Weapon {

    /**
     * Returns the defence rating of a sword of which the default is 1. (Might change for other in future)
     *
     * @return 1 : int
     */
    default int getDefence() {
        return 1;
    }

}
