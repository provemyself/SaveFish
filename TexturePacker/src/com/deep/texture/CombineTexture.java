package com.deep.texture;

import com.badlogic.gdx.tools.imagepacker.TexturePacker;
import com.badlogic.gdx.tools.imagepacker.TexturePacker.Settings;


public class CombineTexture {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Settings settings = new Settings();
        settings.alias = false;
        settings.incremental = true;
        TexturePacker.process(settings, "/home/zhujianxin/input", 
        		"/home/zhujianxin/output");
	}
}
