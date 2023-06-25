public class IntegerCache{
	public static void main(String[] args){
		Integer a = 3000;//Auto load int as Integer object.
		Integer b = 3000;
		System.out.println(a==b);//Two different objects
		System.out.println(a.equals(b));
		Integer c = 123;
		Integer d = 123;
		System.out.println(c==d);//When the integer is in the range [-128, 127] that will return the specific element from the Integer cache.
		System.out.println(c.equals(d));
	}
}
