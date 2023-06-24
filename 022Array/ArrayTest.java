public class ArrayTest{
	public static void main(String[] args){
		/*
		int[] s = new int[10];
		char[] c = new char[10];
		System.out.println("s:"+s);
		System.out.println("c:"+c);
		for(int i=0;i<s.length;i++){
			s[i]=2*i+1;
			System.out.println(s[i]);
		}
		*/
		//The length of array in java is certain, it cannot be changed
		//after being created.
		Man[] mans2 = new Man[5];
		for(int i=0;i<mans2.length;i++){
			mans2[i] = new Man();
			mans2[i].setId(i+1);
			int ascii = 62+i;
			char c = (char)ascii;
			mans2[i].setName(Character.toString(c));
			System.out.println(mans2[i].getId()+": "+mans2[i].getName());
		}

		//Cannot do the static initialization after delaring like below:
		//Man[] mans = new Man[3];
		//mans = {new Man(1,"A"),new Man(2, "B"), new Man(3, "C")};
		//Instead, we need to initialize it when declare:
		Man[] mans = {new Man(1,"A"),new Man(2, "B"), new Man(3, "C")};
		for(int i=0;i<mans.length;i++){
			System.out.println(mans[i].getId()+": "+mans[i].getName());
		}
		for(Man man : mans){
			System.out.println(man.getId()+": "+man.getName());
		}
	}
}

class Man{
	private int id;
	private String name;
	public Man(int id, String name){
		this.id = id;
		this.name = name;
	}
	public Man(){}
	public void setId(int In){
		this.id = In;
	}
	public void setName(String In){
		this.name = In;
	}
	public int getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
}
