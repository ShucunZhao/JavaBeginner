/**
  *	Method1 to create thread:
  * 1.Extend Thread class and rewrite run() funciton.
  * 2.Create subclass object and call start() func to launch.
  */

public class ThreadStart extends Thread{

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
		//1.Create object of sub thread class:
		ThreadStart TS = new ThreadStart();
		//2.Call start() func to launch.
		TS.start();

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
