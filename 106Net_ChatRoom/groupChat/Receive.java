import java.io.*;
import java.net.*;

public class Receive implements Runnable{
	private DataInputStream dis;
	private Socket client;
	private boolean isRun;
	public Receive(Socket client){
		this.client = client;
		isRun = true;
		try{
			this.dis = new DataInputStream(client.getInputStream());
		}catch(IOException e){
			e.printStackTrace();
			release();
		}

	}
	private String receive(){
		String msg = "";
		try{
			//Receive msg
			msg = dis.readUTF();
		}catch(IOException e){
			//e.printStackTrace();
			release();
		}	
		//Return ms
		return msg;
	}
	@Override
	public void run(){
		while(isRun){
			String msg = receive();
			if(!msg.equals("")){
				System.out.println(msg);
			}
		}
	}
	private void release(){
		this.isRun = true;
		Utils.close(dis,client);
	}
}
