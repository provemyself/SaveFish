package com.deep.texture;

import com.badlogic.gdx.tools.imagepacker.TexturePacker;
import com.badlogic.gdx.tools.imagepacker.TexturePacker.Settings;


public class CombineTexture {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Settings settings = new Settings();
//        settings.maxWidth = 800;
//        settings.maxHeight = 600;
        settings.alias = false;
        settings.incremental = true;
        TexturePacker.process(settings, "/home/zhujianxin/workspace/GreenGuards/SaveFish-Android/assets/textures", 
        		"/home/zhujianxin/workspace/GreenGuards/SaveFish-Android/assets/textures");
	}
}
