/**
  * Simulate login:
  * 1.Use Socket to create client and set up connection:
  *   Specify the address and port of server.
  * 2.IO operations.
  * 3.Release resource.
  */
import java.io.*;
import java.net.*;

public class ClientLogin{
	
	static class Send{
		//1.Create connection.
		Socket client;// 	
	 	//2.IO operations.(Use data stream here)
		private DataOutputStream dos;
	  	private BufferedReader console;
		private String msg;
		public Send(Socket client){
			this.client = client;
			try{
				dos = new DataOutputStream(client.getOutputStream());
			}catch(IOException e){
				e.printStackTrace();
			}
			this.msg = init();
		}
		private String init(){
			console = new BufferedReader(new InputStreamReader(System.in));
			try{
				System.out.println("Please enter user name:");
				String uname = console.readLine(); 
				System.out.println("Please enter password:");
				String upwd = console.readLine(); 	
				return "uname="+uname+"&"+"upwd="+upwd; 
			}catch(IOException e){
				e.printStackTrace();
			}
			return "";
		}
 		public void send(){
			try{
	  			dos.writeUTF(msg);
				dos.flush();
			}catch(IOException e){
				e.printStackTrace();
			}
			try{
				dos.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}

	static class Receive{
		private DataInputStream dis; 
		private Socket client;
		public Receive(Socket client){
			this.client = client;
			try{
				dis = new DataInputStream(client.getInputStream());
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		public void receive(){
			//Receive the response result.
			String result = "";
			try{
				result = dis.readUTF();
			}catch(IOException e){
				e.printStackTrace();
			}
			System.out.println("Response: "+result);
		}
	} 

	public static void main(String[] args) throws Exception{
		System.out.println("--------Client--------");
		//Create socket client
		Socket client = new Socket("localhost", 8888);
		//IO operations
		new Send(client).send();
		new Receive(client).receive();
  		//3.Release resource.
		client.close();
	}

}
