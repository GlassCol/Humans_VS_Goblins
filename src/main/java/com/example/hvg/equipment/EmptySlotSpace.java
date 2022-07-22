package com.example.hvg.equipment;

/**
 * This class exists solely to initialize the player's inventory with empty slots which can be displayed as such
 *
 * @author Cole Glass
 */
public class EmptySlotSpace implements Equipment {
    @Override
    public String toString() {
        return "Empty Slot";
    }
}
