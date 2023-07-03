import java.io.File;
import java.io.IOException;

/**
  * createNewFile(): Only create when the file isn't exist.
  * delete(): Delete the exist file.
  */
public class CreateDeleteFile{
	public static void main(String[] args){	
		//String path1 = "/home/ShucunZhao/JavaBeginner/053IO_PathRepresentation/test.txt";
		File src = new File("/home/ShucunZhao/JavaBeginner/055IO_CreateDeleteFile/create.txt");
		
		boolean createFlag = false;
		try{
			createFlag = src.createNewFile();
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("If created successfully: "+createFlag);
		
		boolean delFlag = false;
		delFlag = src.delete();
		System.out.println("If deleted successfully: "+delFlag);
	}
}
