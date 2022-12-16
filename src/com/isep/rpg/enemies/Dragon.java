package com.isep.rpg.enemies;

import com.isep.rpg.Enemy;
import com.isep.rpg.Weapon;
import com.isep.rpg.weapons.Fire;

public class Dragon extends Enemy {


    public Dragon() {
        super(70, 30, "Dragon", new Fire());
    }
}
