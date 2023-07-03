import java.io.File;

public class PathRepresent{
	public static void main(String[] args){
		System.out.println("File separator: "+File.separatorChar);
		//Path representation method1 by specific separator:
		String path1 = "/home/ShucunZhao/JavaBeginner/053IO_PathRepresentation/test.txt";
		System.out.println("path1: "+path1);
		//Path representation method2 by default separator in JVM:
		char sep = File.separatorChar;
		String path2 = sep+"home"+sep+"ShucunZhao"+sep+"JavaBeginner"+sep+"053IO_PathRepresentation"+sep+"test.txt";
		System.out.println("path2: "+path2);

		//Method1 to Construct a File object.
		File src1 = new File(path2);
		System.out.println(src1.length());

		//Method2 construct a File object by father path.
		File src2 = new File("/home/ShucunZhao/JavaBeginner/053IO_PathRepresentation", "test.txt");
		System.out.println(src2.length());

		//Method3 construct a File object by a father-path object.
		File src3 = new File(new File("/home/ShucunZhao/JavaBeginner/053IO_PathRepresentation"), "test.txt");
		System.out.println(src3.length());
		/**
		  * Path types:
		  * 1.Absolute path.
		  * 2.Relative path.
		  */
		File src4 = new File("test.txt");
		System.out.println(src4.length());
	}
}
