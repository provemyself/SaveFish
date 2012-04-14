package com.savefish.screens.button;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.screens.MenuScreen;


public class MenuActor extends Image {

    private TextureRegion []region;
	private Game game;
	public MenuActor(Game game, TextureRegion []region) {

		super(region[0]);
		this.x = 380;
		this.y = 20;
		this.scaleX = 0.5f;
		this.scaleY = 0.5f;
		this.game = game;
		this.region = region;
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
	fishMoving();
	super.draw(batch, parentAlpha);

	}
	static final int frame = 24;
	int fishMove = 0;
	private void fishMoving(){
		
		if(fishMove<frame/2){
			fishMove++;			
			this.setRegion(region[0]);
		}
		else if((fishMove>=frame/2)&&(fishMove<frame)){
			fishMove++;
			this.setRegion(region[1]);
		}
		else{
			fishMove = 0;
		}
	}

	@Override
	public boolean touchDown(float x, float y, int point) {
		
        game.setScreen(new MenuScreen(game));
		return false;

	}

}
