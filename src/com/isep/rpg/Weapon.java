package com.isep.rpg;

public abstract class Weapon extends Item{
    private int damage;

    public Weapon(int damage, String name){
        super(name);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int val){
        this.damage += val;
    }

    public int getManaCost(){
        return 0;
    }
}
