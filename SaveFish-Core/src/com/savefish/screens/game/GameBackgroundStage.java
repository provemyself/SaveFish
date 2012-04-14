package com.savefish.screens.game;

import java.util.logging.Level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.assets.Assets;
import com.savefish.constant.Constant;
import com.savefish.util.GreenLogger;

public class GameBackgroundStage extends Stage {

	private static GameBackgroundStage backgroundStage = null;

	public static GameBackgroundStage getInstance() {
		if (null == backgroundStage)
			backgroundStage = new GameBackgroundStage();
		return backgroundStage;
	}

	private GameBackgroundStage() {
		super(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
		this.setBackground(Constant.asset.BACKGROUND_ONE);
	}

	public void render(float delta) {
		this.act(delta);
		this.draw();
	}

	public void dispose() {
		this.backgroundImage = null;
	}

	private Image backgroundImage = null;

	public void setBackground(String fileName) {
		this.clear();
		this.backgroundImage = new Image(Assets.getInstance().getTextureRegion(
				fileName));
		this.backgroundImage.width = Gdx.graphics.getWidth();
		this.backgroundImage.height = Gdx.graphics.getHeight();
		this.resizeActors(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		this.addActor(backgroundImage);

	}

	public void resizeActors(float width, float height) {
		this.backgroundImage.width = width;
		this.backgroundImage.height = height;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		GreenLogger.getInstance().logp(Level.INFO,
				GameBackgroundStage.class.getName(), "touchDown", "called");

		return super.touchDown(x, y, pointer, button);
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		GreenLogger.getInstance().logp(Level.INFO,
				GameBackgroundStage.class.getName(), "touchUp", "called");

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
