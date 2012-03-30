package com.savefish.physics.resolve;

/********************************
 * Description: 该类定义了刚体的属性，
 *              便于反/序列化
 * Author     : 王志伟
 * Date       : 2012/03/12
 *******************************/

import java.util.ArrayList;

public class GreenBody {
	public GreenHexFloat angle;// 角度
	public GreenHexFloat angularVelocity;// 角速度
	public GreenVector2 linearVelocity;// 线性速度

	public GreenHexFloat linearDamping = new GreenHexFloat(0f);
	public GreenHexFloat angularDamping = new GreenHexFloat(0f);
	public GreenHexFloat gravityScale = new GreenHexFloat(1f);

	public boolean allowSleep = true;
	public boolean awake = false;
	public boolean fixedRotation = false;
	public boolean bullet = false;
	public boolean active = true;
	public ArrayList<GreenFixture> fixture;// 夹具,一个Body可以有很多夹具F

	public GreenHexFloat massData_I;// 对应json文件中的massData-I， 数据类型待定
	public GreenVector2 massData_center;// massData-center 质心
	public GreenHexFloat massData_mass;// 对应json文件中的massData-mass, 数据类型待定
	public String name;// body的名字
	public GreenVector2 position;// body的位置
	public int type;// 刚体在物理世界的运动类型
}
