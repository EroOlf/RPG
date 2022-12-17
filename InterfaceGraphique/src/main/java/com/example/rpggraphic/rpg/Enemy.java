package com.example.rpggraphic.rpg;

public class Enemy extends Combatant{
    public Enemy(int lP, String name, Weapon wpn, String image){
        super(lP, name, wpn, image);
    }

    @Override
    public boolean isHero() {
        return false;
    }
}
