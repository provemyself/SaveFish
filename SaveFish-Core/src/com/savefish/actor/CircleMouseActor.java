package com.savefish.actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class CircleMouseActor extends BodyAttachedActor {

	CircleShape shape = null;
	Body body = null;
	Texture texture = null;
	SpriteBatch batch = null;
	Sprite sprite = null;

	public static boolean isCircleMouse(Body body) {
		String name = (String) body.getUserData();
		Fixture fixture = null;
		if (name != null) {
			if (name.startsWith("CircleMouse_")) {
				for (Fixture f : body.getFixtureList()) {
					if (f.getShape() instanceof CircleShape) {
						fixture = f;
						break;
					}
				}
			}
		}
		return fixture != null;
	}

	public CircleShape getCircleShape(Body body) {
		String name = (String) body.getUserData();
		if (name != null) {
			if (name.startsWith("CircleMouse_")) {
				for (Fixture f : body.getFixtureList()) {
					if (f.getShape() instanceof CircleShape) {
						return (CircleShape) f.getShape();
					}
				}
			}
		}
		return null;
	}

	public CircleMouseActor(Stage stage, Body body) {
		super(stage);
		if (!CircleMouseActor.isCircleMouse(body)) {
		} else {
			this.batch = new SpriteBatch();

			this.body = body;
			this.shape = this.getCircleShape(body);
			String m = (String) body.getUserData();
			m = m.substring("CircleMouse_".length());
//			this.texture = ResourceLoader.loadTexture(m);
			this.sprite = new Sprite(texture);
			this.sprite.setRegionX(4);
			this.sprite.setRegionY(-20);
		}
	}

	@SuppressWarnings("unused")
	@Override
	public void draw(SpriteBatch spriteBacth, float dt) {

		try {
			this.batch.setProjectionMatrix(this.stage.getCamera().combined);
			float r = this.shape.getRadius();
			Vector3 pos = new Vector3(body.getPosition().x - r,
					body.getPosition().y - r, 0);

			this.batch.begin();
			this.sprite.rotate(this.body.getAngle());

//			this.batch.draw(this.sprite, pos.x * B2Const.CONVERTRATIO, pos.y
//					* B2Const.CONVERTRATIO-40);

			this.batch.end();

		} catch (Exception e) {
			this.stage.removeActor(this);
		}
	}

}
