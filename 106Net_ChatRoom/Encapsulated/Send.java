import java.io.*;
import java.net.*;

public class Send implements Runnable{

	private BufferedReader console;
	private DataOutputStream dos;
	private DataInputStream dis;
	private Socket client;
	private boolean isRun;

	@Override
	public void run(){	
		while(isRun){
			String msg = getMsgFromConsole();
			if(!msg.equals("")){
				send(msg);	
			}
		}
	}
	private void send(String msg){	
		try{
			//Send msg
			dos.writeUTF(msg);
			dos.flush();
		}catch(IOException e){
			//e.printStackTrace();
			release();
		}	
	}
	private String getMsgFromConsole(){
		try{
			return console.readLine();
		}catch(IOException e){
			e.printStackTrace();
		}
		return "";
	}
	public Send(Socket client){
		this.client = client;
		isRun = true;
		this.console = new BufferedReader(new InputStreamReader(System.in));
		try{
			this.dos = new DataOutputStream(client.getOutputStream());
			this.dis = new DataInputStream(client.getInputStream());
		}catch(IOException e){
			e.printStackTrace();
			release();
		}
	}
	private void release(){
		this.isRun = false;
		Utils.close(dos,dis,client);
	}
}
