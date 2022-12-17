package com.example.rpggraphic.Controllers;

import com.example.rpggraphic.rpg.Game;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import java.io.IOException;

public class ChooseHeroesController {

    //S'occuper des messages d'erreurs
    @FXML
    private Label choiceText;

    @FXML
    private Button startButton;

    @FXML
    private Label warriorText;
    @FXML
    private Slider warriorSlider;
    @FXML
    private Label mageText;
    @FXML
    private Slider mageSlider;
    @FXML
    private Label hunterText;
    @FXML
    private Slider hunterSlider;
    @FXML
    private Label healerText;
    @FXML
    private Slider healerSlider;

    int nbHeroes;

    @FXML
    private Label errorText;

    public void onStartButtonClick() throws IOException {
        if(verification()){
            Game.getContext().initialisation((int)warriorSlider.getValue(), (int)mageSlider.getValue(), (int)hunterSlider.getValue(), (int)healerSlider.getValue());
            // Lancer la nouvelle fenêtre
            FightController.fight();
            /*FXMLLoader fxmlLoader = new FXMLLoader
                    (HelloApplication.class.getResource("fight-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            HelloApplication.stage.setScene(scene);
            HelloApplication.stage.show();*/
        }
    }

    /**
     * @brief : Vérifie que le nombre de héros sélectionnés correspondent au nombre de héros devant être sélectionnés
     * */
    private boolean verification(){
        if(warriorSlider.getValue() + mageSlider.getValue() + hunterSlider.getValue() + healerSlider.getValue() == nbHeroes){
            return true;
        } else if(warriorSlider.getValue() + mageSlider.getValue() + hunterSlider.getValue() + healerSlider.getValue() > nbHeroes){
            errorText.setText("You selected too many heroes, please reduce");
            return false;
        }else{
            errorText.setText("You did not selected enough heroes");
            return false;
        }
    }

    public void initialize() {
        nbHeroes = Game.getContext().getNbHeroes();
        choiceText.setText("You have " + nbHeroes + " heroes, choose their categories");
        // Init sliders
        warriorSlider.setMin(0);
        warriorSlider.setMax(nbHeroes);
        warriorSlider.setBlockIncrement(1);
        warriorSlider.setMajorTickUnit(1);
        warriorSlider.setMinorTickCount(0);
        warriorSlider.setShowTickLabels(true);
        warriorSlider.setSnapToTicks(true);
        warriorSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            warriorText.setText("Warrior : " + Integer.toString(newValue.intValue()));
        });
        mageSlider.setMin(0);
        mageSlider.setMax(nbHeroes);
        mageSlider.setBlockIncrement(1);
        mageSlider.setMajorTickUnit(1);
        mageSlider.setMinorTickCount(0);
        mageSlider.setShowTickLabels(true);
        mageSlider.setSnapToTicks(true);
        mageSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            mageText.setText("Mage : " + Integer.toString(newValue.intValue()));
        });
        hunterSlider.setMin(0);
        hunterSlider.setMax(nbHeroes);
        hunterSlider.setBlockIncrement(1);
        hunterSlider.setMajorTickUnit(1);
        hunterSlider.setMinorTickCount(0);
        hunterSlider.setShowTickLabels(true);
        hunterSlider.setSnapToTicks(true);
        hunterSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            hunterText.setText("Hunter : " +
                    "" + Integer.toString(newValue.intValue()));
        });
        healerSlider.setMin(0);
        healerSlider.setMax(nbHeroes);
        healerSlider.setBlockIncrement(1);
        healerSlider.setMajorTickUnit(1);
        healerSlider.setMinorTickCount(0);
        healerSlider.setShowTickLabels(true);
        healerSlider.setSnapToTicks(true);
        healerSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            healerText.setText("Healer : " + Integer.toString(newValue.intValue()));
        });
    }
}
