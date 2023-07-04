import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
  * The step of byte output stream operations:
  * 1.Create source
  * 2.Select stream
  * 3.Operations
  * 4.Release source
  */

public class OutputStreamTest{
	public static void main(String[] args){
		//Step1: create source, if the source is not exist it will create automatically.
		File src = new File("output1.txt");
		//Step2: select stream and this time is output stream.
		OutputStream os = null;
		try{
		 	//os = new FileOutputStream(src);
			//os = new FileOutputStream(src, appendFlag(boolean));
			os = new FileOutputStream(src, true);//If the append flag is true, the content will append at tail everytime.
			//Step3: operation: write out.
			String msg = "This is a write out message.\n";
			//Convert the content into byte array for writing.
			byte[] datas = msg.getBytes();//Encoding.
			os.write(datas,0,datas.length);
			os.flush();//Flush the data each time.
		}catch(FileNotFoundException e){
			System.out.println("File not found: "+e.getMessage());
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				//Step4: Release source
				if(os!=null){
					os.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	
	}
}
