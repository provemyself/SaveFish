package com.savefish.service;

import com.badlogic.gdx.audio.Sound;
import com.savefish.assets.Assets;
import com.savefish.constant.Constant;

public class SlideSound {
	public static boolean isEnable = true;

	public static SlideSound createInstance() {
		return new SlideSound();
	}

	private Sound sound = null;

	private SlideSound() {
		sound = Assets.getInstance().getSound(Constant.sound.SLIDE_SOUND);
	}

	public void play() {
		if (isEnable)
			this.sound.play();
	}

	public void dispose() {
		sound.dispose(); 
	}
}
