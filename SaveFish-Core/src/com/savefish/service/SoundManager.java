package com.savefish.service;

/********************************
 * Description: 该类是音效管理器，负责
 *              音效的设置
 * Author     : 王志伟
 * Date       : 2012/03/08
 *******************************/

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

	/**
	 * @description 音量的取值区间<0, 1>
	 */
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
