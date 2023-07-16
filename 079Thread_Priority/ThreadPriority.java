/**
  *	Priority of threads: from 1 to 10.
  * Three constly variable:
  * 1.NORM_PRIORITY: 5(default)
  * 2.MIN_PRIORITY: 1
  * 3.MAX_PRIORITY: 10
  */

public class ThreadPriority{
	public static void main(String[] args){
		System.out.println(Thread.currentThread().getPriority());		
		MyPriority mp = new MyPriority();
		Thread t1 = new Thread(mp);
		Thread t2 = new Thread(mp);	
		Thread t3 = new Thread(mp);
		Thread t4 = new Thread(mp);	
		Thread t5 = new Thread(mp);
		Thread t6 = new Thread(mp);	

		//We need to set priority before launch.
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);	
		t3.setPriority(Thread.MAX_PRIORITY);
		t4.setPriority(Thread.MIN_PRIORITY);
		t5.setPriority(Thread.MIN_PRIORITY);
		t6.setPriority(Thread.MIN_PRIORITY);		
		t1.start();
		t2.start();	
		t3.start();
		t4.start();
		t5.start();	
		t6.start();	
	}
}

class MyPriority implements Runnable{
	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName()+": "+Thread.currentThread().getPriority());	
		Thread.yield();
	}
}
