package com.savefish.service;

import com.savefish.assets.Assets;
import com.savefish.constant.Constant;

public class FailFishSound extends AbstractSound {
	private static FailFishSound failFishSound = null;

	public static FailFishSound getInstance() {
		if (null == failFishSound)
			failFishSound = new FailFishSound();
		return failFishSound;
	}

	private FailFishSound() {
		sound = Assets.getInstance().getSound(Constant.asset.FAIL_FISH_SOUND);
	}

	@Override
	public void dispose() {
		super.dispose();
		failFishSound = null;
	}
}
