public class StringBuilderBuffer{
	public static void main(String[] args){
		String str = "aaa";//Immutable 
		StringBuilder sbd = null;//Mutable but asynchronized, thread not safe and more efficent than StringBuffer.
		StringBuffer sbf = null;//Mutable but synthronized, thread safe.
		sbd = new StringBuilder("Frank");
		System.out.println(sbd);
		sbd.append(123);
		System.out.println(sbd);
		sbd.append("aa").append("bb").append("cc");
		System.out.println(sbd);

		//Efficiency analysis of string concatenate:
		String str1 = new String("");
		long mem1Begin = Runtime.getRuntime().freeMemory();
		long time1Begin = System.currentTimeMillis();
		for(int i=0;i<10000;i++){
			str1+=i;
		}
		long mem1End = Runtime.getRuntime().freeMemory();
		long time1End = System.currentTimeMillis();
		System.out.println("String mem: "+(mem1End-mem1Begin));
		System.out.println("String runtime: "+(time1End-time1Begin));
		
		StringBuffer str2 = new StringBuffer("");
		long mem2Begin = Runtime.getRuntime().freeMemory();
		long time2Begin = System.currentTimeMillis();
		for(int i=0;i<10000;i++){
			str2.append(i);
		}
		long mem2End = Runtime.getRuntime().freeMemory();
		long time2End = System.currentTimeMillis();
		System.out.println("StringBuffer mem: "+(mem2End-mem2Begin));
		System.out.println("StringBuffer runtime: "+(time2End-time2Begin));
	}
}
