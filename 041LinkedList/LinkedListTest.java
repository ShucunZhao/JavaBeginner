import java.util.List;
import java.util.LinkedList;

public class LinkedListTest{
	public static void main(String[] args){
		//Method of List:
		List<String> list = new LinkedList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("a");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		System.out.println("--------------------");
		for(String s : list){
			System.out.println(s);
		}
		//Method of LinkedList(Use the features of double list).
		System.out.println("----------Linkedlist1----------");
		LinkedList<String> list2 = new LinkedList<>();
		list2.addFirst("a");
		list2.addFirst("b");
		list2.addFirst("c");
		for(String s : list2){
			System.out.println(s);
		}
		System.out.println("----------Linkedlist2----------");
		LinkedList<String> list3 = new LinkedList<>();
		list3.addLast("a");
		list3.addLast("b");
		list3.addLast("c");
		for(String s : list3){
			System.out.println(s);
		}
	}
}

class Node<E>{//This wildcard represent the element in linkedlist, set or map.
	E item;
	Node<E> pre;
	Node<E> next;
	Node(E In, Node<E> pre, Node<E> next){
		this.item = In;
		this.pre = pre;
		this.next = next;
	}
}
