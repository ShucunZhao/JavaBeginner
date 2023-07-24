/**
  *	Optimistic lock implement:
  * CAS: compare and swap.
  */

import java.util.concurrent.atomic.AtomicInteger;

public class CmpAndSwap{
	//
	private static AtomicInteger stock = new AtomicInteger(5);
	public static void main(String[] args){
		for(int i=0;i<5;i++){
			new Thread(()->{
				try{//Simulate the delay of network.
					Thread.sleep(200);		
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				Integer left = stock.decrementAndGet();
				if(left<1){
					System.out.println("sold out...");
					return;
				}
				System.out.print(Thread.currentThread().getName()+" got one.");
				System.out.println("-->Left: "+left);
			}).start();
		}
	}
}
