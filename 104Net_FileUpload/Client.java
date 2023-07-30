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
  		//2.File upload operations.
		InputStream is = new BufferedInputStream(new FileInputStream("ball.png"));
		OutputStream os = new BufferedOutputStream(client.getOutputStream());
		byte[] flush = new byte[1024];
		int len = -1;
		while((len=is.read(flush))!=-1){
			os.write(flush, 0 ,len);
		}
		os.flush();
  		//3.Release resource.
		os.close();
		is.close();
		client.close();
	}

}
