package com.savefish.util;

import java.util.Random;

public class RandomHelper {
	private static RandomHelper randomHelper = null;

	private Random random = null;

	public static RandomHelper getInstance() {
		if (null == randomHelper)
			randomHelper = new RandomHelper();
		return randomHelper;
	}

	private RandomHelper() {
		this.random = new Random();
	}

	public int nextInt(int max) {
		return this.random.nextInt(max);
	}
}
