package com.savefish.render;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.savefish.assets.Assets;
import com.savefish.constant.Constant;
import com.savefish.screens.game.GameMiddleStage;
import com.savefish.util.RectangleHelper;

public class NatureRightFishActor extends GameActor {

	private Body body = null;
	private SpriteBatch spriteBatch = null;

	private Sprite currentSprite = null;
	private float stateTime;

	public static NatureRightFishActor createInstance(
			GameMiddleStage gameMiddleStage, Body body) {
		return new NatureRightFishActor(gameMiddleStage, body);
	}

	private NatureRightFishActor(GameMiddleStage gameMiddleStage, Body body) {
		super(gameMiddleStage);
		this.spriteBatch = new SpriteBatch();
		this.body = body;
		this.initLeftFishShape();
		this.initSpriteFrameList();
		this.initMoveAnimation();
		this.stateTime = 0f;
	}

	public static boolean isNatureFishActor(Body body) {
		boolean result = false;
		String bodyName = (String) body.getUserData();
		if ((null != bodyName) && (bodyName.startsWith("rnature")))
			result = true;
		else
			result = false;
		return result;
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		this.spriteBatch
				.setProjectionMatrix(this.gameMiddleStage.getCamera().combined);
		Vector3 position = new Vector3(body.getPosition().x
				- RectangleHelper.getRectangleData(leftFishShape).x / 2.0f,
				body.getPosition().y
						- RectangleHelper.getRectangleData(leftFishShape).y
						/ 2.0f, 0);

		this.stateTime += Gdx.graphics.getDeltaTime();
		this.currentSprite = new Sprite(this.fishAnimation.getKeyFrame(
				stateTime, true));
		this.currentSprite.setScale(0.3f);
		this.spriteBatch.begin();
		this.currentSprite.rotate(body.getAngle());
		this.currentSprite.setPosition(
				position.x * Constant.physics.RATE - 115, position.y
						* Constant.physics.RATE - 80);
		this.currentSprite.draw(spriteBatch);
		this.spriteBatch.end();
	}

	private PolygonShape leftFishShape = null;

	private final void initLeftFishShape() {
		if (null != body) {
			List<Fixture> fixtures = body.getFixtureList();
			Fixture fixture = null;
			if ((null != fixtures) && (fixtures.size() > 0))
				fixture = fixtures.get(0);
			if ((null != fixture)
					&& (fixture.getShape() instanceof PolygonShape))
				this.leftFishShape = (PolygonShape) fixture.getShape();
		}
	}

	private List<TextureRegion> spriteFrameList = null;

	private void initSpriteFrameList() {
		this.spriteFrameList = new ArrayList<TextureRegion>();
		this.spriteFrameList.add(Assets.getInstance().getSpriteRigion(
				Constant.asset.RFISH_ONE_ONE));
		this.spriteFrameList.add(Assets.getInstance().getSpriteRigion(
				Constant.asset.RFISH_ONE_TWO));
		this.spriteFrameList.add(Assets.getInstance().getSpriteRigion(
				Constant.asset.RFISH_ONE_ONE));
		this.spriteFrameList.add(Assets.getInstance().getSpriteRigion(
				Constant.asset.RFISH_ONE_TWO));
	}

	private Animation fishAnimation = null;

	private void initMoveAnimation() {
		this.fishAnimation = new Animation(0.25f, Assets.getInstance()
				.getNatureRight());
	}
}