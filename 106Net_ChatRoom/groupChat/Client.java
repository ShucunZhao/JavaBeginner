/**
  * Live chatting room:
  * Server-end
  * Add container to implement group chat.
  */
import java.net.Socket;
import java.io.*;

public class Client{
	public static void main(String[] args) throws IOException{
		System.out.println("--------Client---------");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter your user name:");
		String name = br.readLine();
		//1.Create connection
		Socket client = new Socket("localhost", 8888);
		new Thread(new Send(client, name)).start();
		new Thread(new Receive(client)).start();
		//client.close();
	}
}
