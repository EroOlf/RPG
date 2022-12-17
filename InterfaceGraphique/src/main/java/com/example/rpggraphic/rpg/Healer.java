package com.example.rpggraphic.rpg;

import com.example.rpggraphic.weapons.Stick;

public class Healer extends Spellcaster{

    private static int lifePoints = 20;
    private static int manaPoints = 15;

    public Healer() {
        super(lifePoints, manaPoints, "Healer", new Stick(), "healer.png");
    }
}
