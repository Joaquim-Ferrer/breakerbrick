package GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

/**
 * Created by Diogo on 30/07/2015.
 */
public interface Drawable {

    public void draw(SpriteBatch batch);

    public void addImages(ArrayList<TextureRegion> images);
}
