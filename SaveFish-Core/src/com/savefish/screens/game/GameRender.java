package com.savefish.screens.game;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.box2d.World;

public class GameRender {

	@SuppressWarnings("unused")
	private World world;
	@SuppressWarnings("unused")
	private Matrix4 combined;

	public GameRender(World world, Matrix4 combined) {
		this.world = world;
		this.combined = combined;
	}

}
