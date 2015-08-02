package BBHelper;

import com.badlogic.gdx.InputProcessor;

import GameMenu.MenuWorld;
import GamePlay.GameWorld;

/**
 * Created by Diogo on 30/07/2015.
 */
public class MenuInputHandler implements InputProcessor {

    private MenuWorld menuWorld;
    private float scaleX, scaleY;

    public MenuInputHandler(MenuWorld menuWorld, float scaleX, float scaleY)
    {
        this.menuWorld=menuWorld;
        this.scaleX=scaleX;
        this.scaleY=scaleY;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        screenX=scaleX(screenX);
        screenY=scaleY(screenY);

        menuWorld.checkTouchDown(screenX, screenY);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {
        screenX=scaleX(screenX);
        screenY=scaleY(screenY);

        menuWorld.checkTouchUp(screenX, screenY);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    private int scaleX(int screenX) {
        return (int) (screenX / scaleX);
    }

    private int scaleY(int screenY) {
        return (int) (screenY / scaleY);
    }
}
