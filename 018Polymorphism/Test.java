public class Test{
	public static void main(String[] args){
		Animal A = new Animal();
		Cat C = new Cat();
		Dog D = new Dog();
		animalCry(A);
		animalCry(C);//Polymorphism here!
		animalCry(D);//Polymorphism here!
	}
	static void animalCry(Animal A){
		A.shout();
	}
}
