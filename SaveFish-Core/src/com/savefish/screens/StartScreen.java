package com.savefish.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.constant.Constant;
import com.savefish.screens.button.MenuActor;
import com.savefish.screens.button.StartButton;
import com.savefish.screens.button.StartButton.ChoiceoneActor;
import com.savefish.screens.button.StartButton.ChoicetwoActor;

public class StartScreen implements Screen {


	private Stage          stage;
	private MenuActor      menuActor;
	private Image          bgImage;
	private StartButton    startButton;
	private ChoiceoneActor choiceoneActor;
	private ChoicetwoActor choicetwoActor;

	public StartScreen(Game game) {
		
		init(game);
		stage.addActor(bgImage);
		stage.addActor(menuActor);
		stage.addActor(choiceoneActor);
		stage.addActor(choicetwoActor);
	}

	private void init(Game game){
		
		bgImage        = new Image(Constant.asset.bgChoiceTexture);
		stage          = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),true);
		menuActor      = new MenuActor(game,Constant.asset.quitActorTexture);
		startButton    = new StartButton(game);
		bgImage.height = Gdx.graphics.getHeight();
		bgImage.width  = Gdx.graphics.getWidth();
		choiceoneActor = startButton.getChoiceoneActor(Constant.asset.choice1ActorTexture);
		choicetwoActor = startButton.getChoicetwoActor(Constant.asset.choice2ActorTexture);
		
	}
	@Override
	public void render(float delta) {
		Gdx.input.setInputProcessor(stage);
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		stage.dispose();
	}

}
