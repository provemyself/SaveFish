package com.savefish.rule;

import java.util.logging.Level;

import com.savefish.util.GreenLogger;

public class GameLevel {
	private int big;
	private int small;

	public static GameLevel createInstance() {
		return new GameLevel();
	}

	private GameLevel() {
		this.setBig(1);
		this.setSmall(1);
	}

	public static GameLevel createInstance(int big, int small) {
		return new GameLevel(big, small);
	}

	private GameLevel(int big, int small) {
		this.setBig(big);
		this.setSmall(small);
	}

	public int getBig() {
		return big;
	}

	public void setBig(int big) {
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

	public void setSmall(int small) {
		if ((1 <= big) && (big <= 6)) {
			this.small = small;
		} else {
			GreenLogger.getInstance().logp(Level.WARNING,
					GameLevel.class.getName(), "setSmall", "参数错误， 将小关卡设为1");
			this.small = 1;
		}
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
		return result;
	}

}
