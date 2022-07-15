package src;

import javafx.scene.control.Button;
import src.Equipment.Equipment;
import src.Humanoid.Humanoid;

import java.util.ArrayList;

/**
 * The Tile class stores the data and controls for each tile in the game
 *
 * @author Cole Glass
 */

public class Tile {
    private final int xCoordinate;
    private final int yCoordinate;
    private ArrayList<Humanoid> humanoids = new ArrayList<>();
    private Button button;

    public Tile(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public boolean hasHumanoid() {
        return humanoids.size() > 0;
    }

    public boolean hasCombat() {
        return humanoids.size() > 1;
    }

    /**
     * This method has each humanoid in the humanoid list attack each other
     *
     * @return result : String
     */
    public String fight() {
        String result = "";
        int currentHP = humanoids.get(1).getCurrentHealth();
        humanoids.get(0).attack(humanoids.get(1));
        result += humanoids.get(0).getName() + " has attacked " + humanoids.get(1).getName() + " for " +
                (currentHP - humanoids.get(1).getCurrentHealth()) + " damage\n";
        if (humanoids.get(1).getCurrentHealth() <= 0) {
            result += humanoids.get(1).getName() + " has died\n";
            if (!humanoids.get(1).isHuman())
                if (humanoids.get(1).shouldDrop()) {
                    Equipment item = humanoids.get(1).drops();
                    result += item.toString() + " has dropped";
                    humanoids.get(0).pickUp(item);
                }
            humanoids.remove(1);
        } else {
            currentHP = humanoids.get(0).getCurrentHealth();
            humanoids.get(1).attack(humanoids.get(0));
            result += humanoids.get(1).getName() + " has attacked " + humanoids.get(0).getName() + " for " +
                    (currentHP - humanoids.get(0).getCurrentHealth()) + " damage\n";
            if (humanoids.get(0).getCurrentHealth() <= 0) {
                if (!humanoids.get(0).isHuman()) {
                    result += humanoids.get(0).getName() + " has died\n";
                    if (!humanoids.get(0).isHuman())
                        if (humanoids.get(0).shouldDrop()) {
                            Equipment item = humanoids.get(0).drops();
                            result += item.toString() + " has dropped";
                            humanoids.get(1).pickUp(item);
                        }
                }
                humanoids.remove(0);
            }
        }
        return result;
    }

    /**
     * Adds the humanoid to the humanoidList if viable
     *
     * @param humanoid : Humanoid
     * @return boolean
     */
    public boolean placeHumanoid(Humanoid humanoid) {
        if (!this.humanoids.contains(humanoid)) {
            this.humanoids.add(humanoid);
            return true;
        } else {
            System.out.println("Sorry that tile is occupied by an ally");
            return false;
        }
    }

    public Button getButton() {
        return this.button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public ArrayList<Humanoid> getHumanoids() {
        return this.humanoids;
    }

    public Humanoid getHuman() {
        for (Humanoid humanoid : humanoids) {
            if (humanoid.isHuman()) return humanoid;
        }
        return null;
    }

    /**
     * Removes the humanoid from the humanoidList
     *
     * @param humanoid : Humanoid
     */
    //START HERE!!!!!!! REMOVE NEEDS TO BE FIXED
    public void removeHumanoid(Humanoid humanoid) {
        this.humanoids.remove(humanoid);
    }

    @Override
    public String toString() {
        if (humanoids.size() == 1) {
            if (humanoids.get(0).isHuman()) return "H";
            return "G";
        }
        if (humanoids.size() > 1) return "C";
        return "   ";
    }

    public String printAllHumanoids() {
        String string = "";
        for (Humanoid humanoid : humanoids) {
            string += humanoid.toString() + "\n";
        }
        return string;
    }

    public Integer getYCoordinate() {
        return this.yCoordinate;
    }

    public Integer getXCoordinate() {
        return this.xCoordinate;
    }
}
