package com.isep.rpg;

public abstract class Consumable extends Item{

    abstract void applyEffect(Hero hero);

    public Consumable(String name){
        super(name);
    }

    abstract String description();
}
