package com.example.hvg;

/**
 * This class implements the singleton pattern to hold settings details for the game
 *
 * @author Cole Glass
 */
public class Settings {
    private static Settings settings = new Settings();
    private final int DEFAULT_SIZE = 10;
    private final int DEFAULT_NUMBER = 5;
    private int boardSize = getDEFAULT_SIZE();
    private int numberOfHumans = getDEFAULT_NUMBER();
    private int numberOfGoblins = getDEFAULT_NUMBER();

    private Settings() {
    }

    public static Settings getSettings() {
        return settings;
    }

    public int getDEFAULT_SIZE() {
        return DEFAULT_SIZE;
    }

    public int getDEFAULT_NUMBER() {
        return DEFAULT_NUMBER;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public int getNumberOfHumans() {
        return numberOfHumans;
    }

    public void setNumberOfHumans(int numberOfHumans) {
        this.numberOfHumans = numberOfHumans;
    }

    public int getNumberOfGoblins() {
        return numberOfGoblins;
    }

    public void setNumberOfGoblins(int numberOfGoblins) {
        this.numberOfGoblins = numberOfGoblins;
    }
}
