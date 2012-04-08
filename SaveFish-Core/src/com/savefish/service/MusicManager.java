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

public class MusicManager implements Managable {

	private static MusicManager musicManager = null;

	public static MusicManager getInstance() {
		if (null == musicManager)
			musicManager = new MusicManager();
		LoadedManager.managers.add(musicManager);
		return musicManager;
	}

	private MusicManager() {
		this.initMusic();
	}

	private Music music = null;

	private void initMusic() {
		this.music = Assets.getInstance().getMusic(Constant.asset.MUSIC);
	}

	public void play() {
		this.music.play();
		this.music.setLooping(true);
		this.music.setVolume(1);
	}

	public void pause() {
		this.music.pause();
	}

	public void stop() {
		this.music.stop();
	}

	public void dispose() {
		this.music.dispose();
	}

}
