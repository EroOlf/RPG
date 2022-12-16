package com.isep.rpg;

public abstract class Enemy extends Combatant{

    public Enemy(int lP, int armor, String name, Weapon wpn){
        super(lP, armor, name, wpn);
    }

    @Override
    public boolean isHero() {
        return false;
    }
}
