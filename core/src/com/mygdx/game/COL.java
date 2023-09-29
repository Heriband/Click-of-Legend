package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Save.LoadSave;
import com.mygdx.game.UI.Button.LevelUpButton;
import com.mygdx.game.playable.Champs.BotChamp.Caitlyn;
import com.mygdx.game.playable.Enemie.Minions.MeleeCreep;
import com.mygdx.game.playable.Enemie.StatusEnemie;
import com.mygdx.game.playable.Player;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class COL extends ApplicationAdapter {
	SpriteBatch batch;
	Stage stage;
	BitmapFont font;
	Texture img;
	Sprite imageSprite;
	MeleeCreep sbire;
	Player player;
	float elapsedTime = 0;


	@Override
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		LoadSave ld = new LoadSave("Save/SaveTest1.json");
		img = new Texture("badlogic.jpg");
		imageSprite = new Sprite(img);
		imageSprite.setPosition(0, 0);

		sbire = new MeleeCreep();
		player = new Player();

		LevelUpButton levelUpButtonCaitlyn = new LevelUpButton(stage, player.getBotChampsOwn().get(0), player, 200,100);
		LevelUpButton levelUpButtonJhin = new LevelUpButton(stage, player.getBotChampsOwn().get(1), player, 300,100);
	}


	@Override
	public void render() {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		font.draw(batch, "Gold : " + player.getGold(), 10, Gdx.graphics.getHeight() - 10);
		font.draw(batch, "Kill : " + player.getKill(), 10, Gdx.graphics.getHeight() - 30);
		font.draw(batch, "enemie hp : " + sbire.getHp(), 10, Gdx.graphics.getHeight() - 60);
		font.draw(batch, "champ 1 dps : " + player.getBotChampsOwn().get(0).getDPS() + "\nchamp 1 level: " + player.getBotChampsOwn().get(0).getLevel(), 10, Gdx.graphics.getHeight() - 80);
		font.draw(batch, "champ 2 dps : " + player.getBotChampsOwn().get(1).getDPS() + "\nchamp 2 level: " + player.getBotChampsOwn().get(1).getLevel(), 10, Gdx.graphics.getHeight() - 120);

		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		batch.end();

		if (Gdx.input.justTouched()) {
			Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
			//camera.unproject(touchPos);

			if (imageSprite.getBoundingRectangle().contains(touchPos.x, touchPos.y)) {
				player.clickEnemie(sbire);
				if (sbire.status == StatusEnemie.Dead) {
					sbire = new MeleeCreep();
					player.earnGold(sbire);
				}
			}

		}
		elapsedTime += Gdx.graphics.getDeltaTime();

		// Vérifie si 1000 millisecondes se sont écoulées
		if (elapsedTime >= 1f) {

			player.updatePlayer();
			player.dealIdleDamage(sbire);
			if (sbire.status == StatusEnemie.Dead) {
				sbire = new MeleeCreep();
				player.earnGold(sbire);
			}

			// Réinitialise le compteur
			elapsedTime = 0;
		}


	}



	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		font.dispose();
		stage.dispose();
	}
}
