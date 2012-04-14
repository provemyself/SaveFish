package com.savefish.event;

public interface BodyKilledListener<T> extends GreenEvevtListener<T> {
	public void onKillActor(GreenEvent<T> arg);
}
