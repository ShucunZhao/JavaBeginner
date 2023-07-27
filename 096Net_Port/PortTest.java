/**
  * Port:
  * Use for distinguish the applications.
  * Size: 2 bytes, 0-65535.
  * Same port cannot use in same protocol like UDP, TCP.
  */

import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class PortTest{
	public static void main(String[] args){
		InetSocketAddress socketAddr = new InetSocketAddress("127.0.0.1", 8080);
		InetSocketAddress socketAddr2 = new InetSocketAddress("localhost", 9000);
		System.out.println(socketAddr.getHostName());
		System.out.println(socketAddr2.getAddress());
	}
}
