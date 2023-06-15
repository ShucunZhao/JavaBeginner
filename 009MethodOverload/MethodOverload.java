public class MethodOverload{
	public static int add(){
		return -1;
	}
	public static int add(int a, int b){//We can overload a same function by different formal parameters.
		return a+b;
	} 
	public static void main(String[] args){
		int a = 3;
		//int a = 4;//The variable cannot be the same name, which will cause redefine.
		int b = 4;
		//int c1 = add();
		//int c2 = add(a,b);
		System.out.println(add());
		System.out.println(add(a,b));
	}
}
