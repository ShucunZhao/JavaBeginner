import java.util.List;
import java.util.ArrayList;

public class ArrayListTest{
	public static void main(String[] args){
		//Initialize the ArrayList container.
		List<String> list = new ArrayList<>();
		//Add elements
		boolean flag = list.add("Frank");
		System.out.println(flag);
		list.add(1, "David");
		list.add("Jude");
		String removal = list.remove(0);
		System.out.println("Remove "+removal);
		list.remove("David");
		String rep = list.set(0, "Dog");
		System.out.println("Replace "+rep);
		list.clear();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		System.out.println("Is empty: "+list.isEmpty());	
		System.out.println("Is contains Dog: "+list.contains("Dog"));
		for(int i=0;i<4;i++){
			list.add("Dog");
		}
		System.out.println("The first index of Dog: "+list.indexOf("Dog"));
		System.out.println("The last index of Dog: "+list.lastIndexOf("Dog"));
		System.out.println("The last index of David: "+list.lastIndexOf("David"));//If element not exist in container will return -1.
		//Convert containter to object array:
		Object[] arr = list.toArray();
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
}
