package com.example.rpggraphic.weapons;

import com.example.rpggraphic.rpg.Spellcaster;

public class Stick extends SpellcasterWeapon {
    private static int dmg = -5;
    private static int manaCost = 5;

    public Stick() {
        super(dmg, "Stick", manaCost);
    }
}
