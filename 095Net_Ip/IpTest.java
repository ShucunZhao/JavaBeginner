/**
  * IP: Locate one node which including computer, router and communication device.
  * InetAddress class in java.
  */
import java.net.InetAddress;
import java.net.UnknownHostException;


public class IpTest{
	public static void main(String[] args) throws UnknownHostException{
		//Creat host InetAddress object to get host ip address:
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println("Host ip address: "+addr.getHostAddress());
		System.out.println("Host name: "+addr.getHostName());

		//Get ip by domain name:
		String DN = "www.163.com";
		addr = InetAddress.getByName(DN);
		System.out.println(DN+" ip address: "+addr.getHostAddress());
		System.out.println(DN+" name: "+addr.getHostName());
	
	}
}
