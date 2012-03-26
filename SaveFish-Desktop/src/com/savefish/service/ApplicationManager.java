package com.savefish.service;

import java.util.logging.Level;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.savefish.assets.Assets;
import com.savefish.desktop.GreenGuardsDesktop;
import com.savefish.screens.AboutScreen;
import com.savefish.screens.FailScreen;
import com.savefish.screens.HelpScreen;
import com.savefish.screens.HighScoreScreen;
import com.savefish.screens.LoadingScreen;
import com.savefish.screens.MainMenuScreen;
import com.savefish.screens.SettingScreen;
import com.savefish.screens.WinScreen;
import com.savefish.util.logger.GreenLogger;
import com.savefish.util.logger.GreenLoggerManager;

public class ApplicationManager extends Game {

	public ApplicationManager() {
		GreenLoggerManager.filterLogByLevel(Level.INFO);
	}

	@Override
	public void create() {
		try {
			setScreen(LoadingScreen.getInstance(this));

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
		// TODO Auto-generated method stub
		GreenLogger.getInstance().logp(Level.INFO,
				ApplicationManager.class.getName(), "dispose", "called!");

		AboutScreen.getInstance(this).dispose();
		FailScreen.getInstance(this).dispose();
		HelpScreen.getInstance(this).dispose();
		HighScoreScreen.getInstance(this).dispose();
		LoadingScreen.getInstance(this).dispose();
		MainMenuScreen.getInstance(this).dispose();
		SettingScreen.getInstance(this).dispose();
		WinScreen.getInstance(this).dispose();
		Assets.getInstance().dispose();
		super.dispose();
		GreenGuardsDesktop.saveFish.exit();

		GreenLogger.getInstance().log(Level.INFO, "Game exited sucessfully!");
	}

}
