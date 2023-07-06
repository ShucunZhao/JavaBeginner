ead.
		byte[] flush = new byte[1024];
		int len = -1;
		while((len=raf.read(flush))!=-1){
			System.out.println(new String(flush,0,len));
		}
		raf.close();

	}
	
}

