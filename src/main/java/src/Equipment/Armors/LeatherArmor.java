package src.Equipment.Armors;

public class LeatherArmor implements Armor {
    private final int defence = 2;

    @Override
    public int getDefence() {
        return this.defence;
    }

    @Override
    public String toString() {
        return "Brass Armor: +2 Defence";
    }
}
