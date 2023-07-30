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
	public static void main(String[] args) throws Exception{
		System.out.println("--------Client--------");
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));	
		System.out.println("Please enter user name:");
		String uname = console.readLine(); 
		System.out.println("Please enter password:");
		String upwd = console.readLine(); 
		//1.Create connection.
		Socket client = new Socket("localhost", 8888);
  		//2.IO operations.(Use data stream here)
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF("uname="+uname+"&"+"upwd="+upwd);
		dos.flush();
		//Receive the response result.
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String result = dis.readUTF();
		System.out.println("Response: "+result);
  		//3.Release resource.
		dos.close();
		client.close();
	}

}
