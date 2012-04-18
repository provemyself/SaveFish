package com.savefish.score;

import java.util.HashMap;

public class Score {
	private static HashMap<String, Integer> dict = new HashMap<String, Integer>();

	static {
		dict.put("rubbishbag", 200);
		dict.put("hydrothion", 300);
		dict.put("sulfurdioxide", 400);
		dict.put("ddvp", 600);
		dict.put("snackbox", 100);
	}

	/**
	 * @description 当吃掉垃圾时，根据垃圾种类获取需要加分数
	 * @param rubbishName
	 * @return
	 */
	public static Integer getIncreaseScore(String rubbishName) {
		if ((null != rubbishName))
			return dict.get(rubbishName);
		else
			return null;
	}

	/**
	 * @description 获取当垃圾落到水底需要扣除的分数
	 * @return
	 */
	public static Integer getDecreaseScore() {
		return -100;
	}
}
