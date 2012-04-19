package com.savefish.screens;

/********************************
 * Description: option screen.
 * we decide whether to open 
 * the background music or not
 * Author     : Yang Yong
 * Date       : 2012/03/08
 *******************************/
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
import com.savefish.screens.button.OptionButton.SoundActor;

public class OptionScreen implements Screen {

	private Stage stage;
	private MenuActor menuActor;
	private HighscoreActor highscoreActor;
	private MusicActor musicActor;
	private SoundActor soundActor;
	public OptionButton optionButton;
	private Image bgImage;

	public OptionScreen(Game game) {

		init(game);
		stage.addActor(bgImage);
		stage.addActor(menuActor);
		stage.addActor(highscoreActor);
		stage.addActor(musicActor);
		stage.addActor(soundActor);
	}

	private void init(Game game) {
		bgImage = new Image(Constant.asset.bgMainTexture);
		bgImage.height = Gdx.graphics.getHeight();
		bgImage.width = Gdx.graphics.getWidth();

		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),
				true);
		menuActor = new MenuActor(game, Constant.asset.quitActorTexture);
		optionButton = new OptionButton(game);
		highscoreActor = optionButton
				.getHighscoreActor(Constant.asset.highscoreActorTexture);
		soundActor = optionButton
				.getSoundActor(Constant.asset.soundActorTexture);
		musicActor = optionButton
				.getMusicActor(Constant.asset.bgMusicActorTexture);

	}

	@Override
	public void render(float delta) {
		Gdx.input.setInputProcessor(stage);
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		stage.dispose();

	}

}
