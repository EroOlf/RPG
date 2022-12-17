package com.isep.rpg.enemies;

import com.isep.rpg.Enemy;
import com.isep.rpg.weapons.Rock;

public class Leprechauns extends Enemy {

    public Leprechauns() {
        super(10, 10, "Leprechauns", new Rock());
    }
}
