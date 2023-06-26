package sc.plane;

import java.awt.*;

import static sc.plane.MyGameFrame.GAME_WIDTH;
import static sc.plane.MyGameFrame.GAME_HEIGHT;


/**
 * The bomb class of game.
 */
public class Bomb extends GameObject{
    double degree;//The bomb fly along with fixed degree.
    public Bomb(){
        x = 200;
        y = 200;
        degree = Math.random()*Math.PI*2;
        width = 5;
        height = 5;
        speed = 5;
    }

    @Override
    public void drawMyself(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillOval((int)x,(int)y,width,height);
        //Specific the moving algorithm for bomb.
        x+=speed*Math.cos(degree);
        y+=speed*Math.sin(degree);
        if(y>GAME_HEIGHT-this.height||y<40){
            degree = -degree;
        }
        if(x>GAME_WIDTH-this.width||x<0){
            degree = Math.PI-degree;
        }
        g.setColor(c);
    }
}
