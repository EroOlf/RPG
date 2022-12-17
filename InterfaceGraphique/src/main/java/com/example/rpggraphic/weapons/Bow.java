package com.example.rpggraphic.weapons;

import com.example.rpggraphic.rpg.Weapon;

public class Bow extends Weapon {
    private static int dmg = -10;

    public Bow(){
        super(dmg, "Bow");
    }
}
