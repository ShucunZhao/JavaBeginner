int)Math.ceil(len*1.0/blockSize);	 
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
		//rea