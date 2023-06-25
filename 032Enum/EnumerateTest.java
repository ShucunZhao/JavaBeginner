public class EnumerateTest{
	public static void main(String[] args){
		for(Season s : Season.values()){
			System.out.println(s);
		}
	}
}

enum Season{
	SPRING, SUMMER, AUTUMN, WINTER
}
