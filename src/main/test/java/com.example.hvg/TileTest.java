package com.example.hvg;

import com.example.hvg.humanoid.Goblin;
import com.example.hvg.humanoid.Human;
import com.example.hvg.humanoid.Humanoid;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void fightTest() {
        Tile tile = new Tile(0, 0);
        Humanoid human = new Human(5, "testHuman", "Pale", 5, 0, 0);
        Humanoid goblin = new Goblin(5, "testGoblin", "Green", 5, 0, 0);
        tile.placeHumanoid(human);
        tile.placeHumanoid(goblin);
        assertTrue(tile.fight().length() > 0);
    }

    @Test
    void placeHumanoidTest() {
        Tile tile = new Tile(0, 0);
        Humanoid human = new Human(5, "testHuman", "Pale", 5, 0, 0);
        tile.placeHumanoid(human);
        assertTrue(tile.hasHumanoid());
    }

    @Test
    void removeHumanoidTest() {
        Tile tile = new Tile(0, 0);
        Humanoid human = new Human(5, "testHuman", "Pale", 5, 0, 0);
        tile.placeHumanoid(human);
        tile.removeHumanoid(human);
        assertFalse(tile.hasHumanoid());
    }

    @Test
    void hasCombatTest() {
        Tile tile = new Tile(0, 0);
        Humanoid human = new Human(5, "testHuman", "Pale", 5, 0, 0);
        Humanoid goblin = new Goblin(5, "testGoblin", "Green", 5, 0, 0);
        tile.placeHumanoid(human);
        tile.placeHumanoid(goblin);
        assertTrue(tile.hasCombat());
    }

    @Test
    void noCombatTest() {
        Tile tile = new Tile(0, 0);
        Humanoid human = new Human(5, "testHuman", "Pale", 5, 0, 0);
        tile.placeHumanoid(human);
        assertFalse(tile.hasCombat());
    }

    @Test
    void emptyToStringTest() {
        Tile tile = new Tile(0, 0);
        assertEquals("   ", tile.toString());
    }

    @Test
    void humanToStringTest() {
        Tile tile = new Tile(0, 0);
        Humanoid human = new Human(5, "testHuman", "Pale", 5, 0, 0);
        tile.placeHumanoid(human);
        assertEquals("H", tile.toString());
    }

    @Test
    void goblinToStringTest() {
        Tile tile = new Tile(0, 0);
        Humanoid goblin = new Goblin(5, "testGoblin", "Green", 5, 0, 0);
        tile.placeHumanoid(goblin);
        assertEquals("G", tile.toString());
    }
}