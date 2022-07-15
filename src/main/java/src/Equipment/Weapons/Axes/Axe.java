package src.Equipment.Weapons.Axes;

import src.Equipment.Weapons.Weapon;

public interface Axe extends Weapon {

    @Override
    default boolean isAxe() {
        return true;
    }
}
