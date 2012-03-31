package com.savefish.actor;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class CircleSnakeActor extends BodyAttachedActor {

	CircleShape shape = null;
	Body body = null;
	Texture texture;
	SpriteBatch batch;
	Sprite sprite;

	public static boolean isCircleSnake(Body body) {
		String name = (String) body.getUserData();
		Fixture fixture = null;
		if (name != null) {
			if (name.startsWith("CircleSnake_")) {
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
			if (name.startsWith("CircleSnake_")) {
				for (Fixture f : body.getFixtureList()) {
					if (f.getShape() instanceof CircleShape) {
						return (CircleShape) f.getShape();
					}
				}
			}
		}
		return null;
	}

	public CircleSnakeActor(Stage stage, Body body) {
		super(stage);
		if (!CircleSnakeActor.isCircleSnake(body)) {
		} else {
			this.batch = new SpriteBatch();

			this.body = body;
			this.shape = this.getCircleShape(body);
			String m = (String) body.getUserData();
			m = m.substring("CircleSnake_".length());
//			this.texture = 	ResourceLoader.loadTexture(m);
			this.sprite = new Sprite(texture);
		}
	}

	@Override
	public void draw(SpriteBatch spriteBacth, float dt) {

		this.batch.begin();
		try {
			this.batch.setProjectionMatrix(this.stage.getCamera().combined);
			float r = this.shape.getRadius();
			@SuppressWarnings("unused")
			Vector3 pos = new Vector3(body.getPosition().x - r,
					body.getPosition().y - r, 0);
			float angle = this.body.getAngle();
			this.sprite.setRotation((float) (angle * 180 / 3.14));
//			this.sprite.setPosition(pos.x * B2Const.CONVERTRATIO , pos.y
//					* B2Const.CONVERTRATIO );
			this.sprite.draw(batch);

		} catch (Exception e) {
			this.stage.removeActor(this);
		}

		this.batch.end();
	}

}
