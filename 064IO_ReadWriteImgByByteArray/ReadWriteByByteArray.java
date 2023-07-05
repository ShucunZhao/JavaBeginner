import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.io.FileWriter;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;

/**
  *	1.Read the image into byte array: img to program.	
  * 2.Write the byte array to image file: program to byte array.
  */
public class ReadWriteByByteArray{
		
	public static void main(String[] args){
		//System.out.println(fileToByteArray("ball.png").length);
		byteArrayToFile(fileToByteArray("ball.png"), "output.png");
	}

	public static byte[] fileToByteArray(String srcIn){
		//Step1: create source.
		File src = new File(srcIn);
		//Step2: select stream.
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		try{
		 	is = new FileInputStream(src);
			baos = new ByteArrayOutputStream();
			//Step3: Read by segment.
			//int tmp = -1;
			byte[] Buffer = new byte[1024*10];//Buffer size is 10kb.
			int len = -1;//The length for receiving.
			while((len=is.read(Buffer))!=-1){
				baos.write(Buffer,0,len);//Write to byte array.
			}
			baos.flush();
			return baos.toByteArray();
		}catch(FileNotFoundException e){
			System.out.println("File not found: "+e.getMessage());
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				//Step4: Release source
				if(baos!=null){
					baos.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return null;	
	}
	
	//1.Read the byte array into program.
	//2.Program write out to file.
	public static void byteArrayToFile(byte[] src, String srcOut){
		//Step1: create source, if the source is not exist it will create automatically.
		File dest = new File(srcOut);
		//Step2: select stream and this time is output stream.
		OutputStream os = null;
		InputStream is = null;
		try{
			is = new ByteArrayInputStream(src);
			os = new FileOutputStream(dest);
			//Step3: operation: write out.
			byte[] datas = new byte[5];//Buffer container.
			int len = -1;
			while((len=is.read(datas))!=-1){
				os.write(datas, 0, len);
			}
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
