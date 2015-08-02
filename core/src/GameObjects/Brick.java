package GameObjects;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

/**
 * Created by Diogo on 01/08/2015.
 */
public class Brick extends GameObject implements Drawable
{
    private Rectangle bounds;

    public Brick(float x, float y, float width, float height, ArrayList<TextureRegion> images)
    {
        super(x,y,width,height,images);
        bounds = new Rectangle(x, y, width, height);
    }

    @Override
    public void draw(SpriteBatch batch) {

    }

    @Override
    public void addImages(ArrayList<TextureRegion> images) {

    }

    public Rectangle getBounds()
    {
        return bounds;
    }
}
