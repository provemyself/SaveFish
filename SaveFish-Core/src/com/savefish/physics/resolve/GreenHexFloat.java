package com.savefish.physics.resolve;

/********************************
 * Description: 该类定义了十进制浮点数，
 *              初始化使用通过解析json
 *              得到的十进制浮点数
 * Author     : 王志伟
 * Date       : 2012/03/12
 *******************************/

public class GreenHexFloat {
	private float value;

	public GreenHexFloat(float floatFromHex) {
		this.value = floatFromHex;
	}

	public GreenHexFloat() {
		this.value = 0;
	}

	public Float toFloat() {
		return this.value;
	}
}
