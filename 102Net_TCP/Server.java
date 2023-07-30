/**
  * Create tcp server:
  * 1.Specify port with ServerSocket to create server.
  * 2.Waiting connect with accept in blocking way.
  * 3.IO operations.
  * 4.Release resource.
  */
import java.io.*;
import java.net.*;

public class Server{
	public static void main(String[] args) throws Exception{
		 //1.Specify port with ServerSocket to create server.
		ServerSocket server = new ServerSocket(8888); 
  		//2.Waiting connect with accept in blocking way.
		Socket client = server.accept();
		System.out.println("One client connected...");
  		//3.IO operations.
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String data = dis.readUTF();
		System.out.println(data);
  		//4.Release resource.
		dis.close();
		client.close();

		server.close();
	}

}
