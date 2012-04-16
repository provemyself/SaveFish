package com.savefish.service;

import com.badlogic.gdx.audio.Sound;
import com.savefish.assets.Assets;
import com.savefish.constant.Constant;

public class EatSound {
	public static boolean isEnable = true;
	private static EatSound deadSound = null;

	public static EatSound getInstance() {
		if (null == deadSound)
			deadSound = new EatSound();
		return deadSound;
	}

	private Sound sound = null;

	private EatSound() {
		sound = Assets.getInstance().getSound(Constant.asset.EAT_SOUND);
	}

	public void play() {
		if (isEnable)
			this.sound.play();
	}

	public void stop() {

	}

	public void dispose() {
		deadSound = null;
	}
}
