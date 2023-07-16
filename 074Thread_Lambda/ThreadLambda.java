/**
  * Lambda expression: use for simplify the use of thread.
  * Generally use for thread only is used once.
  */

public class ThreadLambda{

	//Version1: static inner class:
	static class Test implements Runnable{
		public void run(){
			for(int i=0;i<20;i++){
				System.out.println("Listening music.");
				try{
					Thread.sleep(100);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}		
		}
	}
	/*
	@Override
	public void run(){
		//The body of thread.
		for(int i=0;i<20;i++){
			System.out.println("Listening music.");
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	*/

	public static void main(String[] args){
		
		//new Thread(new Test()).start();

		//Version2: local inner class which is no need to static.
		class Test2 implements Runnable{
			public void run(){
				for(int i=0;i<20;i++){
					System.out.println("Listening music.");
					try{
						Thread.sleep(100);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}		
			}
		}
		//new Thread(new Test2()).start();

		//Version3: anonymous inner class which must rely on interface or father class.
		new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<20;i++){
					System.out.println("Listening music.");
					try{
						Thread.sleep(100);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}		
			}
		}).start();

		//Version4: simplify by jdk8 which is called lambda expression:
		new Thread(()->{
			for(int i=0;i<20;i++){
				System.out.println("Listening music.");
				try{
					Thread.sleep(100);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}		
		}).start();	

		for(int i=0;i<20;i++){
			System.out.println("Wtriting code.");
			try{
				Thread.sleep(50);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
