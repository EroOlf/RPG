package com.example.rpggraphic.rpg;

public abstract class Combatant {
    private Weapon wpn;
    private int healthPoints;
    private String name;
    private String imagePath;

    public Combatant(int lP, String n, Weapon w, String imagePath) {
        this.healthPoints = lP;
        this.name = n;
        this.wpn = w;
        this.imagePath = imagePath;
    }

    public String getName(){
        return name;
    }

    public String getImagePath(){
        return imagePath;
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

    public abstract boolean isHero();

    public void attack(Combatant fighter, int dmg){
        fighter.setHealthPoints(dmg);
        System.out.println(name + " a inflige " + Math.abs(dmg) + " de degats a " + fighter.getName() + ". Il a maintenant " + fighter.getHealthPoints());
    }
}
