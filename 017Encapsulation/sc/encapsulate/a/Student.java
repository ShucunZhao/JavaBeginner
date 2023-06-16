package sc.encapsulate.a;

public class Student{
	public static void main(String[] args){
		Person P = new Person();
		//System.out.println(P.testPrivate);//Cannot access the private type property of same pakage class.
		System.out.println(P.testDefault);
		System.out.println(P.testProtected);
	}	
}
