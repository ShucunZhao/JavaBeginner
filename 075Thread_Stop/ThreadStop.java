/**
  *	Thread terminate:
  * Way1: stop normally by itself.
  * Way2: interfere from outside by flag.
  * Don't use the unsafe method like stop and destroy.
  */

public class ThreadStop implements Runnable{
	private String name;
	//Add the flag for marking if the body of thread can run:
	private boolean flag = true;
	
	public ThreadStop(String name){
		this.name = name;
	}

	@Override
	public void run(){
		int i = 0;
		while(flag==true){
			System.out.println(name+"--->"+i++);
		}
	}
	
	//The method to change the flag for termination.
	public void terminate(){
		this.flag = false;
	}

	public static void main(String[] args){
		ThreadStop TS = new ThreadStop("T1");
		new Thread(TS).start();
		for(int i=0;i<100;i++){
			if(i==88){
				TS.terminate();
			}
			System.out.println("main-->"+i);
		}
	}
}
