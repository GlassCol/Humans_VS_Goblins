package src.Equipment.Weapons.Shields;

public class BronzeShield implements Shield {

    private final int defence = 2;

    @Override
    public int getDefence() {
        return defence;
    }

    @Override
    public String toString() {
        return "Bronze Shield: +2 Defence";
    }
}
