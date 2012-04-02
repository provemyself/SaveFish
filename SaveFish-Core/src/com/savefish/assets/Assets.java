package com.savefish.assets;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

	public static Assets getInstance() {
		if (null == assets)
			assets = new Assets();
		return assets;
	}

	private boolean isComplete = false;

	private TextureAtlas actorAtlas = null;

	public void setActorAtlas() {
		this.actorAtlas = this.getActorAtlas();
	}

	private TextureAtlas spriteAtlas = null;

	private void setSpriteAtlas() {
		this.spriteAtlas = this.getSpriteAtlas();
	}

	private boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
		this.setActorAtlas();
		this.setSpriteAtlas();
		this.initialize();
	}

	private TextureAtlas getActorAtlas() {
		return assetManager.get(Constant.asset.ACTORS_BASE_PATH
				+ Constant.asset.ACTORS_PACK, TextureAtlas.class);
	}

	private TextureAtlas getSpriteAtlas() {
		return assetManager.get(Constant.asset.SPRITES_BASE_PATH
				+ Constant.asset.SPRITES_PACT, TextureAtlas.class);
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

	public Sprite getSprite() {
		Random random = new Random();
		int size = this.fishes.size();
		return this.fishes.get(random.nextInt(size));
	}

	private Sprite getSprite(String fileName) {
		return this.spriteAtlas.createSprite(fileName);
	}

	public TextureRegion getTextureRegion(String fileName) {
		if (this.isComplete())
			return this.actorAtlas.findRegion(fileName);
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
		this.assetManager.load(Constant.asset.ACTORS_BASE_PATH
				+ Constant.asset.ACTORS_PACK, TextureAtlas.class);
		this.assetManager.load(Constant.asset.SPRITES_BASE_PATH
				+ Constant.asset.SPRITES_PACT, TextureAtlas.class);
	}

	private void initialize() {
		this.initSprites();
	}

	private List<Sprite> fishes = new ArrayList<Sprite>();

	private void initSprites() {
		this.fishes.add(this.getSprite(Constant.asset.FISH_ONE_L));
		this.fishes.add(this.getSprite(Constant.asset.FISH_ONE_R));
		this.fishes.add(this.getSprite(Constant.asset.FISH_TWO_L));
		this.fishes.add(this.getSprite(Constant.asset.FISH_TWO_R));
		this.fishes.add(this.getSprite(Constant.asset.FISH_THREE_L));
		this.fishes.add(this.getSprite(Constant.asset.FISH_THREE_R));
		this.fishes.add(this.getSprite(Constant.asset.FISH_FOUR_L));
		this.fishes.add(this.getSprite(Constant.asset.FISH_FOUR_R));
		this.fishes.add(this.getSprite(Constant.asset.FISH_FIVE_L));
		this.fishes.add(this.getSprite(Constant.asset.FISH_FIVE_R));
		this.fishes.add(this.getSprite(Constant.asset.FISH_SIX_L));
		this.fishes.add(this.getSprite(Constant.asset.FISH_SIX_R));
		this.fishes.add(this.getSprite(Constant.asset.FISH_SEVEN_L));
		this.fishes.add(this.getSprite(Constant.asset.FISH_SEVEN_R));
		this.fishes.add(this.getSprite(Constant.asset.FISH_EIGHT_L));
		this.fishes.add(this.getSprite(Constant.asset.FISH_EIGHT_R));
		this.fishes.add(this.getSprite(Constant.asset.FISH_EIGHT_M));
	}
}
