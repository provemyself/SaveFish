package com.savefish.constant;

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
		public static final String SLIDE_SOUND = "glass.wav";
		public static final String EJECT_SOUND = "";
		public static final String CONTACT_SOUND = "";
		public static final String DEAD_SOUND = "";
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

		// 精灵名字
		public static final String FISH_EIGHT_R = "fisheightR";
		public static final String FISH_EIGHT_L = "fisheightL";
		public static final String FISH_SEVEN_R = "fishsevenR";
		public static final String FISH_SEVEN_L = "fishsevenR";
		public static final String FISH_SIX_R = "fishsixR";
		public static final String FISH_SIX_L = "fisheightL";
		public static final String FISH_FIVE_R = "fishfiveR";
		public static final String FISH_FIVE_L = "fishfiveL";
		public static final String FISH_FOUR_R = "fishfourR";
		public static final String FISH_FOUR_L = "fishfourL";
		public static final String FISH_THREE_R = "fishthreeR";
		public static final String FISH_THREE_M = "fishthreeM";
		public static final String FISH_THREE_L = "fishthreeL";
		public static final String FISH_TWO_R = "fishtwoR";
		public static final String FISH_TWO_L = "fishtwoL";
		public static final String FISH_ONE_R = "fishoneR";
		public static final String FISH_ONE_L = "fishoneL";

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
	}
}