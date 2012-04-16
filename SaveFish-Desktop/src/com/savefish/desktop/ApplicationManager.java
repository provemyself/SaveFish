package com.savefish.desktop;

/********************************
 * Description: 该类是应用程序管理器
 *              负责游戏日志，循环
 * Author     : 王志伟
 * Date       : 2012/03/08
 *******************************/

import java.util.logging.Level;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.savefish.assets.Assets;
import com.savefish.screens.LoadingScreen;
import com.savefish.service.LoadedManager;
import com.savefish.service.LoadedScreen;
import com.savefish.service.Managable;
import com.savefish.util.GreenLogger;
import com.savefish.util.GreenLoggerManager;

public class ApplicationManager extends Game {

	public ApplicationManager() {
		GreenLoggerManager.filterLogByLevel(Level.OFF);
		
	}

	@Override
	public void create() {
		try {
			setScreen(new LoadingScreen(this));
		} catch (Exception e) {
			GreenLogger.getInstance().logp(Level.INFO,
					ApplicationManager.class.getName(), "create", e.toString(),
					e);
		}
	}

	@Override
	public void setScreen(Screen screen) {
		super.setScreen(screen);

		GreenLogger.getInstance().log(Level.INFO,
				"The current screen is " + screen.toString());
	}

	@Override
	public void dispose() {
		GreenLogger.getInstance().logp(Level.INFO,
				ApplicationManager.class.getName(), "dispose", "called!");

		this.disposeScreens();
		this.disposeManagers();
		this.disposeAssets();
		DesktopLauncher.saveFish.exit();

		GreenLogger.getInstance().log(Level.INFO, "Game exited sucessfully!");
	}

	private void disposeScreens() {
		if ((null != LoadedScreen.screens) && (LoadedScreen.screens.size() > 0)) {
			for (Screen screen : LoadedScreen.screens) {
				if (null != screen)
					screen.dispose();
			}
		}
		LoadedScreen.screens = null;
	}

	private void disposeManagers() {
		if ((null != LoadedManager.managers)
				&& (LoadedManager.managers.size() > 0)) {
			for (Managable manager : LoadedManager.managers) {
				if (null != manager)
					manager.dispose();
			}
		}
		LoadedManager.managers = null;
	}

	private void disposeAssets() {
		Assets.getInstance().dispose();
	}

}
