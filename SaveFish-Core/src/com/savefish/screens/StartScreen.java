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

	/**
	 * introduce ������Ϸ��˽�б���
	 * 
	 */
	private Stage stage;

	// �������˵���ť
	private MenuActor menuActor;
	private Image bgImage;
	private StartButton startButton;
	private ChoiceoneActor choiceoneActor;
	private ChoicetwoActor choicetwoActor;

	public StartScreen(Game game) {
		// TODO Auto-generated constructor stub
		
		bgImage = new Image(Constant.asset.bgMChoiceTexture);
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),
				true);
		menuActor = new MenuActor(game,Constant.asset.fish2Texture);
		startButton = new StartButton(game);
		choiceoneActor = startButton.getChoiceoneActor(Constant.asset.choice1ActorTexture);
		choicetwoActor = startButton.getChoicetwoActor(Constant.asset.choice2ActorTexture);
		
		stage.addActor(bgImage);
		stage.addActor(menuActor);
		stage.addActor(choiceoneActor);
		stage.addActor(choicetwoActor);
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
		stage.dispose();
	}

}
