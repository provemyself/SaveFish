package com.savefish.render;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.savefish.assets.Assets;
import com.savefish.constant.Constant;
import com.savefish.screens.game.GameMiddleStage;
import com.savefish.util.ShapeHelper;

public class PolygonRubbishActor extends GameActor {

	private Body body = null;
	private SpriteBatch spriteBatch = null;

	public static PolygonRubbishActor createInstance(
			GameMiddleStage gameMiddleStage, Body body) {
		return new PolygonRubbishActor(gameMiddleStage, body);
	}

	private PolygonRubbishActor(GameMiddleStage gameMiddleStage, Body body) {
		super(gameMiddleStage);
		this.body = body;
		this.spriteBatch = new SpriteBatch();
		this.initShape();
		this.initSprite();
	}

	public static boolean isPolygonRubbishActor(Body body) {
		String bodyName = (String) body.getUserData();
		return RubbishChecker.isPolygonRubbish(bodyName);
	}

	private PolygonShape shape = null;

	private void initShape() {
		if (null != body) {
			List<Fixture> fixtures = body.getFixtureList();
			Fixture fixture = null;
			if ((null != fixtures) && (fixtures.size() > 0))
				fixture = fixtures.get(0);
			if ((null != fixture)
					&& (fixture.getShape() instanceof PolygonShape))
				this.shape = (PolygonShape) fixture.getShape();
		}
	}

	private Sprite sprite = null;

	private void initSprite() {

		this.sprite = Assets.getInstance().getSprite(
				Constant.rubbish.PESTICIDE_TWO);
		this.sprite.setScale(0.2f);
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		this.spriteBatch
				.setProjectionMatrix(gameMiddleStage.getCamera().combined);

		Vector3 position = new Vector3(body.getPosition().x
				- ShapeHelper.getRectangleData(shape).x / 2.0f,
				body.getPosition().y - ShapeHelper.getRectangleData(shape).y
						/ 2.0f, 0);

		this.spriteBatch.begin();
		this.sprite.rotate(body.getAngle());
		this.sprite.setPosition(position.x * Constant.physics.RATE, position.y
				* Constant.physics.RATE - 115);
		this.sprite.draw(spriteBatch);
		this.spriteBatch.end();
	}

	@Override
	public boolean touchDown(float x, float y, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void touchUp(float x, float y, int pointer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void touchDragged(float x, float y, int pointer) {
		// TODO Auto-generated method stub
		
	}

}
