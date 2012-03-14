package com.savefish.constant;

/********************************
 * Description: 该类对项目中的常量进行
 *              分类管理
 * Author     : 王志伟
 * Date       : 2012/03/08
 *******************************/

public final class Constant {

	public static final class physics {
		public static final int RATE = 10;// 屏幕与现实世界的比例1：10（1像素等于10米）
		public static final float TIME_STEP = 2.0f / 60.0f;// 模拟现实世界的频率
		public static final int ITERATION = 10;// 迭代次数
	}

	public static final class screen {
		public static final int SCREEN_WIDTH = 480;// 屏幕宽度
		public static final int SCREEN_HEIGHT = 320;// 屏幕高度
		public static final int SCREEN_HALF_WIDTH = 240;// 半屏幕宽
	}
	
	public static final class game{
		public static final String GAME_NAME = "GreenGuards";//游戏名称
	}
}