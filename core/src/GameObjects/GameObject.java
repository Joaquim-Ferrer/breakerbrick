package GameObjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by Diogo on 30/07/2015.
 */
public class GameObject {

    protected Vector2 position;
    protected float width, height;
    //Has the images that are drawn
    protected ArrayList<TextureRegion> images;

    public GameObject(float x, float y, float width, float height, ArrayList<TextureRegion> images)
    {
        position= new Vector2(x,y);
        this.width=width;
        this.height=height;
        this.images=new ArrayList<TextureRegion>(images);
    }

    public float getX()
    {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
