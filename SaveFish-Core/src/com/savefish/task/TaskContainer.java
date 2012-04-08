package com.savefish.task;

public interface TaskContainer<T extends Task<?, ?>> {
	public void push(T task);

	public void remove(T task);

	public T pop();

	public boolean isEmpty();

	public int size();

	public void clear();
}
