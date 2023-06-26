package sc.plane;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Plane extends GameObject{
    boolean live = true;//If live.
    @Override
    public void drawMyself(Graphics g){
        if(live) {
            super.drawMyself(g);
        }
        //Change the flight algorithm of plane here:
//        x += speed;
    }
    public  Plane(Image img, double x, double y, int speed, int width, int height){
        super(img,x,y,speed,width,height);
    }

    public void changeDirection(KeyEvent e, boolean isAdd){
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            left = isAdd;
        }
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            right = isAdd;
        }
        else if(e.getKeyCode()==KeyEvent.VK_UP){
            up = isAdd;
        }
        else if(e.getKeyCode()==KeyEvent.VK_DOWN){
            down = isAdd;
        }
    }
}
