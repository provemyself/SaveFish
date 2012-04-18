package com.savefish.constant;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/********************************
 * Description: 该类对项目中的常量进行 
 * *************分类管理
 *  Author : 王志伟 
 *  Date : 2012/03/08
 *******************************/

public final class Constant {

	public static final class physics {
		public static final int RATE = 10;// 屏幕与现实世界的比例1：10（1像素等于10米）
		public static final float TIME_STEP = 1.0f / 60.0f;// 模拟现实世界的频率
		public static final int ITERATION = 10;// 迭代次数
		public static final int CAMERA_VIEW_WIDTH = screen.SCREEN_WIDTH / RATE;// 相机视点宽度
		public static final int CAMERA_VIEW_HEIGHT = screen.SCREEN_HEIGHT
				/ RATE;// 相机视点高度
		public static final int CAMERA_X = CAMERA_VIEW_WIDTH / 2;
		public static final int CAMERA_Y = CAMERA_VIEW_HEIGHT / 2;
		public static final int CAMERA_Z = 10;
	}

	public static final class screen {
		public static final int SCREEN_WIDTH = 480;// 屏幕宽度
		public static final int SCREEN_HEIGHT = 320;// 屏幕高度
	}

	public static final class game {
		public static final String GAME_NAME = "GreenGuards";// 游戏名称

		public static final int GAME_DELAY = 6;// 60秒

		public static final int PREVENT_FIRST_LEVEL = 1;
		public static final int PREVENT_SECOND_LEVEL = 2;
		public static final int PREVENT_THIRD_LEVEL = 3;
		public static final int PREVENT_FOURTH_LEVEL = 4;
		public static final int PREVENT_FIFTH_LEVEL = 5;
		public static final int PREVENT_SIXTH_LEVEL = 6;

		public static final int CLEAR_FIRST_LEVEL = 1;
		public static final int CLEAR_SECOND_LEVEL = 2;
		public static final int CLEAR_THIRD_LEVEL = 3;
		public static final int CLEAR_FOURTH_LEVEL = 4;
		public static final int CLEAR_FIFTH_LEVEL = 5;
		public static final int CLEAR_SIXTH_LEVEL = 6;
	}

	public static final class logger {
		public static final String LOGGER_NAME = "com.savefish";
	}

	public static final class basepath {
		// 文件基路径
		public static final String TEXTURES_BASE_PATH = "textures/";
		public static final String SOUNDS_BASE_PATH = "sounds/";
		public static final String PARTICLES_BASE_PATH = "particles/";
		public static final String MUSICS_BASE_PATH = "musics/";
		public static final String MAPS_BASE_PATH = "maps/";
		public static final String FONTS_BASE_PATH = "fonts/";
		public static final String PIXMAPS_BASE_PATH = "pixmaps/";
		public static final String ACTORS_BASE_PATH = "actors/";
		public static final String SPRITES_BASE_PATH = "sprites/";
	}

	public static final class fish {
		// 精灵名字 以“L”表示向左游动，以“R”开头表示向右游动
		public static final String LFISH_NINE_ONE = "Lfishnineone";
		public static final String LFISH_NINE_TWO = "Lfishninetwo";
		public static final String LFISH_EIGHT_TWO = "Lfisheighttwo";
		public static final String LFISH_EIGHT_ONE = "Lfisheightone";
		public static final String LFISH_SEVEN_ONE = "Lfishsevenone";
		public static final String LFISH_SEVEN_TWO = "Lfishseventwo";
		public static final String LFISH_SIX_TWO = "Lfishsixtwo";
		public static final String LFISH_SIX_ONE = "Lfishsixone";
		public static final String LFISH_FIVE_TWO = "Lfishfivetwo";
		public static final String LFISH_FIVE_ONE = "Lfishfiveone";
		public static final String LFISH_FOUR_TWO = "Lfishfourtwo";
		public static final String LFISH_FOUR_ONE = "Lfishfourone";
		public static final String RFISH_THREE_TWO = "Rfishthreetwo";
		public static final String RFISH_THREE_ONE = "Rfishthreeone";
		public static final String LFISH_TWO_TWO = "Lfishtwotwo";
		public static final String LFISH_TWO_ONE = "Lfishtwoone";
		public static final String RFISH_ONE_TWO = "Rfishonetwo";
		public static final String RFISH_ONE_ONE = "Rfishoneone";

