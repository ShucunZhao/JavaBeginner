/**
  * Priority use the method.
  *	Method2 to create thread:
  * 1.Implement Runnable interface and rewrite run() funciton.
  * 2.Create subclass object and Thread object to call start() func to launch.
  */

public class RunStart implements Runnable{

	/**
	  *	Then entry of thread:
	  */
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

	public static void main(String[] args){
		//Main thread in main function.
		//Launch the thread:
		//1.Create object of subclass:
		RunStart RS = new RunStart();
		//ThreadStart TS = new ThreadStart();
		//2.Create a Thread object to call start() func to launch.
		Thread T = new Thread(RS);
		T.start();

		//Another anonymous writing way:
		new Thread(new RunStart()).start();

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
