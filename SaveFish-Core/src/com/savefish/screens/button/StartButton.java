package com.savefish.screens.button;

/*
 * @introduce 该类是界面关卡选择一级界面里需要用到的按钮
 */
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.screens.SelectScreen;
import com.savefish.screens.game.GameScreen;

public class StartButton {
	private ChoiceoneActor choiceoneActor;
	private ChoicetwoActor choicetwoActor;
	private Game game;
	public StartButton(Game game){
		this.game = game;
	}
	public ChoiceoneActor getChoiceoneActor(TextureRegion region){
		choiceoneActor = new ChoiceoneActor(region);
		return choiceoneActor;
	}
	
	public ChoicetwoActor getChoicetwoActor(TextureRegion region){
		choicetwoActor = new ChoicetwoActor(region);
		return choicetwoActor;
	}
	
	public class ChoiceoneActor extends Image {


		private ChoiceoneActor(TextureRegion region) {
			
			super(region);
			this.x = 120;
			this.y = 120;
		
		}

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {

			super.draw(batch, parentAlpha);
		
		}

		@Override
		public boolean touchDown(float x, float y, int point) {
            game.setScreen(new SelectScreen(game));
			return false;

		}
		
	}
	public class ChoicetwoActor extends Image {


		private ChoicetwoActor(TextureRegion region) {
			
			super(region);
			this.x = 270;
			this.y = 120;
		
		}

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {

			super.draw(batch, parentAlpha);
		
		}

		@Override
		public boolean touchDown(float x, float y, int point) {
			
			game.setScreen(GameScreen.getInstance(game, 1));

			return true;

		}
		
	}
	
}
