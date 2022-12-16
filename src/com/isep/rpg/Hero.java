package com.isep.rpg;

import com.isep.rpg.loot.AddATK;
import com.isep.rpg.loot.AddPV;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Hero extends Combatant{

    //Pour l'instant que des potions
    private List<Item> items;

    private List<Loot> loots;
    public Hero(int lP, int armor, String name, Weapon wpn){
        super(lP, armor, name, wpn);
        this.items= new ArrayList<>();
        initLoots();
    }

    private void initLoots(){
        this.loots = new ArrayList<>();
        loots.add(new AddPV());
        loots.add(new AddATK());
    }

    public List<Loot> getLoots(){
        return loots;
    }

    private void defend(){

    }

    public void useConsumable(Consumable consumable){

    }

    public List<Item> getItems(){
        return items;
    }

    private String lootsToString(){
        StringBuilder sB = new StringBuilder();
        sB.append("Voici les objets disponible pour le hero, vous pouvez en choisir un : \n");
        for(Loot l : loots){
            sB.append(l.getName() + "\n");
        }
        return sB.toString();
    }

    public void chooseLoot(){
        System.out.println(lootsToString());
        boolean valid = true;
        Scanner sc = new Scanner(System.in);
        do{
            String input = sc.next();
            for(Loot l : loots){
                if(input.equals(l.getName())){
                    l.applyEffect(this);
                    return;
                }else{
                    valid = false;
                }
            }
            System.out.println("L'entree est incorrecte");
        }while(!valid);
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
