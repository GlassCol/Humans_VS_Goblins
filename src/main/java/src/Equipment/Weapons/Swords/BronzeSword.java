package src.Equipment.Weapons.Swords;

public class BronzeSword implements Sword {

    private final int strength = 2;

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public String toString() {
        return "Bronze Sword: +2 Strength";
    }
}

