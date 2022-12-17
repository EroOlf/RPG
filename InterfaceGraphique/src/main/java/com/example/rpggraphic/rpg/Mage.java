package com.example.rpggraphic.rpg;

import com.example.rpggraphic.weapons.Wand;

public class Mage extends Spellcaster{

    private static int healthPoints = 30;
    private static int armor = 10;
    private static int manaPoints = 20;



    public Mage(){
        super(healthPoints, manaPoints, "Mage", new Wand(), "mage.png");
    }
}
