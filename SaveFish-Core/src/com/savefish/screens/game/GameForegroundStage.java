package com.savefish.screens.game;

import java.util.logging.Level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.savefish.util.GreenLogger;

public class GameForegroundStage extends Stage {

	public static GameForegroundStage getInstance() {
		return new GameForegroundStage();
	}

	private GameForegroundStage() {
		super(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
//		this.initGrassActor();
		GreenLogger.getInstance().logp(Level.INFO,
				GameForegroundStage.class.getName(), "ForegroundStage",
				"called!");
	}

//	private GrassActor grass = null;
//
//	private void initGrassActor() {
//		this.grass = new GrassActor();
//		this.grass.x = 460;
//		this.grass.y = 200;
//		this.addActor(grass);
//	}

	public void render(float delta) {
		GreenLogger.getInstance().logp(Level.INFO,
				GameForegroundStage.class.getName(), "render", "called!");
//		this.grass.draw(batch, delta);
	}

	public void dispose() {
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		GreenLogger.getInstance().logp(Level.INFO,
				GameForegroundStage.class.getName(), "touchDown", "called");

		return super.touchDown(x, y, pointer, button);
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		GreenLogger.getInstance().logp(Level.INFO,
				GameForegroundStage.class.getName(), "touchUp", "called");
		return super.touchUp(x, y, pointer, button);
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		return super.touchDragged(x, y, pointer);
	}

	@Override
	public boolean touchMoved(int x, int y) {
		return super.touchMoved(x, y);
	}

}
