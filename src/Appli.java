import com.isep.rpg.Combatant;
import com.isep.rpg.Game;
import com.isep.rpg.Warrior;
import com.isep.rpg.enemies.Troll;
import com.isep.utils.ConsoleParser;

public class Appli {


    // Mettre tous les print dans une méthode de ConsoleParser

    /**
     * En cours d'implémentation :
     * Pour les SpellCaster, les points de mana doivent descendre lors de l'attaque
     * Initialiser les héros avec des potions
     * Ajouter la possibilité de les utiliser à la place de l'attaque
     */

    public static void main(String args[]) {
        Game g = new Game(new ConsoleParser());
        g.playGame();
        //Game.playGame();
    }
}