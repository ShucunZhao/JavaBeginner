package sc.plane;

import java.awt.*;

/**
 * The root class of object in game.
 */
public class GameObject {
    Image img;//image
    double x, y;//coordinate
    int speed;//speed
    int width, height;//width and height of object
    boolean left, right, up, down;//Directions of plane
    public GameObject(){}
    public GameObject(Image img, double x, double y, int speed, int width, int height){
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public void drawMyself(Graphics g){
         g.drawImage(img, (int)x, (int)y, width, height, null);
        if(left){
            x -= speed;
        }
        if(right){
            x += speed;
        }
        if(up){
            y -= speed;
        }
        if(down){
            y += speed;
        }
    }

    //Everything is rectangle in game, so we can get the rectangle to do some judgement.
    public Rectangle  getRect(){
        return new Rectangle((int)x,(int)y,width,height);
    }

//    Image plane = GameUtil.getImage("img/plane.png");
//    int planeX = 100;
//    int PlaneY
//    int speed
}
