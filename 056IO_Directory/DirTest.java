import java.io.File;
/**
  * mkdir(): the father directory must exist or will fail to create.
  * mkdirs(): will create the father directory at the same time.
  * list(): list all name in current level.
  * listFiles(): list the File objects.
  */
public class DirTest{
	private static long size = 0;
	public static void main(String[] args){
		File dir = new File("/home/ShucunZhao/JavaBeginner/056IO_Directory/testDir/test");
		boolean flag1 = dir.mkdir();
		System.out.println("If mkdir(): "+flag1);
		boolean flag2 = dir.mkdirs();
		System.out.println("If mkdirs(): "+flag2);

		File dir2 = new File("/home/ShucunZhao/JavaBeginner/056IO_Directory");
		
		//List name:
		String[] subNames = dir2.list();
		for(String s : subNames){
			System.out.println(s);
		}

		//Get the File objects and list absolute path:
		File[] subFiles = dir2.listFiles();
		for(File f : subFiles){
			System.out.println(f.getAbsolutePath());
		}

		//Use File objects to count the size of path(Count all file in the path) by recursion:
		count(dir2);
		System.out.println("Size of "+dir2.getAbsolutePath()+" : "+size);
	}
	public static void count(File src){
		if(src!=null&&src.exists()){
			if(src.isFile()){
				size+=src.length();
			}
			else{
				for(File f : src.listFiles()){
					count(f);
				}
			}
		}

	}
}
