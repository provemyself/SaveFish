package com.savefish.screens;

/********************************
 * Description: select screen.
 * the screen includes 6 button
 * the game will turn to the 
 * corresponding levels
 * Author     : Yang Yong
 * Date       : 2012/03/08
 *******************************/
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.constant.Constant;
import com.savefish.screens.button.Choice2Button;
import com.savefish.screens.button.Choice2Button.Choice_1Actor;
import com.savefish.screens.button.Choice2Button.Choice_2Actor;
import com.savefish.screens.button.Choice2Button.Choice_3Actor;
import com.savefish.screens.button.Choice2Button.Choice_4Actor;
import com.savefish.screens.button.Choice2Button.Choice_5Actor;
import com.savefish.screens.button.Choice2Button.Choice_6Actor;
import com.savefish.screens.button.MenuActor;

public class Select2Screen implements Screen {

	private Stage stage;
	private MenuActor menuActor;
	private Image bgImage;

	private Choice2Button choice2Button;
	private Choice_1Actor choice_1Actor;
	private Choice_2Actor choice_2Actor;
	private Choice_3Actor choice_3Actor;
	private Choice_4Actor choice_4Actor;
	private Choice_5Actor choice_5Actor;
	private Choice_6Actor choice_6Actor;

	public Select2Screen(Game game) {

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

	private void init(Game game) {
		bgImage = new Image(Constant.asset.bgChoiceTexture);
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),
				true);
		menuActor = new MenuActor(game, Constant.asset.quitActorTexture);
		choice2Button = new Choice2Button(game);
		bgImage.height = Gdx.graphics.getHeight();
		bgImage.width = Gdx.graphics.getWidth();
		choice_1Actor = choice2Button
				.getChoice_1Actor(Constant.asset.num1ActorTexture);
		choice_2Actor = choice2Button
				.getChoice_2Actor(Constant.asset.num2ActorTexture);
		choice_3Actor = choice2Button
				.getChoice_3Actor(Constant.asset.num3ActorTexture);
		choice_4Actor = choice2Button
				.getChoice_4Actor(Constant.asset.num4ActorTexture);
		choice_5Actor = choice2Button
				.getChoice_5Actor(Constant.asset.num5ActorTexture);
		choice_6Actor = choice2Button
				.getChoice_6Actor(Constant.asset.num6ActorTexture);

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

	}

}