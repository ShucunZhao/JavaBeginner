public class Test{
	public static void main(String[] args){
		GenericMethod GM = new GenericMethod();
		GM.printName("Hey");
		GM.printName(1.11);
		GenericMethod GM2 = new GenericMethod();
		System.out.println(GM2.getName("Jude"));
		GenericMethod GM3 = new GenericMethod();
		String[] arr = new String[]{"a","b","c"};
		GM3.changableM(arr);
		GenericMethod GM4 = new GenericMethod();
		Integer[] arr2 = new Integer[]{1,2,3};
		GM4.changableM(arr2);
		GM4.changableM(5);	
	}
}
