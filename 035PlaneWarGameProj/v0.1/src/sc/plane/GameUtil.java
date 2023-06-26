package sc.plane;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * The utility of game.
 */
public class GameUtil {
    private GameUtil(){//Make the constructor private for preventing others create object of this class.

    }
    public static Image getImage(String path){
        Image img = null;
        URL U = GameUtil.class.getClassLoader().getResource(path);
        try {
            img = ImageIO.read(U);
        }catch(IOException e){
            e.printStackTrace();
        }
        return img;
    }
    public static void main(String[] args){
        Image img = GameUtil.getImage("img/plane.png");
        System.out.println(img);
    }
}
