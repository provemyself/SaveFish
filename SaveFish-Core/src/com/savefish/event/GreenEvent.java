package com.savefish.event;

public class GreenEvent<T> {
	private T source;

	public GreenEvent(T source) {
		this.source = source;
	}

	public T getSource() {
		return this.source;
	}
}
