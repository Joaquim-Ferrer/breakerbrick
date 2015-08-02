package GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by Diogo on 31/07/2015.
 */
public class Paddle  extends GameObject implements Drawable
{
    private Vector2 downLeftEnd, upLeftEnd, upRightEnd, downRightEnd;

    public Paddle(float x, float y, float width, float height, ArrayList<TextureRegion> images)
    {
        //bottom left dimensions
        super(x,y,width,height,images);
        downLeftEnd=new Vector2(x, y+height);
        upLeftEnd=new Vector2(x, y);
        upRightEnd=new Vector2(x + width, y);
        downRightEnd=new Vector2(x + width, y + height);
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        batch.draw(super.images.get(0), position.x,position.y, width,height);
    }

    @Override
    public void addImages(ArrayList<TextureRegion> images) {

    }

    public void update(int ScreenX)
    {
        int difX=(int)(ScreenX-this.width/2- position.x);
        position.x=ScreenX-this.width/2;
        downLeftEnd.add(difX,0);
        upLeftEnd.add(difX, 0);
        upRightEnd.add(difX, 0);
        downRightEnd.add(difX, 0);
    }

    public Vector2 getDownLeftEnd() {
        return downLeftEnd;
    }

    public Vector2 getUpLeftEnd() {
        return upLeftEnd;
    }

    public Vector2 getUpRightEnd() {
        return upRightEnd;
    }

    public Vector2 getDownRightEnd() {
        return downRightEnd;
    }

    public void debug()
    {
        System.out.println("pontos do paddle: " +  "(" + downLeftEnd.x + "," + downLeftEnd.y + ")" + "(" + upLeftEnd.x + "," + upLeftEnd.y + ")" + "(" + upRightEnd.x + "," + upRightEnd.y + ")" +  "(" + downRightEnd.x + "," + downRightEnd.y + ")");
    }
}
