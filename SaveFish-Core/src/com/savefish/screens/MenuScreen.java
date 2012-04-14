package com.savefish.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.constant.Constant;
import com.savefish.screens.button.ExitActor;
import com.savefish.screens.button.Fish;
import com.savefish.screens.button.OptionActor;
import com.savefish.screens.button.StartActor;
import com.savefish.screens.button.aboutActor;

public class MenuScreen implements Screen {

	private Stage stage;
	private StartActor  startActor;
	private aboutActor  aboutActor;
	private OptionActor optionActor;
	private ExitActor   exitActor;
	private Image bgImage;
	private Fish fish1;
	private Fish fish2;

	public MenuScreen(Game game) {
		
		bgImage = new Image(Constant.asset.bgMenuTexture);
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
		startActor = new StartActor(game,Constant.asset.fish1Texture);
		aboutActor= new aboutActor(game,Constant.asset.fish2Texture);
		optionActor=new OptionActor(game,Constant.asset.fish3Texture);
		exitActor  =new ExitActor(Constant.asset.fish2Texture);
		
		fish1 = new Fish(Constant.asset.fish1Texture);
		fish2 = new Fish(Constant.asset.fish2Texture);
		fish1.setPosition(0, 100,false);
		fish2.setPosition(480, 200,true);
		stage.addActor(bgImage);
//		stage.addActor(fish1);
//		stage.addActor(fish2);
		//实现图标鱼动效果
		stage.addActor(startActor);
		stage.addActor(aboutActor);
		stage.addActor(optionActor);
		stage.addActor(exitActor);
		

	}
	@Override
	public void render(float delta) {
		
		Gdx.input.setInputProcessor(stage);
        stage.act(delta);
        stage.draw();
        
	}
	
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
