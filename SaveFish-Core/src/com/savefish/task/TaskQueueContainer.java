package com.savefish.task;

import java.util.LinkedList;

public class TaskQueueContainer<T extends Task<?, ?>> implements
		TaskContainer<T> {

	private LinkedList<T> tasks = null;

	public TaskQueueContainer() {
		this.tasks = new LinkedList<T>();
	}

	@Override
	public void push(T task) {
		this.tasks.add(task);
	}

	@Override
	public void remove(T task) {
		this.tasks.remove(task);
	}

	@Override
	public T pop() {
		return this.tasks.pop();
	}

	@Override
	public boolean isEmpty() {
		return this.tasks.isEmpty();
	}

	@Override
	public int size() {
		return this.tasks.size();
	}

	@Override
	public void clear() {
		this.tasks.clear();
	}

}
