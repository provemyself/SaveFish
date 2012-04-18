package com.savefish.rule;

import java.util.HashMap;

import com.savefish.constant.Constant;

public class ScoreDictionary {
	private static HashMap<String, Integer> dict = new HashMap<String, Integer>();

	static {
		dict.put(Constant.rubbish.RUBBISH_BAG, 100);
		dict.put(Constant.rubbish.THERMOGRAPH, 400);
		dict.put(Constant.rubbish.RADIOACTIVE_MATERIAL, 600);
		dict.put(Constant.rubbish.ELECTRIC_BATTERY, 200);
		dict.put(Constant.rubbish.PESTICIDE, 300);
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
