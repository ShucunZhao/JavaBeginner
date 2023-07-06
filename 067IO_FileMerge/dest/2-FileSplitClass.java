dNeedSizeFromPos(2, 3, "test1.txt");
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
		while((l