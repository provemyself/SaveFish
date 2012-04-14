package com.savefish.screens.button;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Fish  extends Image{

		private TextureRegion []region;
		boolean directionLeft;
		public Fish(TextureRegion []region) {
			
			super(region[0]);
			this.x = 20;
			this.y = 20;
			this.scaleX = 0.5f;
			this.scaleY = 0.5f;
			directionLeft = true;
		    this.region = region;
		   
		}
        
		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {
		    fishMoving();			
			super.draw(batch, parentAlpha);
		
		}
		
		/*
		 * @Introduce 该函数用来设置鱼的起始游动位置是从左还是从右
		 */
		public void setPosition(float x,float y,boolean direction){
			this.x = x;
			this.y = y;
			directionLeft = direction;
		}
		
		/*
		 * @introduce 下面这个函数是用来使界面背景中的鱼来回游动显示
		 */
		static final int frame = 24;
        int fishMove = 0;
		private void fishMoving(){
			this.scaleX -= 0.0005f;
			this.scaleY -= 0.0005f;
			if(directionLeft == true){
				this.x -=1;
				if(this.x<=-100){this.x=480;this.scaleX = 0.5f;this.scaleY = 0.5f;}
			}
			else{
				this.x +=1;
				if(this.x>=480){this.x=0;this.scaleX = 0.5f;this.scaleY = 0.5f;}
			}
			
//			System.out.println(fishMove+"  "+frame);
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
    
		
}
