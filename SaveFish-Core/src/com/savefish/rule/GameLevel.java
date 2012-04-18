package com.savefish.rule;

import java.util.logging.Level;

import com.savefish.util.GreenLogger;

public class GameLevel {
	private int big;
	private int small;
	private int count;// 每一关卡垃圾的数量

	public static GameLevel createInstance() {
		return new GameLevel();
	}

	private GameLevel() {
		this.setBig(1);
		this.setSmall(1);
		this.setCount();
	}

	public static GameLevel createInstance(int big, int small) {
		return new GameLevel(big, small);
	}

	private GameLevel(int big, int small) {
		this.setBig(big);
		this.setSmall(small);
		this.setCount();
	}

	public int getBig() {
		return big;
	}

	private void setBig(int big) {
		if ((1 <= big) && (big <= 2)) {
			this.big = big;
		} else {
			GreenLogger.getInstance().logp(Level.WARNING,
					GameLevel.class.getName(), "setBig", "参数错误， 将大关卡设为1");
			this.big = 1;
		}
	}

	public int getSmall() {
		return small;
	}

	private void setSmall(int small) {
		if (((small - 1) / 6) % 2 == 0)
			this.big = 1;
		else
			this.big = 2;

		if (small % 6 == 0)
			this.small = 6;
		else
			this.small = small % 6;
	}

	public int getCount() {
		return this.count;
	}

	private void setCount() {
		this.count = 600 + (small - 1) * 200;
	}

	@Override
	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}

		GameLevel level = (GameLevel) obj;
		return (level.big == this.big) && (level.small == this.small);
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 37 * result + big;
		result = 37 * result + small;
		result = 37 * result + count;
		return result;
	}

}
