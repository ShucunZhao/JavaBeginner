/**
  * Receiver-end:
  * 1.Use DatagramSocket create receiver-end and specifiy a port.
  * 2.Prepare container and encapsulate into DatagramPacket package.
  * 3.Receive the package with blocking way.
  * 4.Analyze data:
  * 	byte[] getData(), getLength()
  * 5.Release resource
  */

import java.net.DatagramSocket;
import java.net.DatagramPacket;


public class UDPServer{
	public static void main(String[] args) throws Exception{
		System.out.println("Receiver-end launching...");
		//Step1:
		DatagramSocket server = new DatagramSocket(9999);
		//Step2:
		byte[] container = new byte[1024*60];
		DatagramPacket packet = new DatagramPacket(container, 0, container.length);
		//Step3:
		server.receive(packet);//This will blcoking here.
		//Step4: 
		byte[] datas = packet.getData();
		int len = packet.getLength();
		System.out.println(new String(datas, 0, len));
		//Step5:
		server.close();
	}
}
