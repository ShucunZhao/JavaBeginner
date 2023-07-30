/**
  * Sender-end:
  * 1.Use DatagramSocket create sender-end and specifiy a port.
  * 2.Prepare data with byte array form. 
  * 3.Encapsulate data into DatagramPacket package and speficy the destination.
  * 4.Send the package(non-blocking).
  * 5.Release resource
  */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;


public class UDPClient{
	public static void main(String[] args) throws Exception{
		System.out.println("Sender-end launching...");
		//Step1:
		DatagramSocket client = new DatagramSocket(8888);
		//Step2:
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String data = reader.readLine();
			byte[] datas = data.getBytes();
			//Step3:
			DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
			//Step4:
			client.send(packet);
			if(data.equals("end")){
				break;
			}
		}
		//Step5:
		client.close();
	}
}
