import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.InputStream;

/**
  * RandomAccessFile
  */
public class FileSplitClass{
	//Source:
	private File src;
	//Destination(directory):
	private String destDir;
	//All store paths after spliting:
	private List<String> destPaths;
	//Size of each block:
	private int blockSize;
	//The number of blocks:
	private int size;

	public FileSplitClass(String srcPath,String destDir,int blockSize){
		this.src = new File(srcPath);
		this.destDir = destDir;
		this.blockSize = blockSize;
		this.destPaths = new ArrayList<String>();

		//Initialization
		init();
	}

	private void init(){
		//Total length:
		long len = this.src.length();
		//The size of each block
		//int blockSize = 1024;
		//How many block
		this.size = (import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.InputStream;

/**
  * RandomAccessFile
  */
public class FileSplitClass{
	//Source:
	private File src;
	//Destination(directory):
	private String destDir;
	//All store paths after spliting:
	private List<String> destPaths;
	//Size of each block:
	private int blockSize;
	//The number of blocks:
	private int size;

	public FileSplitClass(String srcPath,String destDir,int blockSize){
		this.src = new File(srcPath);
		this.destDir = destDir;
		this.blockSize = blockSize;
		this.destPaths = new ArrayList<String>();

		//Initialization
		init();
	}

	private void init(){
		//Total length:
		long len = this.src.length();
		//The size of each block
		//int blockSize = 1024;
		//How many block
		this.size = (int)Math.ceil(len*1.0/blockSize);	 
		//System.out.println("size: "+size);
		//Calculate the path.
		for(int i=0;i<size;i++){
			this.destPaths.add(this.destDir+"/"+i+"-"+this.src.getName());
		}
	}

	public void split()throws IOException{
		long len = src.length();
		int beginPos = 0;
		int needSize = (int)(blockSize>len?len:blockSize);
		for(int i=0;i<size;i++){
			beginPos = i*blockSize;
			if(i==size-1){//The last block
				needSize = (int)len;	
			}
			else{
				needSize = blockSize;
				len-=needSize;
			}
			System.out.println("No."+i+" block, beginPos:"+beginPos+", actualSize:"+needSize);
			//readNeedSizeFromPos(i, beginPos, needSize, "FileSplit.java");
			splitNeedSizeFromPos(i, beginPos, needSize);
		}
	}

	public static void main(String[] args) throws IOException{
		
		//FileSplitClass fsc = new FileSplitClass("ball.png", "dest", 1024);
		FileSplitClass fsc = new FileSplitClass("FileSplitClass.java", "dest", 1024);
		fsc.split();
		fsc.merge("output.java");
		//readFromPos(2, "test1.txt");
		//readNeedSizeFromPos(2, 3, "test1.txt");
		/*
		String srcIn = "test1.txt";
		RandomAccessFile raf = new RandomAccessFile(new File(srcIn), "r");
		int beginPos = 2;//Start position
		int needSize = 3;//The actual size we need.
		//Randomly read:
		raf.seek(beginPos);//Read from position 2.
		//read.
		byte[] flush = new byte[1024];
		int len = -1;
		while((len=raf.read(flush))!=-1){
			if(needSize>len){
				System.out.println(new String(flush,0,len));
				needSize-=len;
			}
			else{
				System.out.println(new String(flush,0,needSize));
				break;
			}

		}
		raf.close();
		*/
	}
	
	private void splitNeedSizeFromPos(int i, int pos, int needSize)throws IOException{	
		RandomAccessFile raf = new RandomAccessFile(this.src, "r");
		RandomAccessFile raf2 = new RandomAccessFile(this.destPaths.get(i), "rw");	
		//int beginPos = 2;//Start position
		//int needSize = 3;//The actual size we need.
		//Randomly read:
		raf.seek(pos);//Read from position 2.
		//read.
		byte[] flush = new byte[1024];
		int len = -1;
		while((len=raf.read(flush))!=-1){
			if(needSize>len){
				System.out.println(new String(flush,0,len));
				raf2.write(flush, 0, len);
				needSize-=len;
			}
			else{
				raf2.write(flush, 0, needSize);
				System.out.println(new String(flush,0,needSize));
				break;
			}
		}
		raf.close();
		raf2.close();
	}

	//File merge.
	public void merge(String destPath)throws IOException{
		//Output stream:
		OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath, true));
		//Input stream:
		for(int i=0;i<destPaths.size();i++){
			InputStream is = new BufferedInputStream(new FileInputStream(destPaths.get(i)));
			//Operations:
			byte[] flush = new byte[1024];
			int len = -1;
			while((len=is.read(flush))!=-1){
				os.write(flush,0,len);
			}
			os.flush();
			//Close:
			is.close();
		}
		os.close();
	}

	public static void readFromPos(int pos, String srcIn)throws IOException{
		RandomAccessFile raf = new RandomAccessFile(new File(srcIn), "r");
		//Randomly read:
		raf.seek(2);//Read from position 2.
		//read.
		byte[] flush = new byte[1024];
		int len = -1;
		while((len=raf.read(flush))!=-1){
			System.out.println(new String(flush,0,len));
		}
		raf.close();

	}
	
}

