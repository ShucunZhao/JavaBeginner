/**
  *	Daemon process service for user process and the jvm don't need
  * to wait for it finish.
  * JVM will wait all user process finish then terminate.
  */

public class DaemonProcess{
	public static void main(String[] args){
		You u = new You();
		God g = new God();
	   	Thread TG = new Thread(g);
		TG.setDaemon(true);
		new Thread(u).start();
	}
}

class You extends Thread{
	@Override
	public void run(){
		for(int i=1;i<365*100;i++){
			System.out.println("Living...");
		}
		System.out.println("End...");
	}
}

class God extends Thread{
	@Override
	public void run(){
		for(;true;){
			System.out.println("Blessing...");
		}
	}
}
