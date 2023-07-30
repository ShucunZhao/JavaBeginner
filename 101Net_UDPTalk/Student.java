public class Student{
	public static void main(String[] args){
		new Thread(new TalkSend(7777,"localhost",9999)).start();//Send	
		new	Thread(new TalkReceive(8888, "Teacher")).start();//Receive

	}
}
