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
  		//3.File copy(download) operations.
		InputStream is = new BufferedInputStream(client.getInputStream());
		OutputStream os = new BufferedOutputStream(new FileOutputStream("tcp.png"));
		byte[] flush = new byte[1024];
		int len = -1;
		while((len=is.read(flush))!=-1){
			os.write(flush, 0 ,len);
		}
		os.flush();
		//4.Release resource.
		os.close();
		is.close();
		client.close();

		server.close();
	}

}
