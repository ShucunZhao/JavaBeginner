/**
  * Create tcp client:
  * 1.Use Socket to create client and set up connection:
  *   Specify the address and port of server.
  * 2.IO operations.
  * 3.Release resource.
  */
import java.io.*;
import java.net.*;

public class Client{
	public static void main(String[] args) throws Exception{
		 //1.Create connection.
		Socket client = new Socket("localhost", 8888);
  		//2.IO operations.(Use data stream here)
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		String data = "Hello";
		dos.writeUTF(data);
		dos.flush();
  		//3.Release resource.
		dos.close();
		client.close();
	}

}
