import java.awt.*;
import javax.swing.*;
public class BilliardsGame extends Object{

    //Load the images from img folder.
    Image ball = Toolkit.getDefaultToolkit().getImage("img/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("img/desk.png");
    double x = 200, y = 200;
    boolean right = true;//Control the direction of ball.
    double degree = 3.14/4; //Radian

    //Paint the image testing.
    public void paint(Graphics g){
        System.out.println("Paint once.");
        g.drawImage(desk, 0,0,null);
        g.drawImage(ball,(int)x,(int)y,null);
        x+=10*Math.cos(degree);
        y+=10*Math.sin(degree);

        //Hit the upper and lower border.
        if(y>430||y<70){
            degree = -degree;
        }
        //Hit the left and right border.
        if(x>796||x<34){
            degree = 3.14-degree;
        }


//        if(right){
//            x+=2;
//        }
//        else{
//            x-=2;
//        }
//        if(x>796 ){
//            right = false;
//        }
//        if(x<34){
//            right = true;
//        }
    }

    //Create frame.
    void launchFrame(){
        setSize(856, 501);//width, height
        setLocation(100, 100);//x, y
        setVisible(true);

        //Implement the animation effect, draw 25 times each second.
        while(true){
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public static void main(String[] args){
        System.out.println("My billiards game begin...");
        BilliardsGame BG = new BilliardsGame();
        BG.launchFrame();
    }

}
