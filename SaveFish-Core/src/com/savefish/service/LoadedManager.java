package com.savefish.service;

/********************************
 * Description: 该类仅包含一个静态成员
 *              保存已经初始化管理器
 * Author     : 王志伟
 * Date       : 2012/03/08
 *******************************/

import java.util.LinkedList;
import java.util.List;

public class LoadedManager {
	public static List<Managable> managers = new LinkedList<Managable>();
}
