package src.Equipment.Weapons.Swords;

public class WoodenSword implements Sword {
    private final int strength = 1;

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public boolean isSword() {
        return true;
    }

}
