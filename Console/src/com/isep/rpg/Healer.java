package com.isep.rpg;

import com.isep.rpg.weapons.Stick;

public class Healer extends SpellCaster{
    private static int lifePoints = 20;
    private static int armor = 20;
    private static int manaPoints = 15;


    public Healer() {
        super(lifePoints, armor, manaPoints, "Healer", new Stick());
    }

    /*@Override
    public void attack(Combatant hero, int heal){
        // Récupérer un héro
        hero.setHealthPoints(this.getWpn().getDamage());

        // Lui ajouter de la vie
        // Réduire le mana
    }*/

    @Override
    public boolean isHealer(){
        return true;
    }
}
