package src.Equipment.Weapons.Shields;

public class IronShield implements Shield {

    private final int defence = 3;

    @Override
    public int getDefence() {
        return defence;
    }

    @Override
    public String toString() {
        return "Iron Shield: +3 Defence";
    }
}
