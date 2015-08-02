package BBHelper;

import com.badlogic.gdx.InputProcessor;

import GamePlay.GameWorld;

/**
 * Created by Diogo on 31/07/2015.
 */
public class GameInputHandler implements InputProcessor
{
    private GameWorld gameWorld;
    private float scaleX, scaleY;

    public GameInputHandler(GameWorld gameWorld, float scaleX, float scaleY)
    {
        this.gameWorld=gameWorld;
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
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        screenX=scaleX(screenX);
        screenY=scaleY(screenY);

        gameWorld.checkTouchDown(screenX, screenY);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        screenX=scaleX(screenX);
        screenY=scaleY(screenY);

        gameWorld.checkTouchUp(screenX, screenY);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        screenX=scaleX(screenX);
        screenY=scaleY(screenY);

        gameWorld.checkDragged(screenX, screenY);
        return true;
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
