package com.savefish.service;

import com.badlogic.gdx.audio.Sound;
import com.savefish.assets.Assets;
import com.savefish.constant.Constant;

public class SoundManager implements Managable {

	public static SoundManager getInstance() {
		if (null == soundManager)
			soundManager = new SoundManager();
		LoadedManager.managers.add(soundManager);
		return soundManager;
	}

	private static SoundManager soundManager = null;

	private Sound sound = null;

	private SoundManager() {
		this.sound = Assets.getInstance().getSound(Constant.asset.SOUND);
	}

	public void play() {
		this.sound.play(1);
	}

	public void stop() {
		this.sound.stop();
	}

	public void dispose() {
		this.sound.dispose();
	}

}
