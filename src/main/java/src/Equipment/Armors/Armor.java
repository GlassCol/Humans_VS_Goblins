package src.Equipment.Armors;

import src.Equipment.Equipment;

public interface Armor extends Equipment {

    @Override
    default boolean isArmor() {
        return true;
    }

}
