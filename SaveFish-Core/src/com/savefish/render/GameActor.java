package com.savefish.render;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.savefish.screens.game.GameMiddleStage;

public abstract class GameActor extends Actor {

	protected GameMiddleStage gameMiddleStage = null;

	public GameActor(GameMiddleStage gameMiddleStage) {
		super();
		this.gameMiddleStage = gameMiddleStage;
	}

	@Override
	public Actor hit(float x, float y) {
		return null;
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
	}
}
