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
				//Welcome msg:
				this.send("Welcome to chat room.");
				//System reminder meg:
				this.sendOthers(this.name+" enter the chat room.", true);
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
		//Add a private chat function here, the data
		//form is: @xxx:msg
		private void sendOthers(String msg, boolean isSys){
			boolean isPrivate = msg.startsWith("@");
			if(isPrivate){
				//if is private chat, get the send target and msg data:
				int index = msg.indexOf(":");
				String targetName = msg.substring(1,index);//From after @ to :.
				msg = msg.substring(index+1);
				for(Channel member : all){
					if(member.name.equals(targetName)){
						member.send("Private message from "+this.name+" :"+msg);
						break;
					}
				}
			}
			else{
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
