package com.example.hvg;

import org.junit.jupiter.api.Test;
import com.example.hvg.humanoid.*;

import static org.junit.jupiter.api.Assertions.*;

class GoblinTest {


    @Test
    void attack() {
        Goblin goblin = new Goblin(5,"testGob","Green", 5 ,9,9);
        Human human = new Human(5,"testHuman","Pale", 5, 0, 0);
        goblin.attack(human);
        assertTrue(0 >= human.getCurrentHealth());
    }

    @Test
    void getStartingHpTest(){
        Goblin goblin = new Goblin(5,"testGob","Green", 5 ,9,9);
        Human human = new Human(5,"testHuman","Pale", 5, 0, 0);
        human.attack(goblin);
        assertEquals(5,  goblin.getStartingHealth());
    }

}