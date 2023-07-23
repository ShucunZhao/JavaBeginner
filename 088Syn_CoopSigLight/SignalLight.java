/**
  * Producer and consumer cooperation mode:
  * 2.Signal light mode:
  *   Include producer, consumer, buffer, product.
  */

public class SignalLight{
	public static void main(String[] args){
		Tv tv = new Tv();
		new Actor(tv).start();
		new Audience(tv).start();
	}
}

class Tv{
	String voice;
	boolean flag = true;//Signal light: true - actor acting and audience waiting, false - actor waiting and audience watching.
	public synchronized void act(String voice){
		if(flag==false){//Actor waiting.
			try{
				this.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		System.out.println("Acting "+voice);
		this.voice = voice;
		this.notifyAll();
		flag=!flag;
	}

	public synchronized void watch(){
		if(flag==true){
			try{
				this.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		System.out.println("Watching "+voice);	
		this.notifyAll();
		flag=!flag;
	}
}

class Actor extends Thread{
	Tv tv;
	public Actor(Tv tv){
		this.tv = tv;
	}
	
	@Override
	public void run(){
		for(int i=0;i<20;i++){
			if(i%2==0){
				this.tv.act("Feature film.");
			}
			else{
				this.tv.act("Advertisement.");
			}
		}	
	}
}

class Audience extends Thread{
	Tv tv;
	public Audience(Tv tv){
		this.tv = tv;
	}
	
	@Override
	public void run(){
		for(int i=0;i<20;i++){
			tv.watch();
		}	
	}
}


