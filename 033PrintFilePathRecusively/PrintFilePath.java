import java.io.File;

public class PrintFilePath{
	public static void main(String[] args){
		File f1 = new File("/home/ShucunZhao/JavaBeginner");
		printPath(f1, 0);
	}
	static void printPath(File file, int level){
		//Print level
		for(int i=0;i<level;i++){
			System.out.print("-");
		}
		//Print file name
		System.out.println(file.getName());
		//If the file is a directory, do the print path for each subfile recursively.
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for(File f : files){
				//Recursively here
				printPath(f, level+1);
			}
		}
	}
}
