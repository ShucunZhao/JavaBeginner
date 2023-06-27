public class GenericMethod{
	//If the method is static, it only can use the generic method definition way, which cannot use the genric of class!
	public <T> void printName(T In){
		System.out.println(In);
	}
	public <T> T getName(T In){
		return In;
	}
	public <T> void changableM(T...args){
		for(T t : args){
			System.out.println(t);
		}
	}
}
