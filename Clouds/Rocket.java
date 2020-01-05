import lang.stride.*;
import greenfoot.*;

/**
 * 
 */
public class Rocket extends Actor
{
    private int speedX = 1;
    private int speedY = 0;
    private static final int SPEED = 2;
    private static final int BOUNDARY = 20;

    /**
     * 
     */
    public void act()
    {
        handleKeyPresses();
        boundedMove();
        checkForCrash();
    }

    private void handleKeyPresses()
    {
        if (Greenfoot.isKeyDown("down")) {
            speedX = 0;
            speedY = SPEED;
        } else if (Greenfoot.isKeyDown("up")) {
            speedX = 0;
            speedY = -SPEED;
        } else if (Greenfoot.isKeyDown("left")) {
            speedX = -SPEED;
            speedY = 0;
        } else if (Greenfoot.isKeyDown("right")) {
            speedX = SPEED;
            speedY = 0;
        } else {
            speedX = 0;
            speedY = 0;
        }
    }

    /**
     * 
     */
    private void boundedMove()
    {
        int newX = Math.max(BOUNDARY, speedX + getX());
        newX = Math.min(getWorld().getWidth() - BOUNDARY, newX);
        int newY = Math.max(BOUNDARY, speedY + getY());
        newY = Math.min(getWorld().getHeight() - BOUNDARY, newY);
        setLocation(newX, newY);
    }

    /**
     * 
     */
    private void checkForCrash()
    {
        Actor w = getOneIntersectingObject(Obstacle.class);
        if (w != null) {
            Greenfoot.stop();
        }
    }
}
