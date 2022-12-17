package com.isep.rpg.enemies;

import com.isep.rpg.Enemy;
import com.isep.rpg.weapons.SledgeHammer;

public class Troll extends Enemy {

    public Troll() {
        super(10, 10, "Troll", new SledgeHammer());
    }

}
