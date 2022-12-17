package com.example.rpggraphic.weapons;

import com.example.rpggraphic.rpg.Weapon;

public class Wand extends SpellcasterWeapon {
    private static int dmg = -15;
    private static int manaCost = 10;

    public Wand(){
        super(dmg, "Wand", manaCost);
    }
}
