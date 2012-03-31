package com.savefish.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.savefish.constant.Constant;

public class Assets {

	private AssetManager assetManager = new AssetManager();

	private static Assets assets = null;

	private Assets() {
		this.assetManager.clear();
		this.load();
	}

	public static Assets getInstance() {
		if (null == assets)
			assets = new Assets();
		return assets;
	}

	private boolean isComplete = false;
	private TextureAtlas textureAtlas = null;

	private boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
		this.textureAtlas = this.getTextureAtlas();
	}

	private TextureAtlas getTextureAtlas() {
		if (this.isComplete()) {
			return assetManager.get(Constant.asset.TEXTURES_BASE_PATH
					+ Constant.asset.ACTORS_PACK, TextureAtlas.class);
		} else {
			return null;
		}
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

	public TextureRegion getTextureRegion(String fileName) {
		if (this.isComplete())
			return this.textureAtlas.findRegion(fileName);
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

	public void dispose() {
		this.assetManager.clear();
	}

	private void load() {
		this.loadBitmapFont();
		this.loadMusic();
		this.loadSound();
		this.loadPixmap();
		this.loadTextureAtlas();
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

	private void loadTextureAtlas() {
		this.assetManager.load(Constant.asset.ACTORS_BASE_PATH
				+ Constant.asset.ACTORS_PACK, TextureAtlas.class);
		this.assetManager.load(Constant.asset.TEXTURES_BASE_PATH
				+ Constant.asset.ACTORS_PACK, TextureAtlas.class);
	}
}
