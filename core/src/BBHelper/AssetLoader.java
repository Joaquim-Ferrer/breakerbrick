package BBHelper;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Diogo on 29/07/2015.
 */
public class AssetLoader
{
    public static Texture mainTexture;

    public static TextureRegion menuBg;

    public static TextureRegion buttonPlayUp;
    public static TextureRegion buttonPlayDown;
    public static TextureRegion buttonQuitUp;
    public static TextureRegion buttonQuitDown;

    public static TextureRegion paddle;
    public static TextureRegion ball;


    //load images and shit
    public static void load()
    {
        //Main texture- potencia de 2 em dimensoes 512*1024
        mainTexture=new Texture("mainTexture.png");

        //BackGround Texture. 512*512
        menuBg= new TextureRegion(mainTexture,0,0,512,512);
        menuBg.flip(false,true); //so that the rientation corresponds to the touch orientation

        //Buttons Textures
        buttonPlayUp = new TextureRegion(mainTexture, 540, 0,166,57);
        buttonPlayUp.flip(false,true);
        buttonPlayDown=new  TextureRegion(mainTexture, 706, 0,166,57);
        buttonPlayDown.flip(false,true);
        buttonQuitUp = new  TextureRegion(mainTexture, 540, 57,166,57);
        buttonQuitUp.flip(false,true);
        buttonQuitDown = new  TextureRegion(mainTexture, 706, 57,166,57);
        buttonQuitDown.flip(false,true);
        //Paddle
        paddle= new TextureRegion(mainTexture, 520,120,127,52);
        paddle.flip(false,true);
        //Ball
        ball=new TextureRegion(mainTexture, 520,175, 44, 36);
    }

    public static void dispose()
    {
        mainTexture.dispose();
    }

}
