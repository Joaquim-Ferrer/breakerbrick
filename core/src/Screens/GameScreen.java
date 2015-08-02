package Screens;

import com.BreakerBrick.game.BBGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import BBHelper.GameInputHandler;
import GamePlay.GameRenderer;
import GamePlay.GameWorld;

/**
 * Created by Diogo on 31/07/2015.
 */
public class GameScreen implements Screen
{
    //Class bbgame to be able to change screens
    BBGame game;

    private final int GAMEWIDTH=400;
    private final int GAMEHEIGHT=200;

    private float runTime;

    private GameWorld gameWorld;
    private GameRenderer gameRenderer;

    public GameScreen(BBGame game)
    {
        //Discover screen sizes
        this.game=game;
        float screenWidth= Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        gameWorld = new GameWorld(GAMEWIDTH, GAMEHEIGHT, this);
        gameRenderer= new GameRenderer(gameWorld, GAMEWIDTH,GAMEHEIGHT);
        Gdx.input.setInputProcessor(new GameInputHandler(gameWorld, screenWidth / gameRenderer.getGameWidth(), screenHeight / gameRenderer.getGameHeight()));

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta)
    {
        runTime+=delta;
        gameRenderer.render(runTime, delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public void goBack()
    {
        game.setScreen(new MenuScreen(game));
    }
}
