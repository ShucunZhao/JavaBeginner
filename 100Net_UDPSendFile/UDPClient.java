/**
  * UDP transfer basic data type:
  * Sender-end:
  * 1.Use DatagramSocket create sender-end and specifiy a port.
  * 2.Prepare basic data and convert to byte array form. 
  * 3.Encapsulate data into DatagramPacket package and speficy the destination.
  * 4.Send the package(non-blocking).
  * 5.Release resource
  */
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;


public class UDPClient{
	public static void main(String[] args) throws Exception{
		System.out.println("Sender-end launching...");
		//Step1:
		DatagramSocket client = new DatagramSocket(8888);
		//Step2:
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
		dos.writeUTF("You know what time it is.");
		dos.writeInt(18);
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.flush();
		//String data = "";
		//byte[] datas = data.getBytes();
		byte[] datas = baos.toByteArray();
		//Step3:
		DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
		//Step4:
		client.send(packet);
		//Step5:
		client.close();
	}
}
