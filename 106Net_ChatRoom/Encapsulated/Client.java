/**
  * Live chatting room:
  * Server-end
  */
import java.net.Socket;
import java.io.*;

public class Client{
	public static void main(String[] args) throws IOException{
		System.out.println("--------Client---------");
		//1.Create connection
		Socket client = new Socket("localhost", 8888);
		new Thread(new Send(client)).start();
		new Thread(new Receive(client)).start();
		//client.close();
	}
}
