import java.util.HashSet;
import java.util.Set;

/**
  * HashSet: non-repeated element and no order.
  * HashMap: can have repeated element and has order.
  */
public class HashSetTest{
	public static void main(String[] args){
		Set<String> mset = new HashSet<>();
		mset.add("aa");
		mset.add("bb");
		mset.add("aa");
		System.out.println(mset);
		System.out.println("bb");

		Set<String> mset2 = new HashSet<>();
		mset2.add("AA");
		mset2.addAll(mset);
		System.out.println(mset2);
	}
}
