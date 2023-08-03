/**
  * Live chatting room:
  * Server-end
  * Use multithread implement multiple client send and receive msg.
  * Problem:
  * 	1.This code is uneasy to maintain.
  * 	2.Read and write in client weren't separate.
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
			new Thread(()->{
				DataInputStream dis = null;
				DataOutputStream dos = null;
				try{
					dis = new DataInputStream(client.getInputStream()); 
				 	dos = new DataOutputStream(client.getOutputStream());
				}catch(IOException e){
					e.printStackTrace();
				}
				boolean isRun = true;
				while(isRun){
					try{
						//Receive msg
						String msg = dis.readUTF();
						//Return msg
						dos.writeUTF(msg);
						dos.flush();
					}catch(IOException e){
						//e.printStackTrace();
						isRun = false;
					}
				}
				try{
					//Release resource
					if(dis!=null){	
						dis.close();
					}
					if(dos!=null){
						dos.close();
					}
					if(client!=null){
						client.close();
					}
				}catch(IOException e){
					e.printStackTrace();
				}
			}).start();
		}

		//server.close();
	}
}
