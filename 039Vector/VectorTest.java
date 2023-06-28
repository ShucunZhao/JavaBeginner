import java.util.Vector;
import java.util.List;

public class VectorTest{
	public static void main(String[] args){
		List<String> vec = new Vector<>();
		for(int i=0;i<26;i++){
			//String str = new String("a".charAt(0)+i);
			char c = (char)('a'+i);
			vec.add(String.valueOf(c));
		}
		for(int i=0;i<vec.size();i++){
			System.out.println(vec.get(i));
		}
	}
}
