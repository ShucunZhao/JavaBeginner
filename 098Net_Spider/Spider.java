/**
  * Web spider.
  */

import java.net.URL;
import java.net.MalformedURLException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class Spider{
	public static void main(String[] args) throws Exception{
		//Get URL
		//URL url = new URL("https://www.jd.com");
		URL url = new URL("https://www.dianping.com");
		//Simulate browser to get protected resource
		HttpURLConnection conn = (HttpURLConnection)url.openConnection(); 
		conn.setRequestMethod("GET");
		conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));	
		//Download resource
		InputStream is = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String msg = null;
		while((msg=br.readLine())!=null){
			System.out.println(msg);
		}
		br.close();
		System.out.println("------------------------------------------------------------------");
		while((msg=br2.readLine())!=null){
			System.out.println(msg);
		}
		br2.close();

		//Analyze
		//Operation
	}
}
