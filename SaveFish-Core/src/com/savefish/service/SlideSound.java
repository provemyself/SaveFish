package com.savefish.service;

import com.badlogic.gdx.audio.Sound;
import com.savefish.assets.Assets;
import com.savefish.constant.Constant;

public class SlideSound {
	public static boolean isEnable = true;
	private static SlideSound slideSound = null;

	public static SlideSound getInstance() {
		if (null == slideSound)
			slideSound = new SlideSound();
		return slideSound;
	}

	private Sound sound = null;

	private SlideSound() {
		sound = Assets.getInstance().getSound(Constant.asset.SLIDE_SOUND);
	}

	public void play() {
		if (isEnable)
			this.sound.play();
	}

	public void dispose() {
		slideSound = null;
	}
}