		// 人工鱼
		public static final String ARTIFICIAL_ONE = "artificialone";
		public static final String ARTIFICIAL_TWO = "artificialtwo";
		public static final String ARTIFICIAL_THREE = "artificialthree";
		public static final String ARTIFICIAL_FOUR = "artificialfour";
		public static final String ARTIFICIAL_FIVE = "artificialfive";
		public static final String ARTIFICIAL_SIX = "artificialsix";

	}

	public static final class rubbish {
		public static final String PESTICIDE_TWO = "pesticidetwo";
		public static final String PESTICIDE_ONE = "pesticideone";

		// 垃圾种类
		public static final String RUBBISH_BAG = "bag";// 垃圾袋
		public static final String THERMOGRAPH = "thermograph";// 温度计
		public static final String RADIOACTIVE_MATERIAL = "rm";// 放射性物质
		public static final String PESTICIDE = "pesticide";// 敌敌畏
		public static final String ELECTRIC_BATTERY = "eb";// 电池
	}

	public static final class map {
		// 地图:第一大关
		public static final String PREVENT_FIRST = "map_prevent_first.json";
		public static final String PREVENT_SECOND = "map_prevent_second.json";
		public static final String PREVENT_THIRD = "map_prevent_third.json";
		public static final String PREVENT_FOURTH = "map_prevent_fourth.json";
		public static final String PREVETN_FIFTH = "map_prevent_fifth.json";
		public static final String PREVENT_SIXTH = "map_prevent_sixth.json";

		// 地图:第二关
		public static final String CLEAR_FIRST = "map_clear_first.json";
		public static final String CLEAR_SECOND = "map_clear_second.json";
		public static final String CLEAR_THIRD = "map_clear_third.json";
		public static final String CLEAR_FOURTH = "map_clear_fourth.json";
		public static final String CLEAR_FIFTH = "map_clear_fifth.json";
		public static final String CLEAR_SIXTH = "map_clear_sixth.json";
	}

	public static final class particle {
		// 粒子文件
		public static final String PARTICLE_TEXT = "particle.p";
		public static final String PARTICLE_ONE = "one.p";
		public static final String PARTICLE_TWO = "two.p";
		public static final String PARTICLE_THREE = "three.p";
		public static final String PARTICLE_FOUR = "four.p";
		public static final String PARTICLE_SIX = "six.p";
		public static final String PARTICLE_NINE = "nine.p";
	}

	public static final class sound {
		// 音效
		public static final String SLIDE_SOUND = "glass.mp3";
		public static final String EJECT_SOUND = "";
		public static final String CONTACT_SOUND = "";
		public static final String EAT_SOUND = "eat.wav";
		public static final String WIN_SOUND = "";
		public static final String FAIL_FISH_SOUND = "";
		public static final String FAIL_TIME_SOUND = "";
	}

	public static final class music {
		// 背景音乐
		public static final String MUSIC = "annie.mp3";
	}

	public static final class pack {
		// pack
		public static final String ACTORS_PACK = "actors";
		public static final String SPRITES_PACT = "sprites";
	}

	public static final class asset {
		// 游戏菜单的背景图片
		public static final String GAME_SCRENE = "gamescene";
		public static final String MAIN_MENU = "mainmenu";
		public static final String PREVIOUS = "previous";
		public static final String STOP = "stop";
		public static final String PAUSE = "pause";
		public static final String NEXT = "next";

