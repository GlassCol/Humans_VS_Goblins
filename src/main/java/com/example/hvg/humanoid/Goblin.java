package com.example.hvg.humanoid;

import com.example.hvg.equipment.Drops;
import com.example.hvg.equipment.Equipment;

import java.util.Random;

/**
 * The Goblin class stores all data and controls for goblins
 *
 * @author Cole Glass
 */
public class Goblin implements Humanoid {
    private final int startingHP;
    private final Random rand = new Random();
    private final int strength;
    private final String name;
    private final String color;
    private int health;
    private int xCoordinate, yCoordinate;
    private final Drops drop = new Drops();

    public Goblin(int strength, String name, String color, int startingHP, int x, int y) {
        this.strength = strength;
        this.name = name;
        this.color = color;
        this.startingHP = startingHP;
        this.health = startingHP;
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    /**
     * returns the strength of this goblin plus their equipment
     *
     * @return strength : int
     */
    @Override
    public int getStrength() {
        return strength;
    }

    /**
     * Attacks the human that was passed to the method and returns it
     *
     * @param human : Humanoid
     * @return human : Humanoid
     */
    @Override
    public Humanoid attack(Humanoid human) {
        Random rand = new Random();
        int randDam = rand.nextInt(5);
        //check to ensure you aren't healing
        if ((this.getStrength() + randDam - human.getDefence()) >= 0)
            human.setHealth(human.getCurrentHealth() - ((this.getStrength() + randDam) - human.getDefence()));
        return human;
    }

    @Override
    public int getXCoordinate() {
        return xCoordinate;
    }

    @Override
    public int getYCoordinate() {
        return yCoordinate;
    }

    /**
     * Determines whether the goblin should drop equipment
     *
     * @return boolean
     */
    @Override
    public boolean shouldDrop() {
        return rand.nextInt(10) <= 3;
    }

    /**
     * Returns a drop when the humanoid dies
     *
     * @return drop : Equipment
     */
    @Override
    public Equipment drops() {
        return drop.getDroppedItem();
    }

    @Override
    public void setXCoordinate(int x) {
        this.xCoordinate = x;
    }

    @Override
    public void setYCoordinate(int y) {
        this.yCoordinate = y;
    }

    @Override
    public int getCurrentHealth() {
        return health;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStartingHealth() {
        return startingHP;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "Name : " + this.name + "\n" + "Health : " + this.health + "/" + this.startingHP +
                "\n" + "Strength : " + this.strength + "\n" + "Color : " + this.color;
    }
}
