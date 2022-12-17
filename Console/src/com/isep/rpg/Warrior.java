package com.isep.rpg;

import com.isep.rpg.weapons.Sword;

public class Warrior extends Hero{
    private static int lifePoint = 30;
    private static int armor = 30;

    public Warrior() {
        super(lifePoint, armor, "Warrior", new Sword());
    }

}
