/**
  * Volatile: Use for data synchronize and visible.
  * Which can prevent happen before case.
  */

public class VolatileTest{
	private static volatile int num = 0;
	public static void main(String[] args) throws InterruptedException{
		new Thread(()->{
			while(num==0){

			}		
		}).start();
		Thread.sleep(1000);
		num = 1;
	}
}
