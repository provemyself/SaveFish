package com.savefish.service;

import com.badlogic.gdx.audio.Sound;
import com.savefish.assets.Assets;
import com.savefish.constant.Constant;

public class WinSound {
	public static boolean isEnable = true;
	private static WinSound winSound = null;

	public static WinSound getInstance() {
		if (null == winSound)
			winSound = new WinSound();
		return winSound;
	}

	private Sound sound = null;

	private WinSound() {
		sound = Assets.getInstance().getSound(Constant.asset.WIN_SOUND);
	}

	public void play() {
		if (isEnable)
			this.sound.play();
	}

	public void dispose() {
		winSound = null;
	}
}
