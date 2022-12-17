package com.example.rpggraphic.rpg;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero extends Combatant{
    //Pour l'instant que des potions
    private List<Item> items;
    public Hero(int lP, String name, Weapon wpn, String image){
        super(lP, name, wpn, image);
        this.items= new ArrayList<>();
        //this.lembas = new ArrayList<>();
    }

    private void defend(){

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


}
