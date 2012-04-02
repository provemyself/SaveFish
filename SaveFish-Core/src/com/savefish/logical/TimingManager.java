package com.savefish.logical;

import java.util.Timer;
import java.util.TimerTask;

import com.badlogic.gdx.Game;
import com.savefish.constant.Constant;
import com.savefish.screens.HighScoreScreen;

public class TimingManager {

	public TimingManager creatTimingManager(Game game) {
		return new TimingManager(game);
	}

	public void start() {
		this.timer.schedule(new TimingTask(), Constant.game.GAME_DELAY);
	}

	private Game game = null;
	private Timer timer = null;

	private TimingManager(Game game) {
		this.game = game;
		this.timer = new Timer();
	}

	class TimingTask extends TimerTask {

		@Override
		public void run() {
			game.setScreen(HighScoreScreen.getInstance(game));
		}

	}

}
