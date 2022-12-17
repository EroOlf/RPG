package com.example.rpggraphic.rpg;

import com.example.rpggraphic.weapons.Bow;

public class Hunter extends Hero {

    private static int arrows = 10;
    private static int lifePoints = 50;


    public Hunter(){
        super(lifePoints, "Hunter", new Bow(), "hunter.png");
    }
}
