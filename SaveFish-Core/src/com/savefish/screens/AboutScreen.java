package com.savefish.screens;

/********************************
 * Description: this class is about 
 * screen which introduce the game
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

public class AboutScreen implements Screen {

	private Stage stage = null;
	private MenuActor menuActor = null;
	private Image bgImage = null;

	public AboutScreen(Game game) {

		bgImage = new Image(Constant.asset.bgMainTexture);
		bgImage.height = Gdx.graphics.getHeight();
		bgImage.width = Gdx.graphics.getWidth();
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),
				true);
		menuActor = new MenuActor(game, Constant.asset.quitActorTexture);

		stage.addActor(bgImage);
		stage.addActor(menuActor);
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
