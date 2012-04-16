package com.savefish.service;

/********************************
 * Description: 该类是音乐管理器，负责
 *              背景音乐的加载与播放
 * Author     : 王志伟
 * Date       : 2012/03/08
 *******************************/

import com.badlogic.gdx.audio.Music;
import com.savefish.assets.Assets;
import com.savefish.constant.Constant;

public class BackgroundMusic implements Managable {

	public static boolean isEnable = true;
	private static BackgroundMusic backgroundMusic = null;

	public static BackgroundMusic getInstance() {
		if (null == backgroundMusic)
			backgroundMusic = new BackgroundMusic();
		LoadedManager.managers.add(backgroundMusic);
		return backgroundMusic;
	}

	private BackgroundMusic() {
		this.initMusic();
	}

	private Music music = null;

	private void initMusic() {
		this.music = Assets.getInstance().getMusic(Constant.asset.MUSIC);
	}

	public void play() {
		if (isEnable) {
			this.music.play();
			this.music.setLooping(true);
			this.music.setVolume(1);
		}
	}

	public void stop() {
		this.music.pause();
	}

	public void dispose() {
		this.music.dispose();
	}

}
