package com.savefish.screens;

/********************************
 * Description: end screen.
 * we will happen to the screen
 * when we end the game
 * Author     : Yang Yong
 * Date       : 2012/03/08
 *******************************/
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.savefish.constant.Constant;
import com.savefish.screens.button.EndButton;
import com.savefish.screens.button.EndButton.NextActor;
import com.savefish.screens.button.EndButton.ReplayActor;
import com.savefish.screens.button.EndButton.ShareActor;
import com.savefish.screens.button.MenuActor;

public class EndScreen implements Screen {

	private Stage stage = null;
	private MenuActor menuActor = null;
	private Image bgImage = null;
	private EndButton endButton = null;
	private ReplayActor replayActor;
	private NextActor nextActor;
	private ShareActor shareActor;

	public EndScreen(Game game) {

		init(game);
		stage.addActor(bgImage);
		stage.addActor(menuActor);
		stage.addActor(nextActor);
		stage.addActor(replayActor);
		stage.addActor(shareActor);
	}

	private void init(Game game) {
		bgImage = new Image(Constant.asset.bgMainTexture);
		bgImage.height = Gdx.graphics.getHeight();
		bgImage.width = Gdx.graphics.getWidth();
		endButton = new EndButton(game);
		replayActor = endButton
				.getReplayActor(Constant.asset.replayActorTexture);
		nextActor = endButton.getNextActor(Constant.asset.nextActorTexture);
		shareActor = endButton.getShareActor(Constant.asset.shareActorTexture);
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),
				true);
		menuActor = new MenuActor(game, Constant.asset.quitActorTexture);

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
