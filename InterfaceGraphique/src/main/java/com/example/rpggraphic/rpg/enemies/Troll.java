package com.example.rpggraphic.rpg.enemies;

import com.example.rpggraphic.rpg.Combatant;
import com.example.rpggraphic.rpg.Enemy;
import com.example.rpggraphic.weapons.SledgeHammer;

public class Troll extends Enemy {
    public Troll() {
        super(10, "Troll", new SledgeHammer(), "troll.png");
    }
}
