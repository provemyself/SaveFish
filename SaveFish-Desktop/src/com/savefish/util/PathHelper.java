package com.savefish.util;

/********************************
 * Description: 该类为工具类，根据文件
 *              名，获取相应路径
 * Author     : 王志伟
 * Date       : 2012/03/14
 *******************************/

import java.io.File;

public class PathHelper {

	public static String getFontPath(String fileName) {
		String fontPath = "fonts" + File.separator + fileName;
		return fontPath;
	}

	/**
	 * @description 根据文件名获取地图文件路径
	 * @param fileName
	 *            地图文件名
	 * @return 地图文件路径
	 */
	public static String getMapPath(String fileName) {
		String mapPath = "maps" + File.separator + fileName;
		return mapPath;
	}

	/**
	 * @description 根据文件名获取背景音乐文件路径
	 * @param fileName
	 *            背景音乐文件名
	 * @return 背景音乐文件路径
	 */
	public static String getMusicPath(String fileName) {
		String musicPath = "music" + File.separator + fileName;
		return musicPath;
	}

	public static String getParticleFilePath(String fileName) {
		String particleFilePath = "particles" + File.separator + fileName;
		return particleFilePath;
	}

	public static String getParticleImagePath() {
		String particleImagePath = "particles" + File.separator + "images";
		return particleImagePath;
	}

	/**
	 * @description 根据文件名获取音效文件路径
	 * @param fileName
	 *            文件名
	 * @return 音效文件路径
	 */
	public static String getSoundPath(String fileName) {
		String soundPath = "sounds" + File.separator + fileName;
		return soundPath;
	}

	/**
	 * @description 根据文件名获取纹理文件路径
	 * @param fileName
	 *            纹理文件名
	 * @return 纹理文件路径
	 */
	public static String getTexturePath(String fileName) {
		String texturePath = "images" + File.separator + fileName;
		return texturePath;
	}
}
