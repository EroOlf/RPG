package com.isep.rpg;

public class Potion extends Consumable{
    private final int manaPlus = 10;

    public Potion() {
        super("Potion de mana");
    }

    @Override
    public void applyEffect(Hero hero) {
        if(hero.isSpellCaster()){
            hero.setManaPoints(manaPlus);
            System.out.println(hero.getName() + " a gagne " + manaPlus + " de mana. Il a maintenant " + hero.getMana());
        }
        else{
            System.out.println("Ce type de potion n'est pas disponible pour ce hero");
        }
    }

     @Override
    public String description(){
        return "Cette potion donne " + manaPlus + " mana. Attention ! Cette potion n'est effective que pour les mages et les healers";
     }

}
