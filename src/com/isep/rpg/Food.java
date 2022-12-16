package com.isep.rpg;

public class Food extends Consumable{
    private final int pvPlus = 5;

    public Food() {
        super("Food");
    }

    @Override
    public void applyEffect(Hero hero) {
        hero.setHealthPoints(pvPlus);
        System.out.println(pvPlus + " a ete ajoute a la vie de " + hero.getName() + ". Il a maintenant " + hero.getHealthPoints());
    }

    @Override
    public String description(){
        return "Ce bout de nourriture peut redonner a un de vos heros " + pvPlus + " points de vie";
    }
}
