package GamePlay;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

import BBHelper.AssetLoader;
import GameObjects.Ball;
import GameObjects.Drawable;
import GameObjects.Paddle;
import GameObjects.SimpleButton;
import Screens.GameScreen;

/**
 * Created by Diogo on 31/07/2015.
 */
public class GameWorld
{
    private GameScreen gameScreen;

    private int paddleYPos;
    private int gameWidth;
    private int gameHeight;

    private Paddle paddle;
    private Ball ball;

    private ArrayList<Drawable> drawables;
    private ArrayList<TextureRegion> images;
    private ArrayList<SimpleButton> clickables;

    public GameWorld(float gameWidth, float gameHeight, GameScreen gameScreen)
    {
        this.gameScreen=gameScreen;
        this.gameHeight=(int) gameHeight;
        this.gameWidth=(int) gameWidth;

        paddleYPos=(int) (gameHeight-(gameHeight/6));

        images=new ArrayList<TextureRegion>();
        drawables= new ArrayList<Drawable>();
        clickables = new ArrayList<SimpleButton>();

        images.clear();
        images.add(AssetLoader.paddle);
        paddle= new Paddle(gameWidth/2, gameHeight-(gameHeight/6), 40, 20, images);
        drawables.add(paddle);

        images.clear();
        images.add(AssetLoader.ball);
        ball=new Ball((gameWidth/2), gameHeight/2, 10,10, images);
        drawables.add(ball);
    }

    public ArrayList<Drawable> getDrawables()
    {
        return drawables;
    }

    public void checkTouchDown(int screenX, int screenY)
    {
        paddle.update(screenX);

        //Ver se a paddle salta para a mesma posiçao que a boa
        if (ball.getY() >  paddleYPos - 20)
        {
            if (Intersector.overlaps(ball.getBounds(), Rectangle.tmp.set(paddle.getX(), paddle.getY() + paddle.getHeight(), paddle.getWidth(), paddle.getHeight())));
            {
                ball.obstacleDown();
                ball.setY(paddle.getY() - ball.getHeight()-1);
                System.out.println("Sobreposiçao touchdown");
            }
        }
    }

    public void checkTouchUp(int screenX, int screenY)
    {

    }

    public void checkDragged(int screenX, int screenY) {
        paddle.update(screenX);
        if (ball.getY() >  paddleYPos - 20)
        {
            if (Intersector.overlaps(ball.getBounds(), Rectangle.tmp.set(paddle.getX(),paddle.getY()+paddle.getHeight(),paddle.getWidth(),paddle.getHeight())))
            {
                System.out.println("Sobreposicao dragged"+  Intersector.overlaps(ball.getBounds(), Rectangle.tmp.set(paddle.getX(),paddle.getY()+paddle.getHeight(),paddle.getWidth(),paddle.getHeight())));
                ball.obstacleDown();
                ball.setY(paddle.getY() - ball.getHeight() - 1);
            }
        }
    }

    public void update(float delta)
    {
        ball.update(delta);

        //Checks colision with the paddle.
        if (ball.getY() >  paddleYPos - 20)
        {
            if(Intersector.intersectSegmentCircle(paddle.getDownLeftEnd(),paddle.getUpLeftEnd(), ball.getCenter(),ball.getWidth()/2f))
            {
                ball.obstacleRight();
                ball.setX(paddle.getX() - ball.getWidth());
                System.out.println("obstacle right");
            }
            else if(Intersector.intersectSegmentCircle(paddle.getUpLeftEnd(),paddle.getUpRightEnd(), ball.getCenter() ,ball.getWidth()/2f))
            {
                ball.obstacleDown();
                ball.setY(paddle.getY() - ball.getHeight());
                System.out.println("obstacle down");
            }
            else if(Intersector.intersectSegmentCircle(paddle.getDownRightEnd(),paddle.getUpRightEnd(), ball.getCenter(),ball.getWidth()/2f))
            {
                ball.obstacleLeft();
                ball.setX(paddle.getX() + paddle.getWidth());
                System.out.println("obstacle left");
            }
            else if(ball.getY()>gameHeight)
            {
                gameScreen.goBack();
            }
        }
        if(ball.getY()<0)
        {
            ball.obstacleUp();
        }
        if(ball.getX()>gameWidth-ball.getWidth())
        {
            ball.obstacleRight();
        }
        if(ball.getX()<ball.getWidth())
        {
            ball.obstacleLeft();
        }
    }

}
