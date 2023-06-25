public class CustomizeException{
	public static void main(String[] args){
		Person p = new Person();
		try{
			p.setAge(-1);
		}catch(IllegalAgeException e){
			e.printStackTrace();
		}
		System.out.println(p);
	}
}

class IllegalAgeException extends Exception{
	public IllegalAgeException(){
	
	}
	public IllegalAgeException(String msg){
		super(msg);
	}
}

class Person{
	private int age;
	private String name;

	public void setAge(int In) throws IllegalAgeException{
		if(In<0){
			throw new IllegalAgeException("The age of person should not be negative!");
		}
		this.age = In;
	}	
}
