package com.savefish.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.constant.Constant;
import com.savefish.screens.button.ExitActor;
import com.savefish.screens.button.Fish;
import com.savefish.screens.button.HelpActor;
import com.savefish.screens.button.OptionActor;
import com.savefish.screens.button.StartActor;
import com.savefish.screens.button.AboutActor;
import com.savefish.service.MusicManager;

public class MenuScreen implements Screen {

	private Stage stage;
	private StartActor startActor;
	private AboutActor aboutActor;
	private HelpActor helpActor;
	private OptionActor optionActor;
	private ExitActor exitActor;
	private Image bgImage;
	private Fish fish1;
	private Fish fish2;

	public MenuScreen(Game game) {

		init(game);
		stage.addActor(bgImage);
		stage.addActor(fish1);// fish1 moves in the menu screen
		stage.addActor(fish2);
		stage.addActor(startActor);
		stage.addActor(aboutActor);
		stage.addActor(optionActor);
		stage.addActor(helpActor);
		stage.addActor(exitActor);

	}

	private void init(Game game) {
		bgImage = new Image(Constant.asset.bgMainTexture);
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),
				true);
		startActor = new StartActor(game, Constant.asset.startActorTexture);
		aboutActor = new AboutActor(game, Constant.asset.aboutActorTexture);
		optionActor = new OptionActor(game, Constant.asset.optionActorTexture);
		helpActor = new HelpActor(game, Constant.asset.helpActorTexture);
		exitActor = new ExitActor(Constant.asset.exitActorTexture);
		fish1 = new Fish(Constant.asset.fish1Texture);
		fish2 = new Fish(Constant.asset.fish2Texture);

		fish1.setPosition(0, 100, false);
		fish2.setPosition(480, 200, true);
		bgImage.height = Gdx.graphics.getHeight();
		bgImage.width = Gdx.graphics.getWidth();
		if (Constant.asset.isBgMusicOn)
			MusicManager.getInstance().play();// 加载背景音乐
		//加载音效
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

	}

}
