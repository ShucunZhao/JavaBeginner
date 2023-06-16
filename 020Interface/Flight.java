/**
   * This is an interface of fligt.
  */

public interface Flight{
	int maxSpeed = 1000;//It's always public static final type inside of interface.
	void fly();//It's always public abstract type method.
}

interface Virtue{
	void help();
}



class Kindman implements Virtue{
	public void help(){
		System.out.println("I am a good man.");
	}
}


