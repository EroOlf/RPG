package com.isep.rpg.weapons;

import com.isep.rpg.Weapon;

public class Sword extends Weapon {
    private static int dmg = -15;

    public Sword(){
        super(dmg, "Sword");
    }
}
