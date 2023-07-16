public class ThreadYield{
	public static void main(String[] args){
		myYield my = new myYield();
		new Thread(my, "a").start();
		new Thread(my, "b").start();
		//main thread:
		for(int i=0;i<100;i++){
			if(i%20==0){
				Thread.yield();
			}
			System.out.println("main..."+i);
		}
		new Thread(()->{
			for(int i=0;i<100;i++){
				System.out.println("Lambda..."+i);
			}
		}).start();
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
