package com.isep.test;
import com.isep.rpg.Healer;
import com.isep.rpg.Hunter;
import com.isep.rpg.Mage;
import com.isep.rpg.Warrior;
import com.isep.rpg.enemies.Troll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class TestHeroes {

    @Test
    public void testClasses(){
        Healer healer = new Healer();
        assertEquals(healer.getHealthPoints(),20);
        assertEquals(healer.getMana(), 15);
        Hunter hunter = new Hunter();
        assertEquals(hunter.getHealthPoints(), 50);
        Mage mage = new Mage();
        assertEquals(mage.getHealthPoints(), 30);
        assertEquals(mage.getMana(), 20);
        Warrior warrior = new Warrior();
        assertEquals(warrior.getHealthPoints(), 30);

        healer.attack(hunter, healer.getWpn().getDamage());
        assertEquals(hunter.getHealthPoints(), 55);

        hunter.attack(warrior,hunter.getWpn().getDamage());
        assertEquals(warrior.getHealthPoints(), 20);
        assertEquals(hunter.getArrows(),9);

        mage.attack(healer, mage.getWpn().getDamage());
        assertEquals(healer.getHealthPoints(), 5);
        assertEquals(mage.getMana(), 10);
    }

    private void testAttack(){

    }
}
