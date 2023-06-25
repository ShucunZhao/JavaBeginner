import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;


public class TryWithResource{
	public static void main(String[] args){
		try(FileReader reader = new FileReader("./n.txt");){
			char c = (char)reader.read();
			char c2 = (char)reader.read();
			System.out.println(""+c+c2);
		}catch(Exception e){
			e.printStackTrace();
		}
		/*
		FileReader reader = null;
		try{
			reader = new FileReader("./a.txt");
			char c = (char)reader.read();
			char c2 = (char)reader.read();
			System.out.println(""+c+c2);
		}catch(FileNotFoundException e){
			e.printStackTrace();	
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(reader!=null){
					reader.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		*/
	}
}
