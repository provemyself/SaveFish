package com.savefish.service;

import com.badlogic.gdx.audio.Sound;
import com.savefish.assets.Assets;
import com.savefish.constant.Constant;

public class ContactSound {

	public static boolean isEnable = true;
	private static ContactSound contactSound = null;

	public static ContactSound getInstance() {
		if (null == contactSound)
			contactSound = new ContactSound();
		return contactSound;
	}

	private Sound sound = null;

	private ContactSound() {
		sound = Assets.getInstance().getSound(Constant.sound.CONTACT_SOUND);
	}

	public void play() {
		if (isEnable)
			this.sound.play();
	}

	public void dispose() {
		contactSound = null;
	}

}
