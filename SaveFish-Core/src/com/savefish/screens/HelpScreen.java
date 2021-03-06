package com.savefish.screens;

/********************************
 * Description: help screen.
 * the class tell us how play
 * the game
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

public class HelpScreen implements Screen{
	private Stage     stage = null;
	private MenuActor menuActor = null;
	private Image     bgImage = null;

	public HelpScreen(Game game) {
		
		bgImage        = new Image(Constant.asset.bgMainTexture);
		bgImage.height = Gdx.graphics.getHeight();
		bgImage.width  = Gdx.graphics.getWidth();
		stage          = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),true);
		menuActor      = new MenuActor(game, Constant.asset.quitActorTexture);
		
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
