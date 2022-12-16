package com.isep.test;
import org.junit.jupiter.api.Test;


import static com.isep.rpg.Game.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestGame {

    @Test
    public void testInit(){
        initEnemies(21);
        assertEquals(getEnemies().size(), 27);
        initItems(12);
        assertEquals(getItems().size(), 12*2);
        //assertTrue();
        //assertEquals(10, 50);
    }

}
