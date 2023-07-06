en=raf.read(flush))!=-1){
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
		//r