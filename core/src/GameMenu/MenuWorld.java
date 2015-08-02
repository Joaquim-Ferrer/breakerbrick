package GameMenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

import BBHelper.AssetLoader;
import GameObjects.Drawable;
import GameObjects.SimpleButton;
import Screens.GameScreen;
import Screens.MenuScreen;

/**
 * Created by Diogo on 29/07/2015.
 */
public class MenuWorld
{
    //to be able to change Screens
    MenuScreen menuScreen;

    SimpleButton playButton;
    SimpleButton quitButton;

    ArrayList<Drawable> drawables;
    ArrayList<TextureRegion> images; //going to hold the images for the world objects
    ArrayList<SimpleButton> clickables; //going to hold all the possibilities that can be clickable

    public MenuWorld(MenuScreen menuScreen)
    {
        this.menuScreen=menuScreen;

        images=new ArrayList<TextureRegion>();
        drawables= new ArrayList<Drawable>();
        clickables = new ArrayList<SimpleButton>();

        images.clear();
        images.add(AssetLoader.buttonPlayUp);
        images.add(AssetLoader.buttonPlayDown);
        playButton=new SimpleButton(0,0,150,80, images, "PLAY");
        drawables.add(playButton);
        clickables.add(playButton);

        images.clear();
        images.add(AssetLoader.buttonQuitUp);
        images.add(AssetLoader.buttonQuitDown);
        quitButton = new SimpleButton(200,0,160,50, images, "QUIT");
        drawables.add(quitButton);
        clickables.add(quitButton);

    }

    public ArrayList<Drawable> getDrawables()
    {
        return drawables;
    }

    public void checkTouchDown(int screenX, int screenY)
    {
        if(clickables.size()>0)
        {
            //Gonna check for every cliackable if it is clicked. If yes stop checking
            for (int i = 0; i <clickables.size(); i++)
            {
                if(clickables.get(i).isTouchDown(screenX, screenY))
                {
                    break;
                }
            }
        }
    }

    public void checkTouchUp(int screenX, int screeY)
    {
        if(clickables.size()>0)
        {
            for(int i=0; i<clickables.size(); i++)
            {
                if(clickables.get(i).isTouchUp(screenX, screeY))
                {
                    if(clickables.get(i).getAction().equals("QUIT"))
                    {
                        Gdx.app.exit();
                    }
                    else if(clickables.get(i).getAction().equals("PLAY"))
                    {
                        menuScreen.geronimo(); //changes Screens
                    }
                }
            }
        }
    }
}
