/**
  * Design mode:
  * Static proxy mode.
  * 1.real role
  * 2.proxy role
  * These two roles should implement a same public interface.
  */

public class StaticProxy{
	public static void main(String[] args){
		new Agent(new You()).happyMarry();		
	}	
}

interface Marry{
	void happyMarry();
}

class You implements Marry{
	@Override
	public void happyMarry(){
		System.out.println("You did that.");
	}
}

class Agent implements Marry{
	//Real role for proxy
	private Marry target; 
	public Agent(Marry In){
		this.target = In;
	}
	@Override
	public void happyMarry(){
		read();
		this.target.happyMarry();
		after();
	}
	private void read(){
		System.out.println("Preparation...");
	}

	private void after(){
		System.out.println("Finished...");
	}
}
