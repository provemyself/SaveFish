package com.savefish.screens;

import com.badlogic.gdx.Game;

public class LoaderScreen extends Game {

	@Override
	public void create() {
		// TODO Auto-generated method stub
		try {
			setScreen(new GameScreen(this));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
