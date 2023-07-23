/** Singleton design mode: 
  * Base on lazy man mode and add syncrhonization control, whihc is
  * implemented by double checked locking. There only one object open
  * for outside:(Under multithread situation.)
  * 1. Privatize constrcutor to prevent new it outside.
  * 2. Offer a private static field to store object address.
  * 3. Offer a public static method to access the field.
  */

public class DoubleCheckedLock{

	private static volatile DoubleCheckedLock instance;//Use volatile to prevent happen before.
	
	private DoubleCheckedLock(){
	
	}

	public static DoubleCheckedLock getInstance(long time){
		//Double check here:
		if(instance!=null) return instance;
		synchronized(DoubleCheckedLock.class){
			if(instance==null){
				try{
					Thread.sleep(time);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				instance = new DoubleCheckedLock();//Happen before maybe happen here because new has three steps:
				//1.Open memory space 2.Initial object 3.return the address
			}
			return instance;
		}
	}

	public static DoubleCheckedLock getInstance2(long time){
			if(instance==null){
				try{
					Thread.sleep(time);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				instance = new DoubleCheckedLock();//Happen before maybe happen here because new has three steps:
				//1.Open memory space 2.Initial object 3.return the address
			}
			return instance;
	}

	public static void main(String[] args){
		//Test1: sigleton.
		Thread t1 = new Thread(()->{
			System.out.println(DoubleCheckedLock.getInstance(500));		
		});
		t1.start();
		System.out.println(DoubleCheckedLock.getInstance(100));
		/*	
		//Test2: unsingleton.
		Thread t2 = new Thread(()->{
			System.out.println(DoubleCheckedLock.getInstance2(500));		
		});
		t2.start();
		System.out.println(DoubleCheckedLock.getInstance2(100));
		 */
	}
}
