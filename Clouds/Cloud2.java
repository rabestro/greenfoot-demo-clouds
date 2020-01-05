import greenfoot.*;  

public class Cloud2 extends SideScrollingActor {
    private static final int SPEEDRANGE = 2;
    public Cloud2() {
        speed = -(Greenfoot.getRandomNumber(SPEEDRANGE) + 1);
        GreenfootImage image = getImage();
        image.setTransparency(200);
        setImage(image);
    }
}
