import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.io.FileWriter;

public class CharOutputStream{
	public static void main(String[] args){
		//Step1: create source, if the source is not exist it will create automatically.
		File src = new File("output1.txt");
		//Step2: select stream and this time is output stream.
		Writer writer = null;
		try{
			writer = new FileWriter(src);
			//Step3: operation: write out.
			String msg = "This is a write out message.\n";
			//Convert the content into byte array for writing.
			char[] datas = msg.toCharArray();//String to char array.
			writer.write(datas,0,datas.length);
			writer.flush();//Flush the data each time.
		}catch(FileNotFoundException e){
			System.out.println("File not found: "+e.getMessage());
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				//Step4: Release source
				if(writer!=null){
					writer.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	
	}
}
