package com.savefish.physics.resolve;

/********************************
 * Description: 该类定义了物理关节的
 *              属性，便于反/序列化
 * Author     : 王志伟
 * Date       : 2012/03/12
 *******************************/

public class GreenJoint {
	public GreenVector2 anchorA;
	public GreenVector2 anchorB;
	public int bodyA;
	public int bodyB;
	public String type;
	public String name;
	public boolean collideConnected = false;

	// distance 距离关节
	public GreenHexFloat dampingRatio;// 阻尼
	public GreenHexFloat frequency;// 频率
	public GreenHexFloat length;

	// revolute 旋转关节
	public boolean enableLimit;// 是否启动关节限制
	public boolean enableMotor;// 是否启动马达
	public GreenHexFloat jointSpeed;// 当前关节的角速度 单位：弧度/秒
	public GreenHexFloat lowerLimit; // 旋转关节角的最小角度
	public GreenHexFloat maxMotorTorque;// 马达的预期最大扭矩
	public GreenHexFloat motorSpeed;// 马达最终扭矩
	public GreenHexFloat refAngle;// 暂时未知是什么意思
	public GreenHexFloat upperLimit;// 旋转关节角的最大角度

	// wheel 车轮关节
	public GreenVector2 localAxisA;
	public GreenHexFloat springDampingRatio;// 弹簧阻尼
	public GreenHexFloat springFrequency;// 弹簧频率F

	// prismatic 棱柱关节
	public GreenVector2 localAxis;//
	public GreenVector2 localAxis1;
	public GreenHexFloat maxMotorForce;

	// rope 绳子关节
	public GreenHexFloat maxLength;

	// gear 齿轮关节
	public GreenHexFloat ratio;
	public int joint1;
	public int joint2;

	// friction 摩擦关节
	public GreenHexFloat maxForce;
	public GreenHexFloat maxTorque;

	// mouse 鼠标关节
	public GreenVector2 target;

	// pulley 滑轮关节
	public GreenVector2 groundAnchorA;
	public GreenVector2 groundAnchorB;
	public GreenHexFloat lengthA;
	public GreenHexFloat lengthB;
}
