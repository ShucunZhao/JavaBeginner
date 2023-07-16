package src;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

class DownloadImg extends Thread{
	
	public void download(String url, String name){
		try{
			FileUtils.copyURLToFile(new URL(url), new File(name));//This is api in Commons IO framework.	
		}catch(MalformedURLException e){
			e.printStackTrace();
			System.out.println("Invalid URL.");
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("Failed to load img.");
		}

	}
}
