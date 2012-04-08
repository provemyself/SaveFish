package com.savefish.logical;

/********************************
 * Description: 该类是一个提供碰撞接触
 *              的数据过滤类
 * Author     : 王志伟
 * Date       : 2012/03/09
 *******************************/

import com.badlogic.gdx.physics.box2d.Filter;

public class CollisionFilterData extends Filter {

	/**
	 * @description 设置过滤类数据
	 * @param fd 过滤类实例
	 */
	public void set(Filter fd){
		this.categoryBits = fd.categoryBits;
		this.maskBits = fd.maskBits;
		this.groupIndex = fd.groupIndex;
	}
	
	/**
	 * @description 设置过滤类数据
	 * @param categoryBits 碰撞种类,必须是2的倍数
	 * @param maskBits 碰撞种类
	 * @param groupIndex 分组下标,最优先碰撞检测
	 */
	public void set(short categoryBits, short maskBits, short groupIndex){
		this.categoryBits = categoryBits;
		this.maskBits = maskBits;
		this.groupIndex = groupIndex;
	}
}