		// 游戏场景的背景图片
		public static final String BACKGROUND_ONE = "gamescene";
		public static final String BACKGROUND_TWO = "background_two";
		public static final String BACKGOUND_THREE = "background_three";
		public static final String BACKGROUND_FOUR = "background_four";
		public static final String BACKGROUND_FIVE = "background_five";
		public static final String BACKGROUND_SIX = "background_six";

		// 背景音效开关
		public static boolean isBgMusicOn = true;
		public static final boolean isSoundOn = true;

		// button actor
		public static final TextureAtlas atlas = new TextureAtlas(
				"textures/pack");
		public static final TextureRegion bgChoiceTexture = atlas
				.findRegion("bgChoice");
		public static final TextureRegion bgMainTexture = atlas
				.findRegion("bgMain");

		public static final TextureRegion[] aboutActorTexture = {
				atlas.findRegion("about"), atlas.findRegion("about") };
		public static final TextureRegion[] replayActorTexture = {
				atlas.findRegion("replay"), atlas.findRegion("replay") };
		public static final TextureRegion[] shareActorTexture = {
				atlas.findRegion("share"), atlas.findRegion("share") };
		public static final TextureRegion[] nextActorTexture = {
				atlas.findRegion("next"), atlas.findRegion("next") };
		public static final TextureRegion[] helpActorTexture = {
				atlas.findRegion("help"), atlas.findRegion("help") };
		public static final TextureRegion[] quitActorTexture = {
				atlas.findRegion("menu"), atlas.findRegion("menu") };
		public static final TextureRegion[] startActorTexture = {
				atlas.findRegion("play"), atlas.findRegion("play2") };
		public static final TextureRegion[] optionActorTexture = {
				atlas.findRegion("option"), atlas.findRegion("option") };
		public static final TextureRegion[] exitActorTexture = {
				atlas.findRegion("exit"), atlas.findRegion("exit") };
		public static final TextureRegion[] choice1ActorTexture = {
				atlas.findRegion("choice1"), atlas.findRegion("choice2"),
				atlas.findRegion("choice3"), atlas.findRegion("choice4") };
		public static final TextureRegion[] choice2ActorTexture = {
				atlas.findRegion("choice5"), atlas.findRegion("choice6"),
				atlas.findRegion("choice7"), atlas.findRegion("choice8") };
		public static final TextureRegion[] highscoreActorTexture = {
				atlas.findRegion("highScore"), atlas.findRegion("highScore") };
		public static final TextureRegion[] bgMusicActorTexture = {
				atlas.findRegion("bgMusicOn"), atlas.findRegion("bgMusicOff") };
		public static final TextureRegion[] soundActorTexture = {
				atlas.findRegion("soundOff"), atlas.findRegion("soundOn") };

		public static final TextureRegion[] num1ActorTexture = {
				atlas.findRegion("1"), atlas.findRegion("11") };
		public static final TextureRegion[] num2ActorTexture = {
				atlas.findRegion("2"), atlas.findRegion("22") };
		public static final TextureRegion[] num3ActorTexture = {
				atlas.findRegion("3"), atlas.findRegion("33") };
		public static final TextureRegion[] num4ActorTexture = {
				atlas.findRegion("4"), atlas.findRegion("44") };
		public static final TextureRegion[] num5ActorTexture = {
				atlas.findRegion("5"), atlas.findRegion("55") };
		public static final TextureRegion[] num6ActorTexture = {
				atlas.findRegion("6"), atlas.findRegion("66") };

		public static final TextureRegion fish1Texture[] = {
				atlas.findRegion("fish1"), atlas.findRegion("fish2") };
		public static final TextureRegion fish2Texture[] = {
				atlas.findRegion("fish3"), atlas.findRegion("fish4") };
		public static final TextureRegion fish3Texture[] = {
				atlas.findRegion("fish5"), atlas.findRegion("fish6") };
	}
}