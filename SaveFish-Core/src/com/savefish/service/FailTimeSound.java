package com.savefish.service;

import com.badlogic.gdx.audio.Sound;
import com.savefish.assets.Assets;
import com.savefish.constant.Constant;

public class FailTimeSound {
	public static boolean isEnable = true;
	private static FailTimeSound failTimeSound = null;

	public static FailTimeSound getInstance() {
		if (null == failTimeSound)
			failTimeSound = new FailTimeSound();
		return failTimeSound;
	}

	private Sound sound = null;

	private FailTimeSound() {
		sound = Assets.getInstance().getSound(Constant.sound.FAIL_TIME_SOUND);
	}

	public void play() {
		if (isEnable)
			this.sound.play();
	}

	public void dispose() {
		failTimeSound = null;
	}
}
