package com.savefish.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.savefish.constant.Constant;

public class DesktopLauncher {

	public static LwjglApplication saveFish = null;

	public static void main(String[] argv) {
		saveFish = new LwjglApplication(new ApplicationManager(),
				Constant.game.GAME_NAME, 480, 320, false);
	}

}
