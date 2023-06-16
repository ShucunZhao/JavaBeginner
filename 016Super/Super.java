public class Super{
	public static void main(String[] args){
		Children C = new Children(1, 8, "David", "male");
		
	}
}

class Student{
	int id;
	int age;
	String name;
	void study(){
		System.out.println("Good good study, day day up.");
	}

	Student(int id, int age, String name){
		this.id = id;
		this.age = age;
		this.name = name;
		System.out.println("Create a new student object.");
	}

	Student(){
		System.out.println("Create a new student object.");
	}	
}

class Children extends Student{
	String gender;
	Children(int id, int age, String name, String gender){
		//super() if we don't write this(or this.) the compiler will call it automatically.
		super.study();//super is used for invoke the properties of father class.
		this.id = id;
		this.age = age;
		this.name = name;
		this.gender = gender;
		System.out.println("Create a new Children object.");
	}

	Children(){
		System.out.println("Create a new Children object.");
	}

	void printInfo(){
		System.out.println("Information of No."+this.id+" child is:");
		System.out.println("Age:"+this.age+", name:"+this.name+", gender:"+this.gender);
	}
}

class Adult extends Student{
	//@Override
	//Override the method of father class here.
	void study(){
		System.out.println("You must pass exam.");
	}
}
