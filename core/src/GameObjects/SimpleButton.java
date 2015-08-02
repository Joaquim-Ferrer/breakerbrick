package GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

/**
 * Created by Diogo on 30/07/2015.
 */
public class SimpleButton extends GameObject implements Drawable {

    boolean isClicked;
    String action; //describes the action of the Button. When a button is clicked this is compared to all possibilities
    protected Rectangle bounds;

    public SimpleButton(float x, float y, float width, float height, ArrayList<TextureRegion> images, String action)
    {
        super(x, y, width, height, images); //the ArrayList is going to have the unpressed first and then the pressed
        isClicked = false;
        this.action=action;
        bounds = new Rectangle(x, y, width, height);
    }

    @Override
    public void draw(SpriteBatch batch) {
        if (isClicked) {
            batch.draw(super.images.get(1), position.x, position.y, width, height);
        } else {
            batch.draw(super.images.get(0), position.x, position.y,width,height);
        }
    }

    public boolean isClicked(int screenX, int screenY) {
        return bounds.contains(screenX, screenY);
    }

    public boolean isTouchDown(int screenX, int screenY) {
        if (bounds.contains(screenX, screenY)) {
            isClicked = true;
            return true;
        }
        return false;
    }

    public boolean isTouchUp(int screenX, int screenY) {
        if (bounds.contains(screenX, screenY) && (isClicked)) {
            isClicked = false;
            return true;
        }

        return false;
    }

    @Override
    public void addImages(ArrayList<TextureRegion> images)
    {
        this.images=images;
    }

    public String getAction()
    {
        return action;
    }

}
