import java.util.Map;
import java.util.HashMap;

public class HashSetImplement{
	
	HashMap map;
	private static final Object PRESENT = new Object();

	public HashSetImplement(){
		map = new HashMap();	
	}

	public void add(Object O){
		map.put(O, PRESENT);	
	}

	public int size(){
		return map.size();
	}

	@Override
	public String toString(){
		if(size()==0){
			return "[]";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(Object k : map.keySet()){
			sb.append(k+",");
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}

	public static void main(String[] args){
		HashSetImplement mySet = new HashSetImplement();
		mySet.add("aa");
		mySet.add("bb");
		mySet.add("aa");
		System.out.println(mySet);
	}
}
