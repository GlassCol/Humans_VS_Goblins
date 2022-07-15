package src.Equipment.Weapons.Axes;

public class StoneAxe implements Axe {
    private final int strength = 1;

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public String toString() {
        return "Stone Axe: +1 Strength";
    }
}
