package com.savefish.constant;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/********************************
 * Description: 该类对项目中的常量进行 
 * *************分类管理 
 * Author : 王志伟 
 * Date : 2012/03/08
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
		public static final int SCREEN_HALF_WIDTH = 240;// 半屏幕宽
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

	public static final class asset {
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

		// 背景音乐
		public static final String MUSIC = "annie.mp3";

		// 音效
		public static final String SLIDE_SOUND = "glass.mp3";
		public static final String EJECT_SOUND = "";
		public static final String CONTACT_SOUND = "";
		public static final String EAT_SOUND = "eat.wav";
		public static final String WIN_SOUND = "";
		public static final String FAIL_FISH_SOUND = "";
		public static final String FAIL_TIME_SOUND = "";

		// 纹理文件
		public static final String LOADING = "loading.png";

		// 游戏菜单的背景图片
		public static final String GAME_SCRENE = "gamescene";
		public static final String MAIN_MENU = "mainmenu";
		public static final String PREVIOUS = "previous";
		public static final String STOP = "stop";
		public static final String PAUSE = "pause";
		public static final String NEXT = "next";

		// 精灵名字 以“L”表示向左游动，以“R”开头表示向右游动
		public static final String LFISH_NINE_ONE = "Lfishnineone";
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
		public static final String RFISH_THREE_THREE = "Rfishthreesthree";
		public static final String RFISH_THREE_TWO = "Rfishthreetwo";
		public static final String RFISH_THREE_ONE = "Rfishthreeone";
		public static final String LFISH_TWO_TWO = "Lfishtwotwo";
		public static final String LFISH_TWO_ONE = "Lfishtwoone";
		public static final String RFISH_ONE_TWO = "Rfishonetwo";
		public static final String RFISH_ONE_ONE = "Rfishoneone";

		public static final String PESTICIDE_TWO = "pesticidetwo";
		public static final String PESTICIDE_ONE = "pesticideone";

		// 游戏场景的背景图片
		public static final String BACKGROUND_ONE = "mainmenu";
		public static final String BACKGROUND_TWO = "background_two";
		public static final String BACKGOUND_THREE = "background_three";
		public static final String BACKGROUND_FOUR = "background_four";
		public static final String BACKGROUND_FIVE = "background_five";
		public static final String BACKGROUND_SIX = "background_six";

		// 地图:第一大关
		public static final String PREVENT_FIRST = "prevent_first.json";
		public static final String PREVENT_SECOND = "prevent_second.json";
		public static final String PREVENT_THIRD = "prevent_third.json";
		public static final String PREVENT_FOURTH = "prevent_fourth.json";
		public static final String PREVETN_FIFTH = "prevent_fifth.json";
		public static final String PREVENT_SIXTH = "prevent_sixth.json";

		// 地图:第二关
		public static final String CLEAR_FIRST = "clear_first.json";
		public static final String CLEAR_SECOND = "clear_second.json";
		public static final String CLEAR_THIRD = "clear_third.json";
		public static final String CLEAR_FOURTH = "clear_fourth.json";
		public static final String CLEAR_FIFTH = "clear_fifth.json";
		public static final String CLEAR_SIXTH = "clear_sixth.json";

		// 粒子文件
		public static final String PARTICLE_ONE_TEXT = "particle.p";

		// pack
		public static final String ACTORS_PACK = "actors";
		public static final String SPRITES_PACT = "sprites";

		// button actor
		public static final TextureAtlas atlas = new TextureAtlas(
				"textures/pack");
		public static final TextureRegion bgMChoiceTexture = atlas
				.findRegion("bgMChoice");
		public static final TextureRegion bgChoiceTexture = atlas
				.findRegion("bgChoice");
		public static final TextureRegion bgMenuTexture = atlas
				.findRegion("bgMenu");
		public static final TextureRegion bghelpTexture = atlas
				.findRegion("bgHelp");
		public static final TextureRegion bgOptionTexture = atlas
				.findRegion("bgOption");
		public static final TextureRegion bgHighscoreTexture = atlas
				.findRegion("bgHighscore");

		public static final TextureRegion aboutActorTexture = atlas
				.findRegion("about");
		public static final TextureRegion menuActorTexture = atlas
				.findRegion("menu");
		public static final TextureRegion startActorTexture = atlas
				.findRegion("start");
		public static final TextureRegion optionActorTexture = atlas
				.findRegion("option");
		public static final TextureRegion exitActorTexture = atlas
				.findRegion("exit");
		public static final TextureRegion choice1ActorTexture = atlas
				.findRegion("choice1");
		public static final TextureRegion choice2ActorTexture = atlas
				.findRegion("choice2");
		public static final TextureRegion highscoreActorTexture = atlas
				.findRegion("highscore");
		public static final TextureRegion musicActorTexture = atlas
				.findRegion("music");
		public static final TextureRegion shareActorTexture = atlas
				.findRegion("share");

		public static final TextureRegion num1ActorTexture = atlas
				.findRegion("num1");
		public static final TextureRegion num2ActorTexture = atlas
				.findRegion("num2");
		public static final TextureRegion num3ActorTexture = atlas
				.findRegion("num3");
		public static final TextureRegion num4ActorTexture = atlas
				.findRegion("num4");
		public static final TextureRegion num5ActorTexture = atlas
				.findRegion("num5");
		public static final TextureRegion num6ActorTexture = atlas
				.findRegion("num6");

		public static final TextureRegion fish1Texture[] = {
				atlas.findRegion("fish1"), atlas.findRegion("fish2") };
		public static final TextureRegion fish2Texture[] = {
				atlas.findRegion("fish3"), atlas.findRegion("fish4") };
		public static final TextureRegion fish3Texture[] = {
				atlas.findRegion("fish5"), atlas.findRegion("fish6") };
	}
}