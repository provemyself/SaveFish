package com.savefish.pointsystem;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.physics.box2d.Body;
import com.savefish.constant.Constant;
import com.savefish.render.RubbishChecker;
import com.savefish.screens.EndScreen;
import com.savefish.storage.CrossData;
import com.savefish.storage.HistoryScoreData;
import com.savefish.storage.StoreCrossRecord;

public class ScoreAnalysis {
	/**
	 * @description 累加玩家得分
	 * @param game
	 * @param body
	 */
	public static void increaseScore(Game game, Body body) {
		String bodyName = (String) body.getUserData();
		if (RubbishChecker.isRubbishBag(bodyName)) {
			GameScoreRecord.currentLevelScore.setCrossScore(ScoreDictionary
					.createInstance().getIncreaseScore(Constant.rubbish.RUBBISH_BAG));
		}
		if (RubbishChecker.isElectricBattery(bodyName)) {
			GameScoreRecord.currentLevelScore.setCrossScore(ScoreDictionary
					.createInstance().getIncreaseScore(Constant.rubbish.ELECTRIC_BATTERY));
		}
		if (RubbishChecker.isPesticide(bodyName)) {
			GameScoreRecord.currentLevelScore.setCrossScore(ScoreDictionary
					.createInstance().getIncreaseScore(Constant.rubbish.PESTICIDE));
		}
		if (RubbishChecker.isRadioactive(bodyName)) {
			GameScoreRecord.currentLevelScore.setCrossScore(ScoreDictionary
					.createInstance().getIncreaseScore(Constant.rubbish.RADIOACTIVE_MATERIAL));
		}
		if (RubbishChecker.isThermograph(bodyName)) {
			GameScoreRecord.currentLevelScore.setCrossScore(ScoreDictionary
					.createInstance().getIncreaseScore(Constant.rubbish.THERMOGRAPH));
		}
		checkPassFromScore(game, body);
	}

	private static void checkPassFromScore(Game game, Body body) {
		if (GameScoreRecord.currentLevelScore.getGameLevel().getCount() == GameScoreRecord.currentLevelScore
				.getKilledRubbish()) {
			GameResult.isPassed = true;
			StoreCrossRecord.store();
			CrossData cd = HistoryScoreData.getHistoryData();
			if (null != cd)
				System.out.println("历史河水清澈指数： " + cd.getCleanIndex());
			game.setScreen(new EndScreen(game));
		}
	}

	/**
	 * @description 减少河水清澈指数
	 * @param game
	 * @param body
	 */
	public static void decreaseIndex(Game game, Body body) {
		String bodyName = (String) body.getUserData();
		if (RubbishChecker.isRubbishBag(bodyName)) {
			GameScoreRecord.currentLevelScore
					.setCrossCleanIndex(-ScoreDictionary
							.createInstance().getIncreaseScore(Constant.rubbish.RUBBISH_BAG));
		}
		if (RubbishChecker.isElectricBattery(bodyName)) {
			GameScoreRecord.currentLevelScore
					.setCrossCleanIndex(-ScoreDictionary
							.createInstance().getIncreaseScore(Constant.rubbish.ELECTRIC_BATTERY));
		}
		if (RubbishChecker.isPesticide(bodyName)) {
			GameScoreRecord.currentLevelScore
					.setCrossCleanIndex(-ScoreDictionary
							.createInstance().getIncreaseScore(Constant.rubbish.PESTICIDE));
		}
		if (RubbishChecker.isRadioactive(bodyName)) {
			GameScoreRecord.currentLevelScore
					.setCrossCleanIndex(-ScoreDictionary
							.createInstance().getIncreaseScore(Constant.rubbish.RADIOACTIVE_MATERIAL));
		}
		if (RubbishChecker.isThermograph(bodyName)) {
			GameScoreRecord.currentLevelScore
					.setCrossCleanIndex(-ScoreDictionary
							.createInstance().getIncreaseScore(Constant.rubbish.THERMOGRAPH));
		}
		if (1 == CurrentLevel.level.getBig())
			checkPassFromIndex(game, body);
	}

	private static void checkPassFromIndex(Game game, Body body) {
		int cleanIndex = GameScoreRecord.currentLevelScore.getCrossCleanIndex();
		int boundaryIndex = WaterDictionary.createInstance().getBoundaryIndex(
				CurrentLevel.level);
		if (cleanIndex < boundaryIndex) {
			GameResult.isPassed = false;
			game.setScreen(new EndScreen(game));
		}
	}

}
