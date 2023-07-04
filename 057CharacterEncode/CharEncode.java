import java.io.UnsupportedEncodingException;

public class CharEncode{
	public static void main(String[] args){
		//Characters encoding:
		//String msg = "You know what time it is.";
		String msg = "你Deng懂我意思吗？";
		//Use byte array to save encoded result.
		byte[] datas = msg.getBytes();//Default character set is same as project.
		System.out.println("Default set length: "+datas.length);
		//Others sets:
		try{
			datas = msg.getBytes("UTF-16LE");
			System.out.println("UTF-16LE length: "+datas.length);
		}catch(UnsupportedEncodingException e){
			System.out.println("Unsupported encoding: "+e.getMessage());	
		}
		try{
			datas = msg.getBytes("GBK");
			System.out.println("GBK length: "+datas.length);
		}catch(UnsupportedEncodingException e){
			System.out.println("Unsupported encoding: "+e.getMessage());
		}
		try{
			datas = msg.getBytes("UTF-8");
			System.out.println("UTF-8 length: "+datas.length);
		}catch(UnsupportedEncodingException e){
			System.out.println("Unsupported encoding: "+e.getMessage());
		}	
		/*
		try{
			datas = msg.getBytes("Unknown");
			System.out.println("Unkonwn length: "+datas.length);
		}catch(UnsupportedEncodingException e){
			System.out.println("Unsupported encoding: "+e.getMessage());
		}	
		*/
		//Characer decoding:
		//String(byre[] bytes, int offset, int length, String charsetName)
		try{
			String decoded = new String(datas, 0, datas.length, "utf8");
			System.out.println("Decode by utf8: "+decoded);
		}catch(UnsupportedEncodingException e){
			System.out.println("Unsupported encoding: "+e.getMessage());
		}
		try{
			String decoded = new String(datas, 0, datas.length, "gbk");
			System.out.println("Decode by gbk: "+decoded);
		}catch(UnsupportedEncodingException e){
			System.out.println("Unsupported encoding: "+e.getMessage());
		}
	}
}
