package com.savefish.assets;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.savefish.constant.Constant;
import com.savefish.util.GreenLogger;

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
		this.initialize();
	}

	private TextureAtlas getActorAtlas() {
		TextureAtlas atlas = assetManager.get(Constant.asset.ACTORS_BASE_PATH
				+ Constant.asset.ACTORS_PACK, TextureAtlas.class);
		if (null == atlas) {
			atlas = new TextureAtlas();
			GreenLogger.getInstance().logp(Level.SEVERE,
					Assets.class.getName(), "getActorAtlas",
					"Failed to load ActorAtlas!");
		}
		return atlas;
	}

	private TextureAtlas getSpriteAtlas() {
		TextureAtlas atlas = assetManager.get(Constant.asset.SPRITES_BASE_PATH
				+ Constant.asset.SPRITES_PACT, TextureAtlas.class);
		if (null == atlas) {
			atlas = new TextureAtlas();
			GreenLogger.getInstance().logp(Level.SEVERE,
					Assets.class.getName(), "getSpriteAtlas",
					"Failed to load SpriteAtlas!");
		}
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

	public Sprite getNatureFishSprite() {
		Random random = new Random();
		int size = this.fishes.size();
		Sprite sprite = this.fishes.get(random.nextInt(size));

		if (null == sprite) {
			sprite = new Sprite();
			GreenLogger.getInstance().logp(Level.SEVERE,
					Assets.class.getName(), "getSprite",
					"Failed to load sprite");
		}
		return sprite;
	}

	public Sprite getArtificialFish(String fileName) {
		return getSprite(fileName);
	}

	public Sprite getSprite(String fileName) {
		Sprite sprite = this.spriteAtlas.createSprite(fileName);
		if (null == sprite) {
			sprite = new Sprite();
			GreenLogger.getInstance().logp(Level.SEVERE,
					Assets.class.getName(), "getSprite",
					"Failed to create sprite with the " + fileName + " !");
		}
		return sprite;
	}

	public TextureRegion getTextureRegion(String fileName) {
		return this.actorAtlas.findRegion(fileName);
	}

	public BitmapFont getBitmapFont(String fileName) {
		return assetManager.get(Constant.asset.FONTS_BASE_PATH + fileName,
				BitmapFont.class);
	}

	public Music getMusic(String fileName) {
		return assetManager.get(Constant.asset.MUSICS_BASE_PATH + fileName,
				Music.class);
	}

	public Pixmap getPixmap(String fileName) {
		return assetManager.get(Constant.asset.PIXMAPS_BASE_PATH + fileName,
				Pixmap.class);
	}

	public Sound getSound(String fileName) {
		return assetManager.get(Constant.asset.SOUNDS_BASE_PATH + fileName,
				Sound.class);
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
				+ Constant.asset.SLIDE_SOUND, Sound.class);
	}

	private void loadTextureAtlas() {
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
		this.fishes.add(this.getSprite(Constant.asset.FISH_THREE_M));
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
	}
}
