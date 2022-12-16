package com.isep.rpg;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero extends Combatant{

    //Pour l'instant que des potions
    private List<Item> items;
    public Hero(int lP, int armor, String name, Weapon wpn){
        super(lP, armor, name, wpn);
        this.items= new ArrayList<>();
        //this.lembas = new ArrayList<>();
    }

    private void defend(){

    }

    public void useConsumable(Consumable consumable){

    }

    public List<Item> getItems(){
        return items;
    }

    public String itemsToString(){
        StringBuilder sB = new StringBuilder();
        sB.append("Voici les objets disponible pour le heros : \n");
        for(Item i : items){
            sB.append(i.getName() + "\n");
        }
        return sB.toString();
    }

    @Override
    public boolean isHero() {
        return true;
    }

    public boolean isSpellCaster(){
        return false;
    }

    public int getMana(){
        System.out.println("Le hero ne possede pas de mana");
        return 0;
    }

    public void setManaPoints(int mP){
        System.out.println("Le hero ne possede pas de mana");
    }



    // Les items ne sont pas en attributs mais une méthode va les utiliser
}
