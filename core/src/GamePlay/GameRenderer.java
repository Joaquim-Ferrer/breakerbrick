package GamePlay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

import BBHelper.AssetLoader;
import GameMenu.MenuWorld;
import GameObjects.Drawable;

/**
 * Created by Diogo on 31/07/2015.
 */
public class GameRenderer
{
    int gameWidth;
    int gameHeight;

    private GameWorld gameWorld;

    private OrthographicCamera cam;
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;

    private TextureRegion gameBg;
    private ArrayList<Drawable> drawables;

    public GameRenderer(GameWorld gameWorld, int gameWidth,int gameHeight)
    {
        this.gameWorld = gameWorld;
        //Cria uma camara. Os valores dados são os que o ecra vai ter. falso para o y ser 0 em cima
        cam = new OrthographicCamera();
        cam.setToOrtho(true, gameWidth, gameHeight);
        //start a shapeRemderer
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        //start a batcher
        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);

        //Initiate images
        initAssets();

        this.gameHeight=gameHeight;
        this.gameWidth=gameWidth;
    }

    public void render(float runTime, float delta)
    {
        // Fill the entire screen with black, to prevent potential flickering.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        batch.disableBlending();
        //Draw BackGround
        batch.draw(gameBg, 0, 0, 400,200);

        //Draw Objects
        drawables=gameWorld.getDrawables();
        batch.enableBlending();

        gameWorld.update(delta);

        if(drawables.size()>0)
        {
            for(Drawable drawable: drawables )
            {
                drawable.draw(batch);
            }
        }
        batch.end();
    }

    private void initAssets()
    {
        gameBg= AssetLoader.menuBg;
    }

    public float getGameWidth()
    {
        return gameWidth;
    }
    public float getGameHeight()
    {
        return gameHeight;
    }
}
