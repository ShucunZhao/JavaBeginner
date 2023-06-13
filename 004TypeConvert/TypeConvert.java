public class TypeConvert{
	public static void main(String[] args){
		/*
		long a = 214142345;
		int b = a;//Cannot convert from shorter to longer.
		*/
		//constant integer can be assigned to byte,short,char within the range.
		//byte a = 123;
		//byte b = 1234;
		//In brute force convert: if the target type shorter than original, it will convert to a unkown value.
		//int a = 300;
		//byte b = (byte)a;
		//double a = 3.14;
		//int b = (int)a;
		long a = 100*60*24*365*80;
		long b = 100L*60*24*365*80;
		System.out.println(a);
		System.out.println(b);
	}
}
