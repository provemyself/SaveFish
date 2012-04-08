package com.savefish.task;

/********************************
 * Description: 该接口是一个任务侦听器
 * 
 * Author : 	王志伟 
 * Date : 		2012/04/01
 *******************************/

public interface Task<E, T> {
	public E onDestroyTask(T arg);
}
