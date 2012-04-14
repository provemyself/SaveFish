package com.savefish.service;

import com.savefish.assets.Assets;
import com.savefish.constant.Constant;

public class SlideSound extends AbstractSound {

	private static SlideSound slideSound = null;

	public static SlideSound getInstance() {
		if (null == slideSound)
			slideSound = new SlideSound();
		return slideSound;
	}

	private SlideSound() {
		sound = Assets.getInstance().getSound(Constant.asset.SLIDE_SOUND);
	}

	@Override
	public void dispose() {
		super.dispose();
		slideSound = null;
	}
}
