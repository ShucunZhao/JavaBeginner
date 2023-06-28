import java.util.Stack;

public class StackTest{
	public static void main(String[] args){
		Stack<String> st = new Stack<>();
		System.out.println("Added: "+st.push("a"));
		st.push("b");
		st.push("c");
		System.out.println("Position of a: "+st.search("a"));
		System.out.println("Position of b: "+st.search("b"));
		System.out.println("Position of c: "+st.search("c"));
		while(!st.isEmpty()){
			System.out.println(st.peek());
			st.pop();
		}
	}
}
