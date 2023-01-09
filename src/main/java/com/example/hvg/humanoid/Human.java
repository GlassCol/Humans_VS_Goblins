package com.example.hvg.humanoid;

import com.example.hvg.equipment.EmptySlotSpace;
import com.example.hvg.equipment.Equipment;

import java.util.ArrayList;
import java.util.Random;

/**
 * The Human class stores all data and controls for human
 *
 * @author Cole Glass
 */
public class Human implements Humanoid {
    private final int startingHP;
    private final int strength;
    private final String name;
    private final String color;
    private int health;
    private int xCoordinate, yCoordinate;
    private Equipment[] equippedEquipment = new Equipment[3];
    private ArrayList<Equipment> equipment = new ArrayList<>();
    private final Equipment emptySpace = new EmptySlotSpace();

    public Human(int strength, String name, String color, int startingHP
            , int xCoordinate, int yCoordinate) {
        this.strength = strength;
        this.name = name;
        this.color = color;
        this.startingHP = startingHP;
        this.health = startingHP;
        for (int i = 0; i < equippedEquipment.length; i++) {
            this.equippedEquipment[i] = emptySpace;
            this.xCoordinate = xCoordinate;
            this.yCoordinate = yCoordinate;
        }
    }

    /**
     * returns the strength of this human plus their equipment
     *
     * @return strength : int
     */
    @Override
    public int getStrength() {
        int weaponStrength = 0;
        for (Equipment equipment : equippedEquipment) {
            weaponStrength += equipment.getStrength();
        }
        return strength + weaponStrength;
    }

    /**
     * Returns whether the humanoid is a human
     *
     * @return true : boolean
     */
    @Override
    public boolean isHuman() {
        return true;
    }

    /**
     * Gets the defence of the humanoid
     *
     * @return defence : int
     */
    @Override
    public int getDefence() {
        int defenceStrength = 0;
        for (Equipment equipment : equippedEquipment) {
            defenceStrength += equipment.getDefence();
        }
        return defenceStrength;
    }

    /**
     * returns the current health of this human
     *
     * @return health : int
     */
    @Override
    public int getCurrentHealth() {
        return health;
    }

    @Override
    public String getName() {
        return this.name;
    }

    /**
     * returns the starting health of this human
     *
     * @return startingHP : int
     */
    @Override
    public int getStartingHealth() {
        return startingHP;
    }

    /**
     * Sets the health of this human
     *
     * @param health : int
     */
    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Attacks the goblin passed to the method and then returns it
     *
     * @param goblin : Humanoid
     * @return goblin : Humanoid
     */
    @Override
    public Humanoid attack(Humanoid goblin) {
        Random rand = new Random();
        int randDam = rand.nextInt(5);
        //check to ensure you aren't healing
        if ((this.getStrength() + randDam - goblin.getDefence()) >= 0)
            goblin.setHealth(goblin.getCurrentHealth() - (this.getStrength() + randDam));
        return goblin;
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
     * Returns a drop when the humanoid dies
     *
     * @return drop : Equipment
     */
    @Override
    public Equipment drops() {
        return null;
    }

    /**
     * picks up dropped equipment
     *
     * @param drop : Drop
     */
    @Override
    public void pickUp(Equipment drop) {
        if (equippedEquipment[0] == emptySpace) equippedEquipment[0] = drop;
        else if (equippedEquipment[1] == emptySpace) equippedEquipment[1] = drop;
        else if (equippedEquipment[2] == emptySpace) equippedEquipment[2] = drop;
        equipment.add(drop);
    }

    @Override
    public void setXCoordinate(int x) {
        this.xCoordinate = x;
    }

    @Override
    public void setYCoordinate(int y) {
        this.yCoordinate = y;
    }

    /**
     * Returns all characteristics of this human in a string
     *
     * @return characteristics : String
     */
    @Override
    public String toString() {
        return "Name : " + this.name + "\n" + "Health : " + this.health + "/" + this.startingHP + "\n" + "Strength : "
                + this.strength + "\n" + "Color : " + this.color
                + "\nINVENTORY\n" + equippedEquipment[0].toString() + "\n" + equippedEquipment[1].toString()
                + "\n" + equippedEquipment[2].toString();
    }
}
