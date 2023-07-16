import java.util.HashMap;
import java.util.Map;

public class HashMapTest{
	public static void main(String[] args){
		Map<Integer, String> m1 = new HashMap<>();
		m1.put(1, "one");
		m1.put(2, "two");
		m1.put(3, "three");
		System.out.println(m1.get(1));
		System.out.println(m1.size());
		System.out.println("Is empty: "+m1.isEmpty());
		System.out.println("Is contains one: "+m1.containsValue("one"));
		System.out.println(m1);
	}
}
