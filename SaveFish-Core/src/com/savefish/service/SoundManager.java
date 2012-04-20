package com.savefish.service;

public class SoundManager implements Managable {

	public static void enableSound() {
		EatSound.isEnable = true;
		SlideSound.isEnable = true;
	}

	public static void disableSound() {
		EatSound.isEnable = false;
		SlideSound.isEnable = false;
	}

	@Override
	public void dispose() {
	}
}
