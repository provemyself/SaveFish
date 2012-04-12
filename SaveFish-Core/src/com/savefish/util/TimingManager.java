package com.savefish.util;

/********************************
 * Description: 该类对游戏时间进行计时
 * Author     : 王志伟
 * Date       : 2012/04/01
 *******************************/

import org.lwjgl.util.Timer;

import com.badlogic.gdx.Game;
import com.savefish.screens.HighScoreScreen;

public class TimingManager {
	private static TimingManager manager = null;

	public static TimingManager getInstance(Game game) {
		if (null == manager)
			manager = new TimingManager(game);
		return manager;
	}

	public void start() {
		Timer.tick();
		doTask();
	}

	public float getTime() {
		return timer.getTime();
	}

	private Timer timer;
	private Game game;

	private TimingManager(Game game) {
		this.timer = new Timer();
		this.game = game;
	}

	private void doTask() {
		if ((int) (timer.getTime() + 1) % 10 == 0) {
			timer.reset();
			game.setScreen(HighScoreScreen.getInstance(game));
		}
	}

	public void dispose() {
		this.timer = null;
		this.game = null;
	}
}
