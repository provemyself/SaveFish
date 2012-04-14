package com.savefish.screens.button;
/*
 * @introduce 该类包含设置界面里需要用到的按钮类
 */
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.screens.AboutScreen;

public class OptionButton{
	
	private MusicActor musicActor;
	private ShareActor shareActor;
	private HighscoreActor highscoreActor;
	private Game game;
	
	public OptionButton(Game game){
		this.game = game;
	}
	public MusicActor getMusicActor(TextureRegion region){
		musicActor = new MusicActor(region);
		return musicActor;
	}
	public ShareActor getShareActor(TextureRegion region){
		shareActor = new ShareActor(region);
		return shareActor;
	}
	public HighscoreActor getHighscoreActor(TextureRegion region){
		highscoreActor = new HighscoreActor(region);
		return highscoreActor;
	}
	
	public class MusicActor extends Image {


		private MusicActor(TextureRegion region) {
			
			super(region);
			this.x = 360;
			this.y = 210;
			this.scaleX = 0.5f;
			this.scaleY = 0.5f;
		
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
	public class HighscoreActor extends Image {


		private HighscoreActor(TextureRegion region) {
			
			super(region);
			this.x = 230;
			this.y = 220;
			this.scaleX = 0.5f;
			this.scaleY = 0.5f;
		
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
	public class ShareActor extends Image {


		private ShareActor(TextureRegion region) {
			
			super(region);
			this.x = 350;
			this.y = 130;
			this.scaleX = 0.5f;
			this.scaleY = 0.5f;
		
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
