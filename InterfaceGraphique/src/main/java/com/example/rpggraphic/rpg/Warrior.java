package com.example.rpggraphic.rpg;

import com.example.rpggraphic.weapons.Sword;

public class Warrior extends Hero {

    private static int lifePoint = 30;
    public Warrior() {
        super(lifePoint,"Warrior", new Sword(), "warrior.png");
    }
}
