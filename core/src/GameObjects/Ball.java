package GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.utils.*;

import java.util.ArrayList;

import BBHelper.AssetLoader;

/**
 * Created by Diogo on 31/07/2015.
 */
public class Ball  extends GameObject implements Drawable
{
    private Circle bounds;
    private Vector2 velocity;


    public Ball(float x, float y, float width, float height, ArrayList<TextureRegion> images)
    {
        super(x,y,width,height,images);
        bounds = new Circle(x,y,width/2);
        //VELOCITY OF THE BALL
        velocity=new Vector2(95,100);
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        batch.draw(AssetLoader.ball, position.x,position.y, width,height);
    }

    @Override
    public void addImages(ArrayList<TextureRegion> images) {

    }

    public void update(float delta)
    {
        position=position.mulAdd(velocity, delta);
        bounds.setPosition(position);
    }

    public void obstacleUp()
    {
        velocity.y=-velocity.y;
        System.out.println("ObstacleUp");
    }

    public void obstacleDown()
    {
        velocity.y=-velocity.y;
        System.out.println("ObstacleDown");
    }

    public void obstacleLeft()
    {
        velocity.x=-velocity.x;
    }

    public void obstacleRight()
    {
        velocity.x=-velocity.x;
    }

    public Circle getBounds()
    {
        return bounds;
    }

    public Vector2 getCenter()
    {
        return new Vector2(position.x+width*0.5f, position.y+height*0.5f);
    }

    public void setX(float x)
    {
        position.x=x;
    }

    public void setY(float y)
    {
        position.y=y;
    }

    public void debug()
    {
        System.out.println("CentroBall=("+  getCenter().x + "," + getCenter().y + " " + "raio=" + getWidth()/2);
    }
}
