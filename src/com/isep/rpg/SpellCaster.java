package com.isep.rpg;

public abstract class SpellCaster extends Hero{
    private int manaPoints;

    public SpellCaster(int lP, int armor, int mP, String name, Weapon wpn){
        super(lP, armor, name, wpn);
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
    public void attack(Combatant fighter, int dmg){
        if(fightManaPoints()){
            fighter.setHealthPoints(dmg);
            System.out.println(this.getName() + " a inflige " + Math.abs(dmg) + " de degats a " + fighter.getName() + ". Il a maintenant " + fighter.getHealthPoints());
            System.out.println("Le hero n'a plus que " + manaPoints + " points de mana");
        }
    }

    @Override
    public boolean isSpellCaster(){
        return true;
    }

    public abstract boolean isHealer();
}
