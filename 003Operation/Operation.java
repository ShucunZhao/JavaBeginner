public class Operation{
	public static void main(String[] args){
		//boolean a = false;
		//boolean b = false;
		int c = 3;
		c&=1;//Same as && but will not directly return if meet any false.
		int d = 0B1;
		//System.out.println(d);
		d=~d;
		int a = 7;//111
		int b = 8;//1000
		System.out.println(a&b);//0000--0
		System.out.println(a|b);//1111--15
		System.out.println(a^b);//1111--15
		System.out.println(~b);//
		System.out.println(b<<1);
		System.out.println(b>>1);
	}
}
