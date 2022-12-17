package com.isep.rpg.loot;

import com.isep.rpg.Hero;
import com.isep.rpg.Loot;

public class AddMana extends Loot {
    public AddMana(){
        super("AddMana", 10);
    }

    @Override
    public void applyEffect(Hero hero) {
        hero.setManaPoints(getEffectValue());
        System.out.println(hero.getName() + " a gagne " + getEffectValue() + " points de mana. Il a maintenant " + hero.getMana());
    }
}
