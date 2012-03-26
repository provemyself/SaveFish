package com.savefish.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.savefish.constant.Constant;
import com.savefish.service.ApplicationManager;

public class GreenGuardsDesktop {

	public static LwjglApplication saveFish = null;

	public static void main(String[] argv) {
		saveFish = new LwjglApplication(new ApplicationManager(),
				Constant.game.GAME_NAME, Constant.screen.SCREEN_WIDTH,
				Constant.screen.SCREEN_HEIGHT, false);
	}
}
