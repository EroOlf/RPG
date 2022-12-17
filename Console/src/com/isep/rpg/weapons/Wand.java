package com.isep.rpg.weapons;

import com.isep.rpg.Weapon;

public class Wand extends SpellCasterWeapons{
    private static int dmg = -15;
    private static int manaCost = 10;

    public Wand(){
        super(dmg, "Wand", manaCost);
    }
}
