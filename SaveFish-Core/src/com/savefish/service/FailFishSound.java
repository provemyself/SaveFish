package com.savefish.service;

import com.badlogic.gdx.audio.Sound;
import com.savefish.assets.Assets;
import com.savefish.constant.Constant;

public class FailFishSound {
	public static boolean isEnable = true;
	private static FailFishSound failFishSound = null;

	public static FailFishSound getInstance() {
		if (null == failFishSound)
			failFishSound = new FailFishSound();
		return failFishSound;
	}

	private Sound sound = null;

	private FailFishSound() {
		sound = Assets.getInstance().getSound(Constant.sound.FAIL_FISH_SOUND);
	}

	public void play() {
		if (isEnable)
			this.sound.play();
	}

	public void dispose() {
		failFishSound = null;
	}
}
