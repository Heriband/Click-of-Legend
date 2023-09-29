package com.mygdx.game.UI.Button;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.playable.Champs.Champ;
import com.mygdx.game.playable.Player;

public class LevelUpButton {

    public Skin skin;
    public Button levelUpButton;
    public Champ champ;
    public LevelUpButton(Stage stage, Champ myChamp, Player player, float x, float y){
        skin = new Skin(Gdx.files.internal("glassy-ui.json")); // Vous pouvez personnaliser le style du bouton ici
        levelUpButton = new TextButton("LVL UP",skin, "small");
        levelUpButton.setSize(100,100);
        levelUpButton.setPosition(x ,y);
        champ = myChamp;
        levelUpButton.addListener(new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            champ.tryLevelUp(player);
        }
        });
        stage.addActor(levelUpButton);

    }


}
