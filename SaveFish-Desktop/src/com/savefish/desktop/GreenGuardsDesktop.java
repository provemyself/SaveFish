package com.savefish.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.savefish.constant.Constants;
import com.savefish.service.ApplicationManager;

public class GreenGuardsDesktop {

	public static void main(String[] argv) {
		new LwjglApplication(new ApplicationManager(),
				Constants.game.GAME_NAME, Constants.screen.SCREEN_WIDTH,
				Constants.screen.SCREEN_HEIGHT, false);
	}
}
