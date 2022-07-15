package src;

import src.Humanoid.Goblin;
import src.Humanoid.Human;
import src.Humanoid.Humanoid;

import java.util.ArrayList;
import java.util.Random;

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
            Humanoid human = new Human(5, "Human" + i, "Pink", (10 + rand.nextInt(10)),
                    i, 0);
            humanList.add(human);
        }
        for (int i = 0; i < numOfGoblins; i++) {
            Humanoid goblin = new Goblin(5, "Goblin" + i,
                    "Green", (10 + rand.nextInt(10)), rand.nextInt((gameSize - 1)) + 1,
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
    public Tile[][] inititializeGameBoard(int gameSize) {
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
}
