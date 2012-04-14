package com.savefish.service;

import com.badlogic.gdx.audio.Sound;

public abstract class AbstractSound implements Managable {

	protected Sound sound = null;

	public void play() {
		if (null != sound)
			sound.play();
	}

	public void stop() {
		if (null != sound)
			sound.stop();
	}

	@Override
	public void dispose() {
		this.sound.dispose();
	}

}
