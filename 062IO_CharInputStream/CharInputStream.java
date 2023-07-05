import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.FileReader;

public class CharInputStream{
	public static void main(String[] args){
		//Step1: Create source.
		File src = new File("test1.txt");	
		//Step2: Select stream.
		Reader reader = null;
		try{
			reader = new FileReader(src);
			//Step3: operation - read by segment:
			char[] flush = new char[1024];//This time it's char type rather than byte because we use the Reader class.
			int len = -1;
			while((len=reader.read(flush))!=-1){
				//At this time we can constrcut the string by char array directly, which means don't need to decode it no more.
				String str = new String(flush, 0, len);
				System.out.println(str);
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			//Step4: release resource.
			try{
				if(reader!=null){
					reader.close();
				}
			}catch(IOException e){
				e.printStackTrace();	
			}
		}	
	}
}
