
package com.isep.test;
import com.isep.rpg.Healer;
import com.isep.rpg.Hunter;
import com.isep.rpg.Mage;
import com.isep.rpg.Warrior;
import com.isep.rpg.enemies.Troll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
public class TestEnemies {

    @Test
    public void testEnemies(){
        Troll t1 = new Troll();
        assertEquals(t1.getHealthPoints(),10);
        Hunter h1 = new Hunter();
        t1.attack(h1, t1.getWpn().getDamage());
        assertEquals(h1.getHealthPoints(),44);
        h1.attack(t1,h1.getWpn().getDamage());
        assertEquals(t1.getHealthPoints(),0);
    }
}
