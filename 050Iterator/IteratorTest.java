import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class IteratorTest{
	public static void main(String[] args){
		ListIterator();	
		MapIterator();
	}

	public static void ListIterator(){
		List<String> list = new ArrayList<>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		for(Iterator<String> it = list.iterator();it.hasNext();){
			String cur = it.next();
			System.out.println(cur);
		}
	}

	public static void MapIterator(){
		Map<Integer, String> m1 = new HashMap<>();
		m1.put(10, "aa");
		m1.put(20, "bb");
		m1.put(30, "cc");

		//Methon1 to traverse Map:
		Set<Entry<Integer,String> > entry1 = m1.entrySet();
		for(Iterator<Entry<Integer,String> > it = entry1.iterator();it.hasNext();){
			Entry<Integer, String> cur = it.next();
			System.out.println(cur.getKey()+":"+cur.getValue());
		}

		//Method2 to traverse Map:
		Set<Integer> keySet = m1.keySet();
		for(Iterator<Integer> it = keySet.iterator();it.hasNext();){
			Integer k = it.next();
			System.out.println(k+":"+m1.get(k));
		}
	}
	
}
