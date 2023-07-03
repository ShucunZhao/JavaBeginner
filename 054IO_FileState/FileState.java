import java.io.File;

public class FileState{
	public static void main(String[] args){
		File src1 = new File("/054IO_FileState/test.txt");
		File src2 = new File("test.txt");
		File src3 = new File("/home/ShucunZhao/JavaBeginner/054IO_FileState");
		//File src2 = new File("/home/ShucunZhao/JavaBeginner/054IO_FileState/test2.txt");

		System.out.println("Is src1 exist: "+src1.exists());
		System.out.println("Is src1 file: "+src1.isFile());
		System.out.println("Is src1 path: "+src1.isDirectory());

		System.out.println("Is src2 exist: "+src2.exists());
		System.out.println("Is src2 file: "+src2.isFile());
		System.out.println("Is src2 path: "+src2.isDirectory());

		System.out.println("Is src3 exist: "+src3.exists());
		System.out.println("Is src3 file: "+src3.isFile());
		System.out.println("Is src3 path: "+src3.isDirectory());

		/**
		  * General operation:
		    src = new File("xx");
		    if(src==null||!src.exist()){
		  		System.out.println("File is not exist.");
		  	}
			else{
				if(src.isFile()){
					System.out.println("File operation.");
				}
				else{
					System.out.println("Path operation.");
				}
			}
		*/

	}
}
