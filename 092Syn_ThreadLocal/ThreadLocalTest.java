/**
  *	Thread local: the local store field of each threads:
  * get/set/initialValue
  */

public class ThreadLocalTest{
	//private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
		protected Integer initialValue(){
			return 200;
		};
	};
	public static void main(String[] args){
		System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());
		threadLocal.set(90);
		System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());	
		new Thread(new MyRun()).start();
	}

	public static class MyRun implements Runnable{
		@Override
		public void run(){
			threadLocal.set((int)(Math.random()*99));
			System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());	
		}
	}
}
