public class Birdman implements Flight{
	public void fly(){
		System.out.println("I am bird man flying in the sky.");
	}
	public void help(){
		System.out.println("I am a good man.");
	}
	public static void main(String[] args){
		Birdman Bm = new Birdman();
		Bm.fly();
		Bm.help();
	}
}
