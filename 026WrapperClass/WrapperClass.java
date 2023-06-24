public class WrapperClass{
	public static void main(String[] args){
		Integer i = new Integer(10);
		System.out.println(i);
		Integer a = Integer.valueOf(20);
		System.out.println(a);
		String s = new String("1112");
		Integer b = Integer.parseInt(s);
		System.out.println(b);
		System.out.println("Max: "+Integer.MAX_VALUE);
		System.out.println("Min: "+Integer.MIN_VALUE);
	}
}
