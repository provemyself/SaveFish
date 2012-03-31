package com.savefish.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MainMenuStage extends Stage {

	private static MainMenuStage mainMenuStage = null;

	public static MainMenuStage getInstance() {
		if (null == mainMenuStage)
			mainMenuStage = new MainMenuStage();
		return mainMenuStage;
	}

	private MainMenuStage() {
		super(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
		this.initMainMenuImage();
	}

	@SuppressWarnings("unused")
	private Image mainMenuImage = null;

	private void initMainMenuImage() {
	}
}
