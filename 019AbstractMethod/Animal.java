public abstract class Animal{
	abstract public void shout();
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
