package com.savefish.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.savefish.constant.Constant;

public class Assets {

	private AssetManager assetManager = new AssetManager();

	private static Assets assets = null;

	private Assets() {
		this.load();
		this.setComplete(false);
	}

	public static Assets getInstance() {
		if (null == assets)
			assets = new Assets();
		return assets;
	}

	private boolean isComplete = false;

	private boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public boolean update() {
		return assetManager.update();
	}

	public float getProgress() {
		return assetManager.getProgress();
	}

	public float getLoadedProgress() {
		return assetManager.getLoadedAssets();
	}

	public Texture getTexture(String fileName) {
		if (this.isComplete())
			return assetManager.get(Constant.asset.TEXTURES_BASE_PATH
					+ fileName, Texture.class);
		else
			return null;
	}

	public BitmapFont getBitmapFont(String fileName) {
		if (this.isComplete())
			return assetManager.get(Constant.asset.FONTS_BASE_PATH + fileName,
					BitmapFont.class);
		else
			return null;
	}

	public Music getMusic(String fileName) {
		if (this.isComplete())
			return assetManager.get(Constant.asset.MUSICS_BASE_PATH + fileName,
					Music.class);
		else
			return null;
	}

	public Pixmap getPixmap(String fileName) {
		if (this.isComplete())
			return assetManager.get(
					Constant.asset.PIXMAPS_BASE_PATH + fileName, Pixmap.class);
		else
			return null;
	}

	public Sound getSound(String fileName) {
		if (this.isComplete())
			return assetManager.get(Constant.asset.SOUNDS_BASE_PATH + fileName,
					Sound.class);
		else
			return null;
	}

	public void unload(String fileName) {
		this.assetManager.unload(fileName);
	}

	public void clear() {
		this.assetManager.clear();
	}

	public void dispose() {
		this.assetManager.dispose();
	}

	private void load() {
		this.loadTexture();
		this.loadBitmapFont();
		this.loadMusic();
		this.loadSound();
		this.loadPixmap();
	}

	private void loadTexture() {
		this.assetManager.load(Constant.asset.TEXTURES_BASE_PATH
				+ Constant.asset.QUIT, Texture.class);
		this.assetManager.load(Constant.asset.TEXTURES_BASE_PATH
				+ Constant.asset.START, Texture.class);
		this.assetManager.load(Constant.asset.TEXTURES_BASE_PATH
				+ Constant.asset.MENU_128_64, Texture.class);
		this.assetManager.load(Constant.asset.TEXTURES_BASE_PATH
				+ Constant.asset.NEXT_128_64, Texture.class);
		this.assetManager.load(Constant.asset.TEXTURES_BASE_PATH
				+ Constant.asset.EXIT, Texture.class);
		this.assetManager.load(Constant.asset.TEXTURES_BASE_PATH
				+ Constant.asset.BACKGROUND_ONE, Texture.class);
	}

	private void loadBitmapFont() {

	}

	private void loadMusic() {
		this.assetManager.load(Constant.asset.MUSICS_BASE_PATH
				+ Constant.asset.MUSIC, Music.class);
	}

	private void loadPixmap() {

	}

	private void loadSound() {
		this.assetManager.load(Constant.asset.SOUNDS_BASE_PATH
				+ Constant.asset.SOUND, Sound.class);
	}
}
