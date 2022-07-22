package com.example.hvg;

import com.example.hvg.equipment.Drops;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DropsTest {
    Drops drops = new Drops();

    @BeforeEach
    void setUp() {
    }

    @Test
    void getDroppedItem() {
        assert (drops.getDroppedItem() != null);
    }
}