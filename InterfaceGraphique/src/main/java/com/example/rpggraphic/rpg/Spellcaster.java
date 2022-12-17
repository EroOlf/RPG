package com.example.rpggraphic.rpg;

public abstract class Spellcaster extends Hero {

    private int manaPoints;

    public Spellcaster(int lP, int mP, String name, Weapon wpn, String image){
        super(lP, name, wpn, image);
        this.manaPoints = mP;
    }

    private boolean fightManaPoints(){
        if(this.getWpn().getManaCost() > manaPoints){
            System.out.println("Le hero n'a plus assez de mana");
            return false;
        }
        else{
            setManaPoints(- getWpn().getManaCost());
            return true;
        }
    }

    @Override
    public void setManaPoints(int manaPoints){
        this.manaPoints += manaPoints;
    }

    @Override
    public int getMana(){
        return manaPoints;
    }

    @Override
    public boolean isSpellCaster(){
        return true;
    }
}
