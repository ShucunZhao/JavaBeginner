public class Inherit{
	public static void main(String[] args){
		Children C = new Children(1, 8, "David", "male");
		C.printInfo();
		System.out.println("C is a children class of Student: "+(C instanceof Student));
		System.out.println("C is a children class of Children: "+(C instanceof Children));

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

class Other{
	
}
