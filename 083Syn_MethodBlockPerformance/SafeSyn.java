/**
  * Thread safety: Make sure the accuracy and efficiency of data for synchronization.
  * 1. synchronized method.
  * 2. synchronized block for a specific object.
  */

public class SafeSyn implements Runnable{
	private int ticketNums = 99;
	private boolean flag = true;

	@Override
	public void run(){
		while(flag){
			//test2();
			test5();
		}
	}

	//public void test(){
	public synchronized void test(){
		if(ticketNums<=0){
			flag = false;
			return;
		}
		try{
			Thread.sleep(20);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" left: "+ticketNums--);
	}

	public void test2(){
		synchronized(this){
		if(ticketNums<=0){
			flag = false;
			return;
		}
		try{
			Thread.sleep(20);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" left: "+ticketNums--);
		}
	}

	public void test3(){//This will be fail to lock because the ticketNums is changable.
		synchronized((Integer)ticketNums){
		if(ticketNums<=0){
			flag = false;
			return;
		}
		try{
			Thread.sleep(20);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" left: "+ticketNums--);
		}
	}

	public void test4(){//This is also fail to lock because the range of synthronized block is too small.
		synchronized(this){
		if(ticketNums<=0){
			flag = false;
			return;
		}
		}
		try{
			Thread.sleep(20);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" left: "+ticketNums--);
	}

	public void test5(){//This is the optimal case.
		if(ticketNums<=0){//Double check here.
			flag = false;
			return;
		}
		synchronized(this){
		if(ticketNums<=0){
			flag = false;
			return;
		}		
		try{
			Thread.sleep(20);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" left: "+ticketNums--);
		}
	}

	public static void main(String[] args){
		//One source and multiple agent
		
		SafeSyn UT = new SafeSyn();
		new Thread(UT, "gb1").start();
		new Thread(UT, "gb2").start();
		new Thread(UT, "gb3").start();
		
		/*
		Account account = new Account(100,"Money");	
		Withdraw you = new Withdraw(account, 80, "Joker");
		Withdraw another = new Withdraw(account, 90, "Alice");
		Thread t1 = new Thread(you, "You");
		Thread t2 = new Thread(another, "Another");
		t1.start();
		t2.start();
		*/
	}

}

class Account{
	int money;
	String name;
	public Account(int money, String name){
		this.money = money;
		this.name = name;
	}
}

class Withdraw implements Runnable{
	Account account;//Which account we want to withdraw.
	int amount;//Amount of each deal.
	int total;//Total amount of withdraw.

	public Withdraw(Account ac, int amount, String name){
		//super(name);
		this.account = ac;
		this.amount = amount;
	}

	//@Override
	public String getName(){
		return Thread.currentThread().getName();
	}

	@Override
	public void run(){
	//public synchronized void run(){//In this time we cannot just use the synchronized method directly because it will lock the this object which is the Withdraw object but what we truly want to lock is the account object.
		if(account.money<=0) return;
		//We use synchronized block instread here:
		synchronized(account){
		if(account.money-amount<0){
			return;
		}
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		account.money-=amount;
		total+=amount;
		System.out.println(this.getName()+"-->Balance of account: "+account.money);
		System.out.println(this.getName()+"-->Withdraw total : "+total);
		}
	}

}

