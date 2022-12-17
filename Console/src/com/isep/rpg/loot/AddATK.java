package com.isep.rpg.loot;

import com.isep.rpg.Hero;
import com.isep.rpg.Loot;


import static java.lang.Math.abs;

public class AddATK extends Loot {
    public AddATK(){
        super("AddATK", -5);
    }

    @Override
    public void applyEffect(Hero hero) {
        hero.getWpn().setDamage(getEffectValue());
        System.out.println("L'attaque de " + hero.getName() + " est passe a " + abs(hero.getWpn().getDamage()));
    }
}
