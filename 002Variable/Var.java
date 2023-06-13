public class Var{
	int stdID;//Member variable.
	static int cmpID;//Static variable.
	public static void main(String[] args){
		int a = Integer.MAX_VALUE;//Local variable.
		boolean b = false;
		final double constVal = 3.14D;//Constant variable use final to declare.
									//And the double integer should end with D.
		//constVal = 2;
		//System.out.println(a);
		byte Byte = 100;
		int c = 010;
		int d = 0xA3;
		int e = 0B1001;
		long lg = 2222222222222222L;//Define a integer to long type should add
									//a 'L' at last.
		//System.out.println(lg);
		double d1 = 3.14;
		float d2 = 3.15E2F;
		float d3 = 0.1F;
		double d4 = 1.0/10;
		char c1 = 'a';
		int c2 = 'a';
		char c3 = '\u0061';
		boolean bool = true;
		System.out.println(bool);
		//System.out.println(d3==d4);
		//System.out.println("d1: "+d1);
		//System.out.println("d2: "+d2);
		/*
		System.out.println(Byte);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		*/
		//System.out.println(constVal);
		//System.out.println("b is:"+b);
	}
}
