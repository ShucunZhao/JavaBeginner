/**
  * Simulate login:
  * 1.Specify port with ServerSocket to create server.
  * 2.Waiting connect with accept in blocking way.
  * 3.IO operations.
  * 4.Release resource.
  */
import java.io.*;
import java.net.*;

public class ServerLogin{
	static class Channel implements Runnable{
		private Socket client;
		private DataInputStream dis;
		private DataOutputStream dos;
		public Channel(Socket client){
			this.client = client;
			try{
				dis = new DataInputStream(client.getInputStream());
				//Response result.
			 	dos = new DataOutputStream(client.getOutputStream());		
			}catch(IOException e){
				e.printStackTrace();
				release();
			}
		
		}
		@Override
		public void run(){
  			//3.IO operations.			
			String uname = "";
			String upwd = "";
			//4.Analyze data.
			String[] dataArray = receive().split("&");
			for(String info : dataArray){
				String[] userInfo = info.split("=");
				if(userInfo[0].equals("uname")){
					System.out.println("User name: "+userInfo[1]);
					uname = userInfo[1];
				}
				else if(userInfo[0].equals("upwd")){
					System.out.println("Password: "+userInfo[1]);
					upwd = userInfo[1];
				}
			}
			if(uname.equals("Frank")&&upwd.equals("123123")){
				send("Login successfully.");
			}
			else{
				send("Login failed.");
			}
  			//4.Release resource.
			release();
		}
		private String receive(){
			String datas= "";
			try{
				datas = dis.readUTF();
			}catch(IOException e){
				e.printStackTrace();
			}
			return datas;
		}
		private void send(String msg){
			try{
				dos.writeUTF(msg);
				dos.flush();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		private void release(){
  			//4.Release resource.
			try{
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
		}
	}
	public static void main(String[] args) throws Exception{
		System.out.println("--------Server----------");
		 //1.Specify port with ServerSocket to create server.
		ServerSocket server = new ServerSocket(8888); 
		boolean isRun = true;
  		//2.Waiting connect with accept in blocking way.
		while(isRun){
			Socket client = server.accept();
			System.out.println("One client connected...");
			new Thread(new Channel(client)).start();
		}
		server.close();
	}

}
