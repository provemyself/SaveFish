package com.savefish.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.savefish.constant.Constant;
import com.savefish.screens.LoaderScreen;

public class GreenGuardsDesktop {

	public static void main(String[] argv) {
		new LwjglApplication(new LoaderScreen(), Constant.game.GAME_NAME,
				Constant.screen.SCREEN_WIDTH, Constant.screen.SCREEN_HEIGHT,
				false);
	}
}
