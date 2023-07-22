/**
  * Thread unsafe situations:
  * negative data and duplicates data exist.
  */

public class UnsafeThread implements Runnable{
	private int ticketNums = 99;
	private boolean flag = true;

	@Override
	public void run(){
		while(flag){
			test();
		}
	}

	public void test(){
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

	public static void main(String[] args){
		//One source and multiple agent
		/*
		UnsafeThread UT = new UnsafeThread();
		new Thread(UT, "gb1").start();
		new Thread(UT, "gb2").start();
		new Thread(UT, "gb3").start();
		*/
		Account account = new Account(100,"Money");	
		Withdraw you = new Withdraw(account, 80, "Joker");
		Withdraw another = new Withdraw(account, 90, "Alice");
		Thread t1 = new Thread(you, "You");
		Thread t2 = new Thread(another, "Another");
		t1.start();
		t2.start();
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

