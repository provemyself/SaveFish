package com.savefish.service;

import com.savefish.assets.Assets;
import com.savefish.constant.Constant;

public class FailTimeSound extends AbstractSound {
	private static FailTimeSound failTimeSound = null;

	public static FailTimeSound getInstance() {
		if (null == failTimeSound)
			failTimeSound = new FailTimeSound();
		return failTimeSound;
	}

	private FailTimeSound() {
		sound = Assets.getInstance().getSound(Constant.asset.FAIL_TIME_SOUND);
	}

	@Override
	public void dispose() {
		super.dispose();
		failTimeSound = null;
	}
}
