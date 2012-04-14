package com.savefish.screens.button;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.screens.AboutScreen;

public class ChoiceButton {
	
	private Choice_1Actor choice_1Actor;
	private Choice_2Actor choice_2Actor;
	private Choice_3Actor choice_3Actor;
	private Choice_4Actor choice_4Actor;
	private Choice_5Actor choice_5Actor;
	private Choice_6Actor choice_6Actor;
	private Game game;
public ChoiceButton(Game game){
		this.game = game;
	}
	
	public Choice_1Actor getChoice_1Actor(TextureRegion region){
		choice_1Actor = new Choice_1Actor(region);
		return choice_1Actor;
	}
	public Choice_2Actor getChoice_2Actor(TextureRegion region){
		choice_2Actor = new Choice_2Actor(region);
		return choice_2Actor;
	}
	public Choice_3Actor getChoice_3Actor(TextureRegion region){
		choice_3Actor = new Choice_3Actor(region);
		return choice_3Actor;
	}
	public Choice_4Actor getChoice_4Actor(TextureRegion region){
		choice_4Actor = new Choice_4Actor(region);
		return choice_4Actor;
	}
	public Choice_5Actor getChoice_5Actor(TextureRegion region){
		choice_5Actor = new Choice_5Actor(region);
		return choice_5Actor;
	}
	public Choice_6Actor getChoice_6Actor(TextureRegion region){
		choice_6Actor = new Choice_6Actor(region);
		return choice_6Actor;
	}
	
	public class Choice_1Actor extends Image {

		private Choice_1Actor(TextureRegion region) {
			
			super(region);
			this.x = 30;
			this.y = 150;
		}

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {

			super.draw(batch, parentAlpha);
		
		}

		@Override
		public boolean touchDown(float x, float y, int point) {
            game.setScreen(new AboutScreen(game));
			return false;

		}
		
	}
	public class Choice_2Actor extends Image {

		private Choice_2Actor(TextureRegion region) {
			
			super(region);
			this.x = 150;
			this.y = 150;
//			this.scaleX = 0.5f;
//			this.scaleY = 0.5f;
		
		}

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {

			super.draw(batch, parentAlpha);
		
		}

		@Override
		public boolean touchDown(float x, float y, int point) {
            game.setScreen(new AboutScreen(game));
			return false;

		}
		
	}
	public class Choice_3Actor extends Image {


		private Choice_3Actor(TextureRegion region) {
			
			super(region);
			this.x = 240;
			this.y = 205;
//			this.scaleX = 0.5f;
//			this.scaleY = 0.5f;
		
		}

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {

			super.draw(batch, parentAlpha);
		
		}

		@Override
		public boolean touchDown(float x, float y, int point) {
			game.setScreen(new AboutScreen(game));
			return false;

		}
		
	}
	public class Choice_4Actor extends Image {


		private Choice_4Actor(TextureRegion region) {
			
			super(region);
			this.x = 260;
			this.y = 100;
//			this.scaleX = 0.5f;
//			this.scaleY = 0.5f;
		
		}

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {

			super.draw(batch, parentAlpha);
		
		}

		@Override
		public boolean touchDown(float x, float y, int point) {
			game.setScreen(new AboutScreen(game));
			return false;

		}
		
	}
	public class Choice_5Actor extends Image {


		private Choice_5Actor(TextureRegion region) {
			
			super(region);
			this.x = 360;
			this.y = 190;
//			this.scaleX = 0.5f;
//			this.scaleY = 0.5f;
		
		}

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {

			super.draw(batch, parentAlpha);
		
		}

		@Override
		public boolean touchDown(float x, float y, int point) {
			game.setScreen(new AboutScreen(game));
			return false;

		}
		
	}
	public class Choice_6Actor extends Image {


		private Choice_6Actor(TextureRegion region) {
			
			super(region);
			this.x = 380;
			this.y = 120;
//			this.scaleX = 0.5f;
//			this.scaleY = 0.5f;
		
		}

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {

			super.draw(batch, parentAlpha);
		
		}

		@Override
		public boolean touchDown(float x, float y, int point) {
			game.setScreen(new AboutScreen(game));
			return false;

		}
		
	}
	
}
