public class LinkedListImplement<E>{
	private Node<E> head;
	private Node<E> tail;
	private int size;
	public static void main(String[] args){
		LinkedListImplement<String> list = new LinkedListImplement<>();
		list.add("a");
		list.add("b");
		list.add("c");
		/*
		for(int i=0;i<5;i++){
			list.add("a");
		}
		*/
		System.out.println(list);
		System.out.println("----------------------");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));	
		}
		System.out.println("----------------------");
		list.remove("b");
		System.out.println(list);
		list.remove("a");
		System.out.println(list);
		list.remove("c");
		System.out.println(list);
		System.out.println("----------------------");
		list.add(0, "f");
		System.out.println(list);
		list.add(1, "f");
		System.out.println(list);
		list.add(1, "a");
		System.out.println(list);

		/*
		list.remove(0);	
		System.out.println(list);
		list.remove(0);	
		System.out.println(list);
		list.remove(0);	
		System.out.println(list);
		*/
	}
	class Node<E>{
		private E val;
		private Node<E> pre;
		private Node<E> next;
		public Node(E In, Node<E> pre, Node<E> next){
			this.val = In;
			this.pre = pre;
			this.next = next;
		}
	}

	public void add(int i, E In){
		if(i<0||i>size){
			throw new RuntimeException("InValid index: "+i);
		}	
		Node<E> node = new Node<>(In, null, null);
		if(i==0){
			node.next = head;
			head = node;
			if(size==0){
				tail = node;
			}
		}
		else if(i==size){
			//System.out.println(tail);
			tail.next = node;
			node.pre = tail;
			tail = node;
		}
		else{
			i--;
			Node<E> cur = head;
			while(i>0){
				cur = cur.next;
				i--;
			}
			node.next = cur.next;
			node.next.pre = node;
			node.pre = cur;
			cur.next = node;
		}
		size++;
	}

	public void remove(E In){
		Node<E> cur = head;
		int index = 0;
		while(cur!=null&&cur.val!=In){
			index++;
			cur = cur.next;
		}
		if(cur!=null){
			remove(index);
		}
	}
	
	public void remove(int i){
		if(i<0||i>=size){
			throw new RuntimeException("Invalid index: "+i);
		}
		if(i==0){
			if(head.next!=null){
				head.next.pre = null;
			}
			head = head.next;
		}
		else{
			i--;
			Node<E> cur = head;
			while(i>0){
				cur = cur.next;
				i--;
			}
			if(cur.next.next!=null){
				cur.next.next.pre = cur;
			}
			cur.next= cur.next.next;
		}
		size--;
		if(size==0) tail = null;
	}
	
	public int size(){
		return this.size;
	}

	public E get(int i){
		if(i<0||i>=size){
			throw new RuntimeException("Invalid index: "+i);
		}
		Node<E> cur = head;
		while(i>0){
			cur = cur.next;
			i--;
		}
		return cur.val;
	}
	
	public void add(E In){
		Node<E> node = new Node<E>(In,null,null);
		if(head==null){
			head = node;
			tail = node;
		}
		else{
			node.pre = tail;
			tail.next = node;
			tail = node;
		}
		size++;
	}
	
	@Override 
	public String toString(){
		if(size==0){
			return "[]";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node<E> cur = head;
		while(cur!=null){
			sb.append(cur.val+",");
			cur = cur.next;
		}
		sb.setCharAt(sb.length()-1, ']');
		//System.out.println(head);
		return sb.toString();
	}
	
}
