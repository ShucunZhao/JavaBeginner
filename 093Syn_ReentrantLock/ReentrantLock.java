/**
  *	Reentrant lock: the locker can be use repeatly.
  */

public class ReentrantLock{
	Lock1 l1 = new Lock1();
	Lock2 l2 = new Lock2();
	public void a() throws InterruptedException{
		/*
		l1.lock();
		doSth();
		l1.unlock();
		*/
		l2.lock();
		System.out.println(l2.getHoldCnt());
		doSth();
		l2.unlock();
		System.out.println(l2.getHoldCnt());
	}
	//Un-reentrant lock here.
	public void doSth() throws InterruptedException{
		l2.lock();
		System.out.println(l2.getHoldCnt());
		/******Do something...***/
		l2.unlock();
		System.out.println(l2.getHoldCnt());
	}
	public void test(){
		synchronized(this){//First time got locker
			while(true){
				synchronized(this){//Second time got locker.
					System.out.println("ReentrantLock!");
				}
				try{
					Thread.sleep(1000);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException{
		//Test default reentrant lock:
		//new ReentrantLock().test();
		ReentrantLock test = new ReentrantLock();
		test.a();
		test.doSth();

		Thread.sleep(1000);

		System.out.println(test.l2.getHoldCnt());
	}
}

//The un-reentrant lock implementation:
class Lock1{
	//If a locker is on hold.
	private boolean isLocked = false;
	//Use lock
	public synchronized void lock() throws InterruptedException{
		while(isLocked){
			this.wait();
		}	
		isLocked = true;
	}
	//Free lock
	public synchronized void unlock(){
		isLocked = false;
		notify();
	}
}

//The reentrant lock implementation:
class Lock2{
	//If a locker is on hold.
	private boolean isLocked = false;
	private Thread lockedBy = null;//Store the thread
	private int holdCnt = 0;//Counter the times of lock used.
	//Use lock
	public synchronized void lock() throws InterruptedException{
		Thread tmp = Thread.currentThread();
		while(isLocked&&lockedBy!=tmp){
			this.wait();
		}	
		isLocked = true;
		lockedBy = tmp;
		holdCnt++;
	}
	//Free lock
	public synchronized void unlock(){
		if(Thread.currentThread()==lockedBy){
			holdCnt--;
			if(holdCnt==0){
				isLocked = false;
				notify();
				lockedBy = null;
			}
		}
	}

	public int getHoldCnt(){
		return holdCnt;
	}
}
