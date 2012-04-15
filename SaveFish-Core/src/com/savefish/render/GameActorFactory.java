package com.savefish.render;

import com.badlogic.gdx.physics.box2d.Body;
import com.savefish.screens.game.GameMiddleStage;

public class GameActorFactory {
	public static GameActor createGameActor(GameMiddleStage stage, Body body) {
		GameActor actor = null;

		if (NatureRightFishActor.isNatureFishActor(body))
			actor = NatureRightFishActor.createInstance(stage, body);
		if (NatureLeftFishActor.isNatureLeftFishActor(body))
			actor = NatureLeftFishActor.createInstance(stage, body);
		if (ArtificialFishActor.isArtificialFishActor(body))
			actor = ArtificialFishActor.createInstance(stage, body);
		if (CircleRubbishActor.isCircleRubbishActor(body))
			actor = CircleRubbishActor.createInstance(stage, body);
		if (PolygonRubbishActor.isPolygonRubbishActor(body))
			actor = PolygonRubbishActor.createInstance(stage, body);

		return actor;
	}
}
