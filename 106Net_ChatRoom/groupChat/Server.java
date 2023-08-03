/**
  * Live chatting room:
  * Add container to implement group chat.
  */
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.concurrent.CopyOnWriteArrayList;


public class Server{
	static private CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<Channel>();
	public static void main(String[] args) throws IOException{
		System.out.println("---------Server----------");
		ServerSocket server = new ServerSocket(8888);
		while(true){
			Socket client = server.accept();
			System.out.println("One client connected successfully.");
			Channel c = new Channel(client);
			all.add(c);//Use the container all to manage all members
		 	new Thread(c).start();	
		}
		//server.close();
	}
	//One client need one channel
	static class Channel implements Runnable{
		private	DataInputStream dis;	
		private	DataOutputStream dos;
		private Socket client; 
		private boolean isRun;
		private String name;
		public Channel(Socket client){
			this.client = client;
			try{
				dis = new DataInputStream(client.getInputStream()); 
			 	dos = new DataOutputStream(client.getOutputStream());
				this.isRun = true;
				this.name = receive();
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
					//send(msg);
					sendOthers(msg, false);//Send to group
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
		//Group chat need to send others:
		//Get own message and send to all member.
		private void sendOthers(String msg, boolean isSys){
			for(Channel member : all){
				if(member==this){
					continue;	
				}
				if(!isSys){
					member.send(this.name+":"+msg);
				}
				else{
					member.send("System message: "+msg);
				}
			}
		}
		//Release resource
		private void release(){
			this.isRun = false;
			Utils.close(dis,dos,client);
			all.remove(this);
			sendOthers(this.name+" left the room.", true);
		}
	}
	
}
