package com.isep.rpg.weapons;

import com.isep.rpg.Weapon;

public class Bow extends Weapon {
    private static int dmg = -10;

    public Bow(){
        super(dmg, "Bow");
    }
}
