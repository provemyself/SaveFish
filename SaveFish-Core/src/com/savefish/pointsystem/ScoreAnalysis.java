package com.savefish.pointsystem;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.physics.box2d.Body;
import com.savefish.constant.Constant;
import com.savefish.render.RubbishChecker;

public class ScoreAnalysis {
	public static void destroyCount(Game game, Body body) {
		String bodyName = (String) body.getUserData();
		if (RubbishChecker.isElectricBattery(bodyName)) {
			GameScore.currentLevelScore.setCrossScore(ScoreDictionary
					.getIncreaseScore(Constant.rubbish.ELECTRIC_BATTERY));
		} else if (RubbishChecker.isPesticide(bodyName)) {
			GameScore.currentLevelScore.setCrossScore(ScoreDictionary
					.getIncreaseScore(Constant.rubbish.PESTICIDE));
		} else if (RubbishChecker.isRadioactive(bodyName)) {
			GameScore.currentLevelScore.setCrossScore(ScoreDictionary
					.getIncreaseScore(Constant.rubbish.RADIOACTIVE_MATERIAL));
		} else if (RubbishChecker.isThermograph(bodyName)) {
			GameScore.currentLevelScore.setCrossScore(ScoreDictionary
					.getIncreaseScore(Constant.rubbish.THERMOGRAPH));
		}
	}
}
