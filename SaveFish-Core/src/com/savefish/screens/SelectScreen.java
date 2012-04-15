package com.savefish.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.constant.Constant;
import com.savefish.screens.button.ChoiceButton;
import com.savefish.screens.button.ChoiceButton.Choice_1Actor;
import com.savefish.screens.button.ChoiceButton.Choice_2Actor;
import com.savefish.screens.button.ChoiceButton.Choice_3Actor;
import com.savefish.screens.button.ChoiceButton.Choice_4Actor;
import com.savefish.screens.button.ChoiceButton.Choice_5Actor;
import com.savefish.screens.button.ChoiceButton.Choice_6Actor;
import com.savefish.screens.button.MenuActor;

public class SelectScreen implements Screen {
	
	private Stage         stage;
	private MenuActor     menuActor;
	private Image         bgImage;
	
	private ChoiceButton  choiceButton;
	private Choice_1Actor choice_1Actor;
	private Choice_2Actor choice_2Actor;
	private Choice_3Actor choice_3Actor;
	private Choice_4Actor choice_4Actor;
	private Choice_5Actor choice_5Actor;
	private Choice_6Actor choice_6Actor;
	
	public  SelectScreen(Game game) {
		
		init(game);
		stage.addActor(bgImage);
		stage.addActor(menuActor);
		stage.addActor(choice_1Actor);
		stage.addActor(choice_2Actor);
		stage.addActor(choice_3Actor);
		stage.addActor(choice_4Actor);
		stage.addActor(choice_5Actor);
		stage.addActor(choice_6Actor);
	}
	
	private void init(Game game){
		bgImage        = new Image(Constant.asset.bgChoiceTexture);
		stage          = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),true);
		menuActor      = new MenuActor(game,Constant.asset.quitActorTexture);
		choiceButton   = new ChoiceButton(game);
		bgImage.height = Gdx.graphics.getHeight();
		bgImage.width  = Gdx.graphics.getWidth();
		choice_1Actor = choiceButton.getChoice_1Actor(Constant.asset.num1ActorTexture);
		choice_2Actor = choiceButton.getChoice_2Actor(Constant.asset.num2ActorTexture);
		choice_3Actor = choiceButton.getChoice_3Actor(Constant.asset.num3ActorTexture);
		choice_4Actor = choiceButton.getChoice_4Actor(Constant.asset.num4ActorTexture);
		choice_5Actor = choiceButton.getChoice_5Actor(Constant.asset.num5ActorTexture);
		choice_6Actor = choiceButton.getChoice_6Actor(Constant.asset.num6ActorTexture);
		
	}
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
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

	}

}
