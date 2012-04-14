package com.savefish.service;

import com.savefish.assets.Assets;
import com.savefish.constant.Constant;

public class WinSound extends AbstractSound {
	private static WinSound winSound = null;

	public static WinSound getInstance() {
		if (null == winSound)
			winSound = new WinSound();
		return winSound;
	}

	private WinSound() {
		sound = Assets.getInstance().getSound(Constant.asset.WIN_SOUND);
	}

	@Override
	public void dispose() {
		super.dispose();
		winSound = null;
	}
}
