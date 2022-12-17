package com.isep.rpg.loot;

import com.isep.rpg.Hero;
import com.isep.rpg.Loot;

public class AddPV extends Loot {

    public AddPV(){
        super("AddPV", 5);
    }

    @Override
    public void applyEffect(Hero hero) {
        hero.setHealthPoints(getEffectValue());
        System.out.println(hero.getName() + " a gagne " + getEffectValue() + "point de vie. Il a maintenant " + hero.getHealthPoints() + " PV");
    }

}
