package com.isep.rpg;

import com.isep.rpg.weapons.Wand;

public class Mage extends SpellCaster{

    private static int healthPoints = 30;
    private static int armor = 10;
    private static int manaPoints = 20;


    public Mage(){
        super(healthPoints, armor, manaPoints, "Mage", new Wand());
    }

    @Override
    public boolean isHealer(){
        return false;
    }
}
