package com.savefish.service;

import com.badlogic.gdx.audio.Sound;
import com.savefish.assets.Assets;
import com.savefish.constant.Constant;

public class EatSound {
	public static boolean isEnable = true;

	public static EatSound createInstance() {
		return new EatSound();
	}

	private Sound sound = null;

	private EatSound() {
		sound = Assets.getInstance().getSound(Constant.sound.EAT_SOUND);
	}

	public void play() {
		if (isEnable)
			this.sound.play();
	}

	public void stop() {

	}

	public void dispose() {
		sound.dispose();
	}
}
