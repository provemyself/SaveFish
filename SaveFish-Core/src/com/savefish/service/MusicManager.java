package com.savefish.service;

public class MusicManager implements Managable {

	public static void enableMusic() {
		BackgroundMusic.isEnable = true;
	}

	public static void disableMusic() {
		BackgroundMusic.getInstance().stop();
		BackgroundMusic.isEnable = false;
	}

	@Override
	public void dispose() {
	}

}
