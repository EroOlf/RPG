package com.example.rpggraphic.Controllers;

import com.example.rpggraphic.HelloApplication;
import com.example.rpggraphic.rpg.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import java.io.File;
import javafx.scene.media.*;
import javafx.scene.paint.Color;


import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Slider sliderNumberHeroes;

    @FXML
    private Label nbHeroesText;

    @FXML
    private static StackPane root = new StackPane();

    @FXML
    private Label choiceText;

    @FXML
    protected void onStartButtonClick() throws IOException {
        //welcomeText.setText("Welcome to RPG_Lite_3000_Evolved !");
        // Changer de formulaire
        Game.getContext().setNbHeroes(Integer.parseInt(nbHeroesText.getText()));
        FXMLLoader fxmlLoader = new FXMLLoader
                (HelloApplication.class.getResource("choose-heroes.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        HelloApplication.stage.setScene(scene);
        HelloApplication.stage.show();
    }

    public void initialize() {
        sliderNumberHeroes.setMin(1);
        sliderNumberHeroes.setMax(10);
        sliderNumberHeroes.valueProperty().addListener((observable, oldValue, newValue) -> {
            nbHeroesText.setText(Integer.toString(newValue.intValue()));
        });
        nbHeroesText.setText("1");

        Image img = new Image(String.valueOf(HelloApplication.class.getResource("BackGround.jpg")));
        BackgroundImage bImg = new BackgroundImage(img,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background backGround = new Background(new BackgroundFill(Color.rgb(80, 10, 50), CornerRadii.EMPTY, Insets.EMPTY));
        root.setBackground(backGround);

        Media media = new Media(String.valueOf(HelloApplication.class.getResource("DungeonMusic.mp3"))); //replace /Movies/test.mp3 with your file
        MediaPlayer player = new MediaPlayer(media);
        player.setAutoPlay(true);
        player.setVolume(0.75);   // from 0 to 1
        player.play();
    }
}