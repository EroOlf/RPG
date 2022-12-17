package com.isep.rpg.weapons;

import com.isep.rpg.Weapon;

public class Stick extends SpellCasterWeapons {
    private static int dmg = 5;
    private static int manaCost = 5;

    public Stick() {
        super(dmg, "Stick", manaCost);
    }
}
