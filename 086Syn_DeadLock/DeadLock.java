/**
  *	Dead lock: too many syns maybe cause always waiting mutually which is called dead lock.
  */

public class DeadLock{
	public static void main(String[] args){
		Makeup m1 = new Makeup(1, "Alice");
		Makeup m2 = new Makeup(0, "Nancy");
		m1.start();
		m2.start();
	}
}

class Lipstick{

}

class Mirror{

}

class Makeup extends Thread{
	static Lipstick lipstick = new Lipstick();
	static Mirror mirror = new Mirror();
	int choice;
	String name;
	public Makeup(int choice, String name){
		this.choice = choice;
		this.name = name;
	}
	@Override
	public void run(){
		makeup();	
	}
	//Hold each other locker mutually that maybe cause deadlock.
	private void makeup(){
		if(choice==0){
			synchronized(lipstick){//Get the locker of lipstick object.
				System.out.println(this.name+" got the lipstick locker.");
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			synchronized(mirror){//After one second, get the locker of mirror object.
				System.out.println(this.name+" got the mirror locker.");
			}
		}
		else{
			synchronized(mirror){//Get the mirror object locker first this time.
				System.out.println(this.name+" got the mirror locker.");
				try{
					Thread.sleep(2000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			synchronized(lipstick){//After two second, get lipstick object locker.
				System.out.println(this.name+" got the lipstick locker.");
			}
		}
	}
}
