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
	public static void main(String[] args) throws Exception{
		System.out.println("--------Server----------");
		 //1.Specify port with ServerSocket to create server.
		ServerSocket server = new ServerSocket(8888); 
  		//2.Waiting connect with accept in blocking way.
		Socket client = server.accept();
		System.out.println("One client connected...");
  		//3.IO operations.
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String datas = dis.readUTF();
		String uname = "";
		String upwd = "";
		//4.Analyze data.
		String[] dataArray = datas.split("&");
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
		//Response result.
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		if(uname.equals("Frank")&&upwd.equals("123123")){
			dos.writeUTF("Login successfully.");
		}
		else{
			dos.writeUTF("Login failed.");
		}
  		//4.Release resource.
		dis.close();
		client.close();

		server.close();
	}

}
