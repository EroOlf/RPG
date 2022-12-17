package com.isep.test;
import com.isep.rpg.Game;
import org.junit.jupiter.api.Test;


import static com.isep.rpg.Game.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestGame {

    @Test
    public void testInit(){
        Game g = new Game();
        initEnemies(21);
        assertEquals(getEnemies().size(), 27);
        g.initItems(12);
        assertEquals(g.getItems().size(), 12*2);

    }

}
