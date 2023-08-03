/**
  * Live chatting room:
  * Server-end
  * Use multithread implement multiple client send and receive msg.
  * Implement with a encapsulated way.
  */
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class Server{
	public static void main(String[] args) throws IOException{
		System.out.println("---------Server----------");
		ServerSocket server = new ServerSocket(8888);
		while(true){
			Socket client = server.accept();
			System.out.println("One client connected successfully.");
		 	new Thread(new Channel(client)).start();	
		}
		//server.close();
	}
	//One client need one channel
	static class Channel implements Runnable{
		private	DataInputStream dis;	
		private	DataOutputStream dos;
		private Socket client; 
		boolean isRun;
		public Channel(Socket client){
			this.client = client;
			try{
				dis = new DataInputStream(client.getInputStream()); 
			 	dos = new DataOutputStream(client.getOutputStream());
				this.isRun = true;
			}catch(IOException e){
				//e.printStackTrace();
				release();
			}
		}
		@Override
		public void run(){
			while(isRun){
				String msg = receive();
				if(!msg.equals("")){
					send(msg);
				}
			}
		}
		//Receive msg
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
		//Send msg
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
		//Release resource
		private void release(){
			this.isRun = false;
			Utils.close(dis,dos,client);
		}
	}
	
}
