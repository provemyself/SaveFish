package com.savefish.service;

public class SoundManager implements Managable {

	public static void enableSound() {
		ContactSound.isEnable = true;
		EatSound.isEnable = true;
		FailFishSound.isEnable = true;
		FailTimeSound.isEnable = true;
		SlideSound.isEnable = true;
		WinSound.isEnable = true;
	}

	public static void disableSound() {
		ContactSound.isEnable = false;
		EatSound.isEnable = false;
		FailFishSound.isEnable = false;
		FailTimeSound.isEnable = false;
		SlideSound.isEnable = false;
		WinSound.isEnable = false;
	}

	@Override
	public void dispose() {
	}

}
