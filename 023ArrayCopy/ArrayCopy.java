public class ArrayCopy{
	public static void main(String[] args){
		String[] Org = {"A", "B", "C", "D", "E"};
		String[] Dst = new String[Org.length];
		System.arraycopy(Org, 0, Dst, 0, Org.length);
		for(String s : Dst) System.out.println(s);
	}
}
