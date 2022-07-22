package com.example.hvg;

import com.example.hvg.humanoid.Humanoid;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InitializerTest {
    Initializer initializer = new Initializer();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void initializeHumanoidsTest() {
        ArrayList<ArrayList<Humanoid>> humanoidList = initializer.initializeHumanoids(5, 5, 10);
        assertEquals(5, initializer.humanList.size());
        assertEquals(5, initializer.goblinList.size());
        assertEquals(2, humanoidList.size());
    }

    @Test
    void initializeGameBoardTest() {
        assertEquals(5, initializer.initializeGameBoard(5).length);
    }
}