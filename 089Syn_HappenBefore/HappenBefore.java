public class HappenBefore{
	
	private static int a = 0;
	private static boolean flag = false;
	public static void main(String[] args) throws InterruptedException{
		for(int i=0;i<100;i++){
			a = 0;
			flag = false;
			//Change data.
			Thread t1 = new Thread(()->{
				a = 1;
				flag = true;
			});
			//Read data.
			Thread t2 = new Thread(()->{
				if(flag){
					a*=1;
				}	
				if(a==0){
					System.out.println("Happen before...-->a: "+a);
				}
			});
			t1.start();
			t2.start();
			t1.join();
			t2.join();
		}
	}
}
