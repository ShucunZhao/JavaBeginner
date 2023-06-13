import java.util.Scanner;

public class myScanner{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter your name:");
		String name = s.nextLine();
		System.out.println("Please enter your age:");
		int age = s.nextInt();
		//String name = s.next();
		System.out.println("Name: "+name+", Age: "+age);
	}
}
