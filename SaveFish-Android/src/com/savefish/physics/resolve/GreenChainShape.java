package com.savefish.physics.resolve;

/********************************
 * Description: 该类定义了ChainShape
 *              的属性，便于反/序列化
 * Author     : 王志伟
 * Date       : 2012/03/12
 *******************************/

public class GreenChainShape {
	public boolean hasPrevVertex = false;
	public boolean hasNextVertex = false;
	public GreenVector2 prevVertex;
	public GreenVector2 nextVertex;
	public GreenVeritices vertices;
}
