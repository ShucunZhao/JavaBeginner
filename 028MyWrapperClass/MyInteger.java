public class MyInteger{
	private int value;
	private static MyInteger[] cache;
	public static final int lower = -128;
	public static final int upper = 127;
	private MyInteger(int In){
		this.value = In;
	}
	static{
		cache = new MyInteger[upper-lower+1];
		for(int i=lower;i<=upper;i++){
			cache[i-lower] = MyInteger.valueOf(i);
		}
	}
	public static MyInteger valueOf(int In){
		if(In>=lower&&In<=upper){
			return cache[In-lower];
		}
		return new MyInteger(In);
	}
	public static void main(String[] args){
		MyInteger a = MyInteger.valueOf(100);
		MyInteger b = MyInteger.valueOf(100);
		System.out.println(a==b);
	}
}
