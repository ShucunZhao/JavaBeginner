/**
  *	URL: United resource located symbol.
  * 1. protocol
  * 2. domain name
  * 3. port(80 by default in http)
  * 4. resource 
  * Instance: http://www.baidu.com:80/index.html?uname=frank&age=18#a 
  */

import java.net.URL;
import java.net.MalformedURLException;

public class URLTest{
	public static void main(String[] args) throws MalformedURLException{
		URL url = new URL("http://www.baidu.com:80/index.html?uname=frank&age=18#a");	
		System.out.println("Protocol: "+url.getProtocol());
		System.out.println("Domain name or ip: "+url.getHost());
		System.out.println("Request resource1: "+url.getFile());
		System.out.println("Request resource2: "+url.getPath());
		System.out.println("Port: "+url.getPort());

		//Get parameters.
		System.out.println("Parameter: "+url.getQuery());
		//Get anchor point
		System.out.println("Anchor point: "+url.getRef());

	}
}
