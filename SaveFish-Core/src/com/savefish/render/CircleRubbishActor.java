package com.savefish.render;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.savefish.assets.Assets;
import com.savefish.constant.Constant;
import com.savefish.screens.game.GameMiddleStage;

public class CircleRubbishActor extends GameActor {

	private Body body = null;
	private SpriteBatch spriteBatch = null;

	public static CircleRubbishActor createInstance(
			GameMiddleStage gameMiddleStage, Body body) {
		return new CircleRubbishActor(gameMiddleStage, body);
	}

	private CircleRubbishActor(GameMiddleStage gameMiddleStage, Body body) {
		super(gameMiddleStage);
		this.body = body;
		this.spriteBatch = new SpriteBatch();
		this.initShape();
		this.initSprite();
	}

	public static boolean isCircleRubbishActor(Body body) {
		String bodyName = (String) body.getUserData();
		return RubbishChecker.isCircleRubbish(bodyName);
	}

	private CircleShape shape = null;

	private void initShape() {
		if (null != body) {
			List<Fixture> fixtures = body.getFixtureList();
			Fixture fixture = null;
			if ((null != fixtures) && (fixtures.size() > 0))
				fixture = fixtures.get(0);
			if ((null != fixture)
					&& (fixture.getShape() instanceof CircleShape))
				this.shape = (CircleShape) fixture.getShape();
		}
	}

	private Sprite sprite = null;

	private void initSprite() {
		this.sprite = Assets.getInstance().getSprite(
				Constant.rubbish.PESTICIDE_ONE);
		this.sprite.setScale(0.4f);
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		if (null == shape)
			return;
		float radius = this.shape.getRadius();
		this.spriteBatch
				.setProjectionMatrix(gameMiddleStage.getCamera().combined);
		Vector3 position = new Vector3(body.getPosition().x - radius,
				body.getPosition().y - radius, 0);
		this.spriteBatch.begin();
		this.sprite.rotate(body.getAngle());
		this.sprite.setPosition(position.x * Constant.physics.RATE - 84,
				position.y * Constant.physics.RATE - 100);
		this.sprite.draw(spriteBatch);
		this.spriteBatch.end();
	}
}
