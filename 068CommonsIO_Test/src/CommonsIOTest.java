import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import java.io.File;
import java.util.Collection;

/**
 * Compile command: javac -cp "../lib/commons-io-2.13.0.jar" CommonsIOTest.java
 * Run command: java -cp ".:../lib/commons-io-2.13.0.jar" CommonsIOTest
 */

public class CommonsIOTest{
	public static void main(String[] args){
		File file = new File("CommonsIOTest.java");
		//File size:
		long len = FileUtils.sizeOf(file);
		System.out.println("Size of file is: "+len);
		//Path size:
		long plen = FileUtils.sizeOf(new File("/home/ShucunZhao/JavaBeginner/068CommonsIO_Test/src"));
		System.out.println("Size of path is: "+plen);
		Collection<File> files = FileUtils.listFiles(new File("/home/ShucunZhao/JavaBeginner/068CommonsIO_Test/src"), EmptyFileFilter.NOT_EMPTY, null);
		for(File f : files){
			System.out.println(f.getAbsolutePath());
		}
	}
}
