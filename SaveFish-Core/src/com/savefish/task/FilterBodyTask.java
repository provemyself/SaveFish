package com.savefish.task;

import com.badlogic.gdx.physics.box2d.Body;

public class FilterBodyTask extends FilterBodyAdapter {
	private Body body;

	public FilterBodyTask(Body body) {
		this.body = body;
	}

	@Override
	public void onFilterBody() {

	}

	public Body getBody() {
		return this.body;
	}

}
