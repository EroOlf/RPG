package com.isep.rpg;

public abstract class Loot {
    private String name;
    private int effectValue;

    public Loot(String n, int val) {
        this.name = n;
        this.effectValue = val;
    }

    public String getName() {
        return name;
    }

    public int getEffectValue() {
        return effectValue;
    }

    public abstract void applyEffect(Hero hero);
}
