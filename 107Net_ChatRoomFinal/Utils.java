import java.io.Closeable;
import java.io.IOException;

public class Utils{
	public static void close(Closeable... targets){
		for(Closeable tar : targets){
			try{
				if(tar!=null){
					tar.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
