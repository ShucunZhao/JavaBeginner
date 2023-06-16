package sc.encapsulate.a;

public class Person{
	private int testPrivate = 1;
	int testDefault = 2;
	int testProtected = 3;

	public void test(){
		System.out.println(this.testPrivate);
	}
}
