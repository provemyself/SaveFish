package com.savefish.actor;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class ActorFactory {

	public static BodyAttachedActor createActor(Body body, Stage stage) {

		if (CircleSnakeActor.isCircleSnake(body)) {
			return new CircleSnakeActor(stage, body);
		}

		if (CircleMouseActor.isCircleMouse(body)) {
			return new CircleMouseActor(stage, body);
		}
		if (CircleWoodActor.isCircleWood(body)) {
			return new CircleWoodActor(stage, body);
		}
		if (SqureWoodActor.isSqureWood(body)) {
			return new SqureWoodActor(stage, body);
		}
		return null;
	}
}
