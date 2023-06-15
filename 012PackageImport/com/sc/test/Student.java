package com.sc.test;//Generally, the package clause is in the first line of the non-comment code.

public class Student{
	int id;
	int age;
	String name;
	static String Class = "Six";
	//Method.
	public static void main(String[] args){
		Student Std = new Student();//Constructor must use new to call.
		//System.out.println(Std);
		System.out.println("Address of Std: "+Std);
		System.out.println("Std id: "+Std.id);
		System.out.println("Std name: "+Std.name);
		Std.study();
		Student Std2 = new Student(3, 10,"Frank");
		System.out.println("Address of Std2: "+Std2);
		System.out.println("Std2 id: "+Std2.id);
		System.out.println("Std2 name: "+Std2.name);
		/*
		Student Std3;
		System.out.println("Address of Std3: "+Std3);
		System.out.println("Std2 id: "+Std3.id);
		System.out.println("Std2 name: "+Std3.name);
		*/
	}
	static void printClass(){
		//System.out.println("The class is "+name);The static method cannot invoke the non-static method, static like plan and non-static is the real-world.
		System.out.println("The class is "+Class);//static member is ok.
	}
	void study(){
		System.out.println("Good good study, day day up.");
	}

	Student(int id, int age, String name){
		this.id = id;
		this.age = age;
		this.name = name;
		System.out.println("Create a new student object.");
	}

	public Student(){
		System.out.println("Create a new student object.");
	}
	
}
