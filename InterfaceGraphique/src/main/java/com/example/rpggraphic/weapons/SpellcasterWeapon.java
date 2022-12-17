package com.example.rpggraphic.weapons;

import com.example.rpggraphic.rpg.Weapon;

public abstract class SpellcasterWeapon extends Weapon {
    private int manaPoints;

    public SpellcasterWeapon(int damage, String name, int mP) {
        super(damage, name);
        this.manaPoints = mP;
    }

    @Override
    public int getManaCost(){
        return manaPoints;
    }
}
