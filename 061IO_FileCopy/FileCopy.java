import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
  * Combine the input and output stream for file copy.
  */
public class FileCopy{
	public static void main(String[] args){	
		copyFile("test1.txt", "output1.txt");
	}

	public static void copyFile(String srcPath, String destPath){
		//Step1: create source.
		//File srcIn = new File("test1.txt");
		//File srcOut = new File("output1.txt");
		File srcIn = new File(srcPath);
		File srcOut = new File(destPath);

		//Step2: select stream.
		InputStream is = null;
		OutputStream os = null;

		try{
		 	is = new FileInputStream(srcIn);
			os = new FileOutputStream(srcOut, true);
			//Step3.1: Read content.
			//int tmp = -1;
			byte[] charBuffer = new byte[1024];//Buffer container whose size general is 1024(1kb).
			int len = -1;//The length for receiving.
			
			while((len=is.read(charBuffer))!=-1){
				//System.out.println((char)tmp);
				//Convert byte array to string:(Same as the decoded step before)
				//String str = new String(charBuffer, 0, len);
				//String str = new String(charBuffer);
				//System.out.println(str);
				os.write(charBuffer,0,len);
			}
			os.flush();
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
				if(os!=null){
					os.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}	
