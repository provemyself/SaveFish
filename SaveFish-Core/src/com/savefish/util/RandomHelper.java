package com.savefish.util;

import java.util.Random;

public class RandomHelper {

	private Random random = null;

	public static RandomHelper createInstance() {
		return new RandomHelper();
	}

	private RandomHelper() {
		this.random = new Random();
	}

	public int nextInt(int max) {
		return this.random.nextInt(max);
	}
}
