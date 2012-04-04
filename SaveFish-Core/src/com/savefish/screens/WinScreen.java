package com.savefish.screens;

import java.util.logging.Level;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.savefish.service.LoadedScreen;
import com.savefish.util.logger.GreenLogger;

public class WinScreen implements Screen {

	public WinScreen(){
		
	}
	
	private static WinScreen winScreen = null;

	public static WinScreen getInstance(Game game) {
		if (null == winScreen) {
			winScreen = new WinScreen(game);
			LoadedScreen.screens.add(winScreen);
		}
		return winScreen;
	}

	@SuppressWarnings("unused")
	private Game game;

	public WinScreen(Game game) {
		super();
		this.game = game;
		this.initStage();
	}

	private Stage stage = null;

	private void initStage() {
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),
				true);
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		this.stage.act(delta);
		this.stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		this.initStage();
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
		GreenLogger.getInstance().logp(Level.INFO, WinScreen.class.getName(),
				"dispose", "called!");

		if (this.stage != null)
			this.stage.dispose();
		game = null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return WinScreen.class.getName();
	}

}
