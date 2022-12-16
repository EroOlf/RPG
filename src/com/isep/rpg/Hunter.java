package com.isep.rpg;

import com.isep.rpg.weapons.Bow;

public class Hunter extends Hero{
    private int arrows = 10;
    private static int lifePoints = 50;
    private static int armor = 30;


    public Hunter(){
        super(lifePoints, armor, "Hunter", new Bow());
    }

    public int getArrows() {
        return arrows;
    }

    @Override
    public void attack(Combatant fighter, int dmg) {
        if (arrows > 0){
            arrows--;
            fighter.setHealthPoints(dmg);
            System.out.println(this.getName() + " a inflige " + Math.abs(dmg) + " de degats a " + fighter.getName() + ". Il a maintenant " + fighter.getHealthPoints());
            System.out.println("Le hero n'a plus que " + arrows + " fleches !");
        }
        else{
            System.out.println("Le hunter n'a plus de fleches, il passe son tour");
        }
    }
}
