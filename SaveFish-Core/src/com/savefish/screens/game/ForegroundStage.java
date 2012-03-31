package com.savefish.screens.game;

import java.util.logging.Level;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.savefish.constant.Constant;
import com.savefish.service.ParticleManager;
import com.savefish.util.logger.GreenLogger;

public class ForegroundStage extends Stage {

	private static ForegroundStage foregroundStage = null;

	public static ForegroundStage getInstance() {
		if (null == foregroundStage)
			foregroundStage = new ForegroundStage();
		return foregroundStage;
	}

	private ForegroundStage() {
		super(Constant.screen.SCREEN_WIDTH, Constant.screen.SCREEN_HEIGHT, true);

		GreenLogger.getInstance().logp(Level.INFO,
				ForegroundStage.class.getName(), "ForegroundStage", "called!");
	}

	public void render(float delta) {
		GreenLogger.getInstance().logp(Level.INFO,
				ForegroundStage.class.getName(), "render", "called!");
		ParticleManager.getInstance().render(delta);
	}

	public void dispose() {
		ParticleManager.getInstance().dispose();
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		GreenLogger.getInstance().logp(Level.INFO,
				ForegroundStage.class.getName(), "touchDown", "called");

		ParticleManager.getInstance().start();
		ParticleManager.getInstance().setPosition(x, y);
		return super.touchDown(x, y, pointer, button);
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		GreenLogger.getInstance().logp(Level.INFO,
				ForegroundStage.class.getName(), "touchUp", "called");
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
