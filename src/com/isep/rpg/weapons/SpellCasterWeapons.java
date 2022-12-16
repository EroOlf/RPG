package com.isep.rpg.weapons;

import com.isep.rpg.Weapon;

public abstract class SpellCasterWeapons extends Weapon {
    private int manaPoints;

    public SpellCasterWeapons(int damage, String name, int mP) {
        super(damage, name);
        this.manaPoints = mP;
    }

    @Override
    public int getManaCost(){
        return manaPoints;
    }
}
