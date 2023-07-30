/**
  *	Receive-end
  */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class TalkReceive implements Runnable{
	private DatagramSocket server;
	private String from;
	public TalkReceive(int port, String from){
		this.from = from;
		try{
			server = new DatagramSocket(port);
		}catch(SocketException e){
			e.printStackTrace();
		}
	
	}
	@Override
	public void run(){
		while(true){
			//Step2:
			byte[] container = new byte[1024*60];
			DatagramPacket packet = new DatagramPacket(container, 0, container.length);
			try{
				//Step3:
				server.receive(packet);//This will blcoking here.
				//Step4: 
				byte[] datas = packet.getData();
				int len = packet.getLength();
				String data = new String(datas, 0, len);
				System.out.println("From "+from+" : "+data);
				if(data.equals("end")){
					break;
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		//Step5:
		server.close();	
	}
}
