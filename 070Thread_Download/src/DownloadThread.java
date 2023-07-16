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

public class DownloadThread extends Thread{
	private String url;
	private String name;

	public DownloadThread(String url, String name){
		this.url = url;
		this.name = name;
	}
	@Override
	public void run(){
		DownloadImg DImg = new DownloadImg();
		DImg.download(url, name);
	}
	public static void main(String[] args){
		DownloadThread DT1 = new DownloadThread("https://preview.qiantucdn.com/auto_machine/20220615/9d386d86-340a-4390-92a4-45ecb31cc3b3.jpg!w1024_new_small_1","1.jpg");
		DownloadThread DT2 = new DownloadThread("https://preview.qiantucdn.com/auto_machine/20220614/cb1804c1-84c9-4033-94aa-65a0a9f416f4.jpg!w1024_new_small_1","2.jpg");
		DownloadThread DT3 = new DownloadThread("https://preview.qiantucdn.com/auto_machine/20220606/9864af49-711e-48a4-ac2c-f95f7eb569c2.jpg!w1024_new_small_1","3.jpg");
		//Launch three download image threads:
		DT1.start();
		DT2.start();
		DT3.start();
	}
}
