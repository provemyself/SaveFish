package com.savefish.service;

import com.savefish.assets.Assets;
import com.savefish.constant.Constant;

public class EatSound extends AbstractSound {

	private static EatSound deadSound = null;

	public static EatSound getInstance() {
		if (null == deadSound)
			deadSound = new EatSound();
		return deadSound;
	}

	private EatSound() {
		sound = Assets.getInstance().getSound(Constant.asset.EAT_SOUND);
	}

	@Override
	public void dispose() {
		super.dispose();
		deadSound = null;
	}
}
