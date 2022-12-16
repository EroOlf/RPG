package com.isep.rpg;

public abstract class Combatant {
    // attributs communs entre les Heros et les ennemis

    private Weapon wpn;
    private int healthPoints;
    private String name;
    private int armor;

    public Combatant(int lP, int armor, String n, Weapon w) {
        this.healthPoints = lP;
        this.armor = armor;
        this.name = n;
        this.wpn = w;
    }

    public String getName(){
        return name;
    }

    public void setHealthPoints(int nb){
        if(Math.abs(nb) > this.healthPoints){
            this.healthPoints = 0;
        }
        else{
            this.healthPoints += nb;
        }
    }

    public int getHealthPoints(){
        return this.healthPoints;
    }

    public Weapon getWpn() {
        return wpn;
    }


    public void attack(Combatant fighter, int dmg){
        fighter.setHealthPoints(dmg);
        System.out.println(name + " a inflige " + Math.abs(dmg) + " de degats a " + fighter.getName() + ". Il a maintenant " + fighter.getHealthPoints());
    }

    public abstract boolean isHero();
}
