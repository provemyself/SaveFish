package com.savefish.physics.resolve;

/********************************
 * Description: 该类定义了刚体夹具的属
 *              性，便于反/序列化
 * Author     : 王志伟
 * Date       : 2012/03/12
 *******************************/

public class GreenFixture {
	public GreenCircleShape circle;
	public GreenChainShape chain;
	public GreenEdgeShape edge;
	public GreenLoopShape loop;
	public GreenPolygonShape polygon;
	public GreenHexFloat density;// 密度
	public GreenHexFloat restitution;// 恢复力
	public GreenHexFloat friction;// 摩擦力
	public int filter_categoryBits = 0x01;
	public int filter_maskBits = 0xffff;
	public int filter_groupIndex = 0;
	public String name;
	public boolean sensor;
}
