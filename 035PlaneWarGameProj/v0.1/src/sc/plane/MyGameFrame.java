package sc.plane;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

/**
 * The main frame of game.
 */
public class MyGameFrame extends Frame{

    public static final int GAME_WIDTH = 500;
    public static final int GAME_HEIGHT = 500;

    Image planeImg = GameUtil.getImage("img/plane.png");
    Image bg = GameUtil.getImage("img/bg.jpg");
    Plane p1 = new Plane(planeImg,100,100,7,22,33);
    Bomb b1 = new Bomb();
    Bomb[] bSet = new Bomb[20];
    Explode exp;//Explode

    //Timing function.
    Date start = new Date();//Game start time.
    Date end;//Game end time.
    long period = 0;//The total seconds we played.

    //    Plane p2 = new Plane(planeImg,150,150,2,22,33);
//    Plane p3 = new Plane(planeImg,200,200,2,22,33);


//    GameObject plane = new GameObject(planeImg, 100, 100, 3,22,33);
//    static int cnt = 0;
//    int planeX = 100;

    @Override
    public void paint(Graphics g){//g is a paint brush.
        g.drawImage(bg, 0, 0, 500, 500, null);
        p1.drawMyself(g);
        b1.drawMyself(g);

        //Draw time
        drawTime(g);
        //Draw the bomb set
        for(int i=0;i<bSet.length;i++){
            bSet[i].drawMyself(g);
            boolean isMeet = bSet[i].getRect().intersects(p1.getRect());
            if(isMeet){
//                System.out.println("The plane meet the bomb!");
                p1.live = false;
                //Explode effect
                if(exp==null) {
                    exp = new Explode(p1.x, p1.y);
                }
                exp.drawMyself(g);
            }
        }
//        p2.drawMyself(g);
//        p3.drawMyself(g);
//        //g.drawImage(plane,100,100,22,33,null);
//        g.drawImage(plane,planeX,100,22,33,null);
//        planeX+=2;
        /*
        //System.out.println(g.getColor());
        Color curC = g.getColor();
        //g.setColor(Color.red);
        g.setColor(new Color(0,0,255));
        //Draw line.
        g.drawLine(100, 100, 400, 400);
        //Draw rectangle.
        g.drawRect(100,100,300,200);
        //Draw oval.
        g.drawOval(100,100,300,200);
        //Draw String.
        g.drawString("You know what time it's", 300, 300);
        g.setColor(curC);
         */
    }

    public void drawTime(Graphics g){
        Color curC = g.getColor();
        Font curF = g.getFont();
        g.setColor(Color.WHITE);
        if(p1.live) {
            g.drawString("Living time: "+(period),30,50);
            period = (System.currentTimeMillis() - start.getTime()) / 1000;
        }
        else{
            if(end==null){
                end = new Date();
                period = (end.getTime()-start.getTime())/1000;
            }
            g.setColor(Color.red);
            g.setFont(new Font("Font.PLAIN",Font.BOLD,30));
            g.drawString("Game over! Your score: "+(period)+"s",60,200);

        }
        g.setColor(curC);
        g.setFont(curF);
    }
    //Initial frame.
    public void launchFrame(){
        this.setTitle("Plane War");
        setVisible(true);//Set the frame as visible.
        setSize(500, 500);//Set size.
        setLocation(600, 100);//Position of frame.

        //Add the close window operation.
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //super.windowClosing(e);
                System.exit(0);//Close program normally.
            }
        });
        new PaintThread().start();//Start the repaint frame thread.
        this.addKeyListener(new KeyMonitor());//Launch the keyboard listening

        //Initial all bombs in bomb set.
        for(int i=0;i<bSet.length;i++){
            bSet[i] = new Bomb();
        }

    }

    /**
     * This is a repaint frame thread,
     * Define as intner class for using outer class methods.
     */
    class PaintThread extends Thread{
        @Override
        public void run(){
            while(true){
                repaint();//Method of frame: refresh the frame.
                         //Inner class can use the method of outer class
                try{
                    Thread.sleep(50);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    //Inner class: Listening the keyboard.
    class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){
//            System.out.println("Pressed: "+e.getKeyCode());
              p1.changeDirection(e, true);
        }

        @Override
        public void keyReleased(KeyEvent e){
//            System.out.println("Released: "+e.getKeyCode());
              p1.changeDirection(e, false);
        }
    }

    /**
     * This step is used for eliminating screen flicker.
     */

    private Image offScreenImage = null;
    public void update(Graphics g){
        if(offScreenImage==null){
            offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);//The width and height of game frame.
        }
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage,0,0,null);
    }

    public static void main(String[] args){
        MyGameFrame gameF = new MyGameFrame();
        gameF.launchFrame();

    }
}
