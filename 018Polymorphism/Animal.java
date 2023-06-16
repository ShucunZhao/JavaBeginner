public class Animal{
	public void shout(){
		System.out.println("Yell one time.");
	}
}

class Dog extends Animal{
	@Override
	public void shout(){
		System.out.println("Woof woof woof.");
	}
}

class Cat extends Animal{
	@Override
	public void shout(){
		System.out.println("Meow meow meow.");
	}
}
