package Screens;

import com.BreakerBrick.game.BBGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import BBHelper.MenuInputHandler;
import GameMenu.MenuRenderer;
import GameMenu.MenuWorld;

/**
 * Created by Diogo on 29/07/2015.
 */
public class MenuScreen implements Screen
{
    //Class bbgame to be able to change screens
    BBGame game;

    private final int MENUWIDTH=400;
    private final int MENUHEIGHT=200;
    //Run Time of the Menu. Used for animations or other shit like added lifes
    private float runTime;
    //Class used for rendering the menu
    private MenuRenderer menuRenderer;
    //Class that contains the menu objects
    private MenuWorld menuWorld;


    public MenuScreen(BBGame game)
    {
        this.game=game;
        //Discover screen sizes
        float screenWidth= Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        menuWorld = new MenuWorld(this);
        menuRenderer = new MenuRenderer(menuWorld, MENUWIDTH, MENUHEIGHT);
        Gdx.input.setInputProcessor(new MenuInputHandler(menuWorld, screenWidth / menuRenderer.getGameWidth(), screenHeight / menuRenderer.getGameHeight()));

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta)
    {

        runTime+=delta;
        menuRenderer.render(runTime);
    }

    public void geronimo()
    {
        game.setScreen(new GameScreen(game));
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
}
