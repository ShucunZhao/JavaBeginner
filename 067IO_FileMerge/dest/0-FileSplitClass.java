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
		this.size = (