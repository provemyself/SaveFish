package com.savefish.android;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.savefish.screens.LoaderScreen;

import android.os.Bundle;

public class SaveFishActivity extends AndroidApplication {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initialize(new LoaderScreen(), false);
	}
}