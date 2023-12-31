import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;

/**
  * RandomAccessFile
  */
public class FileSplit{
	public static void main(String[] args) throws IOException{
		//How many blocks we split
		String srcPath = "ball.png";
		File src = new File(srcPath);
		//Total length:
		long len = src.length();
		//The size of each block
		int blockSize = 1024;
		//How many block
		int size = (int)Math.ceil(len*1.0/blockSize);	 
		System.out.println("size: "+size);
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
			readNeedSizeFromPos(i, beginPos, needSize, srcPath);
		}
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
	
	public static void readNeedSizeFromPos(int i, int pos, int needSize, String srcIn)throws IOException{	
		RandomAccessFile raf = new RandomAccessFile(new File(srcIn), "r");
		RandomAccessFile raf2 = new RandomAccessFile(new File("dest/"+i+srcIn), "rw");	
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
