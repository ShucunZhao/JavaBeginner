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
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		DataInputStream dis = new DataInputStream(client.getInputStream());	
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		boolean isRun = true;
		//2.Send msg
		while(isRun){
			String msg = console.readLine();
			dos.writeUTF(msg);
			dos.flush();
			//3.Get return msg and output
			msg = dis.readUTF();
			System.out.println(msg);
		}
		//Release resource
		dos.close();
		dis.close();
		client.close();
	}
}
