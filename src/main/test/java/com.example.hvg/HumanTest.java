package com.example.hvg;

import com.example.hvg.equipment.Equipment;
import com.example.hvg.equipment.armors.IronArmor;
import com.example.hvg.equipment.weapons.Shields.IronShield;
import com.example.hvg.equipment.weapons.Swords.IronSword;
import com.example.hvg.humanoid.Goblin;
import com.example.hvg.humanoid.Human;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HumanTest {

    Equipment ironSword = new IronSword();
    Equipment ironShield = new IronShield();
    Equipment ironArmor = new IronArmor();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getStrengthTest() {
        Human human = new Human(5, "testHuman", "Pale", 5, 0, 0);
        human.pickUp(ironSword);
        assertEquals(8, human.getStrength());
    }

    @Test
    void getDefenceFromSwordTest() {
        Human human = new Human(5, "testHuman", "Pale", 5, 0, 0);
        human.pickUp(ironSword);
        assertEquals(1, human.getDefence());
    }

    @Test
    void getDefenceFromShieldTest() {
        Human human = new Human(5, "testHuman", "Pale", 5, 0, 0);
        human.pickUp(ironShield);
        assertEquals(3, human.getDefence());
    }

    @Test
    void getDefenceFromArmorTest() {
        Human human = new Human(5, "testHuman", "Pale", 5, 0, 0);
        human.pickUp(ironArmor);
        assertEquals(3, human.getDefence());
    }

    @Test
    void attackTest() {
        Goblin goblin = new Goblin(5, "testGob", "Green", 5, 9, 9);
        Human human = new Human(5, "testHuman", "Pale", 5, 0, 0);
        human.attack(goblin);
        assertTrue(0 >= goblin.getCurrentHealth());
    }
}