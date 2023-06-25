import java.io.File;

public class FileTest{
	public static void main(String[] args) throws Exception{
		File f1 = new File("/home/ShucunZhao/JavaBeginner/031FileClass/file.txt");	
		File f2 = new File("/home/ShucunZhao/JavaBeginner/031FileClass");
		System.out.println(f1);
		System.out.println(f1.length());
		System.out.println(System.getProperty("user.dir"));
		f1.createNewFile();
	}
}
