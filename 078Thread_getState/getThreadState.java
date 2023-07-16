import java.lang.Thread.State;

public class getThreadState{
	public static void main(String[] args){
		Thread t = new Thread(()->{
			for(int i=0;i<10;i++){
				try{
					Thread.sleep(100);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				System.out.println(".......");	
			}
		});
		//Peek the state of thread:
		State s1 = t.getState();
		System.out.println(s1);//NEW state.
	
		t.start();
		State s2 = t.getState();
		System.out.println(s2);//RUNNABLE.

		while(t.getState()!=Thread.State.TERMINATED){
			State s3 = t.getState();
			System.out.println(s3);//TIMED_WAITING
			try{
				Thread.sleep(200);
			}catch(InterruptedException e){
				e.printStackTrace();
			}		
		}

		State s4 = t.getState();
		System.out.println(s4);//TERMINATED
	}
}
