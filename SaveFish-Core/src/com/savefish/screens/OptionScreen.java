package com.savefish.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.constant.Constant;
import com.savefish.screens.button.MenuActor;
import com.savefish.screens.button.OptionButton;
import com.savefish.screens.button.OptionButton.HighscoreActor;
import com.savefish.screens.button.OptionButton.MusicActor;
import com.savefish.screens.button.OptionButton.ShareActor;

public class OptionScreen implements Screen {
	
	private Stage stage;
	private MenuActor menuActor;
	private HighscoreActor highscoreActor;
	private MusicActor musicActor;
	private ShareActor shareActor;
	public OptionButton optionButton;
	private Image bgImage;
	
	public OptionScreen(Game game) {
		
		bgImage = new Image(Constant.asset.bgOptionTexture);
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
		menuActor = new MenuActor(game,Constant.asset.fish2Texture);
		optionButton = new OptionButton(game);
		highscoreActor = optionButton.getHighscoreActor(Constant.asset.highscoreActorTexture);
		shareActor = optionButton.getShareActor(Constant.asset.shareActorTexture);
		musicActor = optionButton.getMusicActor(Constant.asset.musicActorTexture);
		stage.addActor(bgImage);
		stage.addActor(menuActor);
		stage.addActor(highscoreActor);
		stage.addActor(musicActor);
		stage.addActor(shareActor);
	}

	@Override
	public void render(float delta) {
		Gdx.input.setInputProcessor(stage);       
        stage.act(delta);
        stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		stage.dispose();

	}

}
