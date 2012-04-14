package com.savefish.service;

import com.savefish.assets.Assets;
import com.savefish.constant.Constant;

public class ContactSound extends AbstractSound {

	private static ContactSound contactSound = null;

	public static ContactSound getInstance() {
		if (null == contactSound)
			contactSound = new ContactSound();
		return contactSound;
	}

	private ContactSound() {
		sound = Assets.getInstance().getSound(Constant.asset.CONTACT_SOUND);
	}

	@Override
	public void dispose() {
		super.dispose();
		contactSound = null;
	}

}
