package GameMenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

import BBHelper.AssetLoader;
import GameObjects.Drawable;

/**
 * Created by Diogo on 29/07/2015.
 */
public class MenuRenderer
{
    int menuWidth;
    int menuHeight;

    private MenuWorld menuWorld;

    private OrthographicCamera cam;
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;

    private TextureRegion menuBg;

    private ArrayList<Drawable> drawables;

    public MenuRenderer(MenuWorld menuWorld, int menuWidth, int menuHeight)
    {
        this.menuWorld=menuWorld;
        //Cria uma camara. Os valores dados sao os que o ecra vai ter. falso para o y ser 0 em cima
        cam=new OrthographicCamera();
        cam.setToOrtho(true, menuWidth, menuHeight);
        //start a shapeRemderer
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        //start a batcher
        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);

        //Initiate images
        initAssets();

        this.menuWidth=menuWidth;
        this.menuHeight=menuHeight;
    }

    public void render(float runTime)
    {
        // Fill the entire screen with black, to prevent potential flickering.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        batch.disableBlending();
        //Draw BackGround
        batch.draw(menuBg, 0, 0, 400,200);
        //Draw Objects
        drawables=menuWorld.getDrawables();
        batch.enableBlending();

        for(Drawable drawable: drawables )
        {
            drawable.draw(batch);
        }
        batch.end();
    }

    private void initAssets()
    {
        menuBg= AssetLoader.menuBg;
    }

    public float getGameWidth()
    {
        return menuWidth;
    }
    public float getGameHeight()
    {
        return menuHeight;
    }
}
