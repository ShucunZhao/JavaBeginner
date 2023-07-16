/**
  *	Join:
  * Use for merging thread in a jump in line way, other threads will be 
  * blocked to wait for it finish. And join() is a object method so we need  * to new a specific one thread object to use.
  */

public class ThreadJoin{
	public static void main(String[] args) throws InterruptedException{
		Thread T = new Thread(()->{
			for(int i=0;i<100;i++){
				System.out.println("Lambda..."+i);
			}
		});
		T.start();
		//main thread:
		for(int i=0;i<100;i++){
			if(i==20){
				T.join();
			}
			System.out.println("main..."+i);
		}
	}
}

class myYield implements Runnable{
	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName()+"---->start");
		Thread.yield();//Run this static method this thread will yield the resource and back to the status that waiting for cpu to schedule. 
		System.out.println(Thread.currentThread().getName()+"---->end");
	}
}
