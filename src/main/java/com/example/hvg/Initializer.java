package com.example.hvg;

import com.example.hvg.humanoid.Goblin;
import com.example.hvg.humanoid.Human;
import com.example.hvg.humanoid.Humanoid;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This deals with initializing the game
 *
 * @author Cole Glass
 */
public class Initializer {
    ArrayList<Humanoid> humanList = new ArrayList<>();
    ArrayList<Humanoid> goblinList = new ArrayList<>();


    /**
     * Initializes all humanoids in the game
     *
     * @param numOfHumans  : int
     * @param numOfGoblins : int
     * @param gameSize     : int
     * @return humanoidList : ArrayList<ArrayList<Humanoid>>
     */
    public ArrayList<ArrayList<Humanoid>> initializeHumanoids(int numOfHumans, int numOfGoblins, int gameSize) {
        ArrayList<ArrayList<Humanoid>> humanoidList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < numOfHumans; i++) {
            String name = getHumanName();
            //check for name duplicates
            while (doesNameExist(name, humanList)) {
                name = getHumanName();
            }
            Humanoid human = new Human(5, name, "Pink", (10 + rand.nextInt(10)),
                    i, 0);
            humanList.add(human);
        }
        for (int i = 0; i < numOfGoblins; i++) {
            String name = getGoblinName();
            while (doesNameExist(name, goblinList)) {
                name = getGoblinName();
            }
            Humanoid goblin = new Goblin(5, name, "Green",
                    (10 + rand.nextInt(10)), rand.nextInt((gameSize - 1)) + 1,
                    rand.nextInt((gameSize - 1)) + 1);
            goblinList.add(goblin);
        }
        humanoidList.add(humanList);
        humanoidList.add(goblinList);
        return humanoidList;
    }

    /**
     * Initializes the game board to the specified size
     *
     * @param gameSize : int
     * @return tileSet : Tile[][]
     */
    public Tile[][] initializeGameBoard(int gameSize) {
        Tile[][] tileSet = new Tile[gameSize][gameSize];
        for (int i = 0; i < gameSize; i++) {
            for (int j = 0; j < gameSize; j++) {
                Tile tile = new Tile(i, j);
                tileSet[i][j] = tile;
            }
        }
        return tileSet;
    }

    /**
     * Places all Humanoids in their specified spot on the board
     *
     * @param gameState    : Tile[][]
     * @param humanoidList : ArrayList<Humanoid>
     */
    public void initialPlacement(Tile[][] gameState, ArrayList<ArrayList<Humanoid>> humanoidList) {
        for (ArrayList<Humanoid> humanoidsList : humanoidList) {
            for (Humanoid humanoid : humanoidsList) {
                if (!gameState[humanoid.getXCoordinate()][humanoid.getYCoordinate()].hasHumanoid())
                    gameState[humanoid.getXCoordinate()][humanoid.getYCoordinate()].placeHumanoid(humanoid);
                else {
                    System.out.println("One goblin was eaten by the void!");
                }
            }
        }
    }

    /**
     * Gets a name from a combination of random names from the human
     * first and last name files
     * @return String : name of the human
     */
    public String getHumanName() {
        ArrayList<String> firstnames = new ArrayList<>();
        ArrayList<String> lastnames = new ArrayList<>();
        try {
            String HUMAN_FIRST_NAMES = "HumanFirstNames.txt";
            InputStream is = getClass().getClassLoader().getResourceAsStream(HUMAN_FIRST_NAMES);
            assert is != null;
            Stream<String> stream = new BufferedReader(new InputStreamReader(is)).lines();
            firstnames = (ArrayList<String>) stream
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error reading file");
        }
        try {
            String HUMAN_LAST_NAMES = "HumanLastNames.txt";
            InputStream is = getClass().getClassLoader().getResourceAsStream(HUMAN_LAST_NAMES);
            assert is != null;
            Stream<String> stream = new BufferedReader(new InputStreamReader(is)).lines();
            lastnames = (ArrayList<String>) stream
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error reading file");
        }
        return firstnames.get(new Random().nextInt(firstnames.size())) + " "
                + lastnames.get(new Random().nextInt(lastnames.size()));
    }
    public String getGoblinName() {
        ArrayList<String> firstnames = new ArrayList<>();
        ArrayList<String> lastnames = new ArrayList<>();
        try {
            String GOBLIN_FIRST_NAMES = "GoblinFirstNames.txt";
            InputStream is = getClass().getClassLoader().getResourceAsStream(GOBLIN_FIRST_NAMES);
            assert is != null;
            Stream<String> stream = new BufferedReader(new InputStreamReader(is)).lines();
            firstnames = (ArrayList<String>) stream
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error reading file");
        }
        try {
            String GOBLIN_LAST_NAMES = "GoblinLastNames.txt";
            InputStream is = getClass().getClassLoader().getResourceAsStream(GOBLIN_LAST_NAMES);
            assert is != null;
            Stream<String> stream = new BufferedReader(new InputStreamReader(is)).lines();
            lastnames = (ArrayList<String>) stream
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error reading file");
        }
        return firstnames.get(new Random().nextInt(firstnames.size())) + " "
                + lastnames.get(new Random().nextInt(lastnames.size()));
    }

    public boolean doesNameExist(String name, ArrayList<Humanoid> humanoids) {
        for (Humanoid humanoid : humanoids) {
            if (humanoid.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
