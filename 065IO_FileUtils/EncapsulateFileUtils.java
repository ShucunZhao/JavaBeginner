import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;

public class EncapsulateFileUtils{
	public static void main(String[] args){
		try{//Copy txt file.
			InputStream is = new FileInputStream("test1.txt");
			OutputStream os = new FileOutputStream("output1.txt");
			copy(is, os);
		}catch(IOException e){
			e.printStackTrace();
		}	
		//File to byte array:
		byte[] datas = null;
		try{//Copy txt file.
			InputStream is = new FileInputStream("ball.png");
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			copy(is, os);
			datas = os.toByteArray();
		}catch(IOException e){
			e.printStackTrace();
		}	
		//Byte array to file:
		try{//Copy txt file.
			InputStream is = new ByteArrayInputStream(datas);
			OutputStream os = new FileOutputStream("output2.png");
			copy(is, os);
		}catch(IOException e){
			e.printStackTrace();
		}	
	}

	public static void copy(InputStream is, OutputStream os){
		try{
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
			close(is, os);
		}
	}

	public static void close(InputStream is, OutputStream os){
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
	public static void close(Closeable...ios){
		for(Closeable io : ios){
			try{
			//Step4: Release source
			if(io!=null){
				io.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}

		}
	}
}
