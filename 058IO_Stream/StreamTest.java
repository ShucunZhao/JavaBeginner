import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
  * The step of stream operations:
  * 1.Create source
  * 2.Select stream
  * 3.Operations
  * 4.Release source
  */

public class StreamTest{
	public static void main(String[] args){
		//Step1: create source.
		File src = new File("test1.txt");
		//Step2: select stream.
		InputStream is = null;
		try{
		 	is = new FileInputStream(src);
			//Step3: Read.
			int tmp = -1;
			while((tmp=is.read())!=-1){
				System.out.println((char)tmp);
			}
			/*
			int data1 = is.read();//The first data.
			int data2 = is.read();//The second data.
			int data3 = is.read();//The third data.
			System.out.println("data1: "+(char)data1);
			System.out.println("data2: "+(char)data2);
			System.out.println("data3: "+(char)data3);
			*/
			//			is.close();
		}catch(FileNotFoundException e){
			System.out.println("File not found: "+e.getMessage());
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				//Step4: Release source
				if(is!=null){
					is.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
