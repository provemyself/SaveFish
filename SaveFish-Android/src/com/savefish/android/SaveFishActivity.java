package com.savefish.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.savefish.service.ApplicationManager;

public class SaveFishActivity extends AndroidApplication {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initialize(new ApplicationManager(), false);
	}
}