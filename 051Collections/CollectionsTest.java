import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
  * Collection is a interface but Collections is a method class.
  */
public class CollectionsTest{
	public static void main(String[] args){
		List<String> list = new ArrayList<>();
		for(int i=0;i<10;i++){
			list.add("a"+i);
		}
		System.out.println("Original:"+list);
		Collections.shuffle(list);//Permute the elements in list randomly.
		System.out.println("Shuffle:"+list);
		Collections.reverse(list);
		System.out.println("Reverse:"+list);
		Collections.sort(list);//We can define the comparable method ourself.
		System.out.println("Sorted:"+list);

		System.out.println("Index of \"a\":"+Collections.binarySearch(list, "a"));
		System.out.println("Index of \"a1\":"+Collections.binarySearch(list, "a1"));
	}
}
