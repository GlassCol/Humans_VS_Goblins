package src.Equipment.Weapons;

import src.Equipment.Equipment;

public interface Weapon extends Equipment {

    /**
     * Returns whether this is a weapon
     *
     * @return true : boolean
     */
    @Override
    default boolean isWeapon() {
        return true;
    }

    /**
     * Returns whether this is a sword
     *
     * @return boolean
     */
    default boolean isSword() {
        return false;
    }

    /**
     * Returns whether this is a shield
     *
     * @return boolean
     */
    default boolean isShield() {
        return false;
    }

    /**
     * Returns whether this is an axe
     *
     * @return boolean
     */
    default boolean isAxe() {
        return false;
    }
}
