package sc.plane;

import java.awt.*;

/**
 * Explode class
 */
public class Explode {
    //Position
    double x, y;

    static Image[] imgs = new Image[16];

    int cnt = 0;

    static{
        for(int i=0;i<16;i++){
            imgs[i] = GameUtil.getImage("img/explode/e"+(i+1)+".gif");
            imgs[i].getWidth(null);//This line is used for dealing with the lazy loading of image.
        }
    }

    public void drawMyself(Graphics g){
        if(cnt<16) {
            g.drawImage(imgs[cnt], (int) x, (int) y, null);
            cnt++;
        }
    }
    public Explode(){}
    public Explode(double x, double y){
        this.x = x;
        this.y = y;
    }
}
