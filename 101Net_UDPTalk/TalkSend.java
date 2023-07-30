/**
  * Send-end.
  */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TalkSend implements Runnable{
	private DatagramSocket client;
	private BufferedReader reader;
	private String destIp;
	private int destPort;
	public TalkSend(int port, String destIp, int destPort){
		this.destIp = destIp;
		this.destPort = destPort;
		try{
			client = new DatagramSocket(port);
			reader = new BufferedReader(new InputStreamReader(System.in));
		}catch(SocketException e){
			e.printStackTrace();
		}
	}
	@Override
	public void run(){
		while(true){
			String data;
			try{
				data = reader.readLine();
				byte[] datas = data.getBytes();
				//Step3:
				DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress(this.destIp, this.destPort));
				//Step4:
				client.send(packet);
				if(data.equals("end")){
					break;
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		//Step5:
		client.close();	
	}
} 
