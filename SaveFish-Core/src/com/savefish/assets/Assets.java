package com.savefish.assets;

/********************************
 * Description: 该类为资产管理类，负责
 *              资产加载读入内存
 * Author     : 王志伟
 * Date       : 2012/03/08
 *******************************/

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
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

	/**
	 * @description 这是一个单例模式
	 * @return
	 */
	public static Assets getInstance() {
		if (null == assets)
			assets = new Assets();
		return assets;
	}

	@SuppressWarnings("unused")
	private boolean isComplete = false;

	private TextureAtlas actorAtlas = null;

	public void setActorAtlas() {
		this.actorAtlas = this.getActorAtlas();
	}

	private TextureAtlas spriteAtlas = null;

	private void setSpriteAtlas() {
		this.spriteAtlas = this.getSpriteAtlas();
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
		this.setActorAtlas();
		this.setSpriteAtlas();
	}

	private TextureAtlas getActorAtlas() {
		TextureAtlas atlas = assetManager.get(Constant.asset.ACTORS_BASE_PATH
				+ Constant.asset.ACTORS_PACK, TextureAtlas.class);
		return atlas;
	}

	private TextureAtlas getSpriteAtlas() {
		TextureAtlas atlas = assetManager.get(Constant.asset.SPRITES_BASE_PATH
				+ Constant.asset.SPRITES_PACT, TextureAtlas.class);
		return atlas;
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

	/**
	 * @description 根据名字获取精灵
	 * @param fileName
	 * @return
	 */
	public Sprite getSprite(String fileName) {
		return this.spriteAtlas.createSprite(fileName);
	}

	public TextureRegion getSpriteRigion(String fileName) {
		return this.spriteAtlas.findRegion(fileName);
	}

	/**
	 * @description 根据名字获取纹理区域
	 * @param fileName
	 * @return
	 */
	public TextureRegion getTextureRegion(String fileName) {
		return this.actorAtlas.findRegion(fileName);
	}

	/**
	 * @description 根据名字获取位图字体
	 * @param fileName
	 * @return
	 */
	public BitmapFont getBitmapFont(String fileName) {
		return assetManager.get(Constant.asset.FONTS_BASE_PATH + fileName,
				BitmapFont.class);
	}

	/**
	 * @description 根据名字获取背景音乐对象
	 * @param fileName
	 * @return
	 */
	public Music getMusic(String fileName) {
		return assetManager.get(Constant.asset.MUSICS_BASE_PATH + fileName,
				Music.class);
	}

	/**
	 * @description 根据名字获取Pixmap
	 * @param fileName
	 * @return
	 */
	public Pixmap getPixmap(String fileName) {
		return assetManager.get(Constant.asset.PIXMAPS_BASE_PATH + fileName,
				Pixmap.class);
	}

	/**
	 * @description 根据名字获取音效对象
	 * @param fileName
	 * @return
	 */
	public Sound getSound(String fileName) {
		return assetManager.get(Constant.asset.SOUNDS_BASE_PATH + fileName,
				Sound.class);
	}

	/**
	 * @description 释放资源
	 */
	public void dispose() {
		this.assetManager.clear();
	}

	/**
	 * @description 加载资源
	 */
	private void load() {
		this.loadBitmapFont();
		this.loadMusic();
		this.loadSound();
		this.loadPixmap();
		this.loadTextureAtlas();
	}

	/**
	 * @description 加载位图字体资源
	 */
	private void loadBitmapFont() {

	}

	/**
	 * @description 加载背景音乐资源
	 */
	private void loadMusic() {
		this.assetManager.load(Constant.asset.MUSICS_BASE_PATH
				+ Constant.asset.MUSIC, Music.class);
	}

	/**
	 * @description 加载Pixmap资源
	 */
	private void loadPixmap() {

	}

	/**
	 * @description 加载音效资源
	 */
	private void loadSound() {
		this.assetManager.load(Constant.asset.SOUNDS_BASE_PATH
				+ Constant.asset.SLIDE_SOUND, Sound.class);
		this.assetManager.load(Constant.asset.SOUNDS_BASE_PATH
				+ Constant.asset.EAT_SOUND, Sound.class);
	}

	/**
	 * @description 加载TextureAtlas资源
	 */
	private void loadTextureAtlas() {
		this.assetManager.load(Constant.asset.ACTORS_BASE_PATH
				+ Constant.asset.ACTORS_PACK, TextureAtlas.class);
		this.assetManager.load(Constant.asset.SPRITES_BASE_PATH
				+ Constant.asset.SPRITES_PACT, TextureAtlas.class);
	}

}
