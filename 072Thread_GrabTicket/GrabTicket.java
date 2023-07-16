public class GrabTicket implements Runnable{
	private int ticketNums = 99;
	@Override
	public void run(){
		while(ticketNums>0){
			try{
				Thread.sleep(20);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" left: "+ticketNums--);
		}
	}

	public static void main(String[] args){
		//One source and multiple agent
		GrabTicket Gb = new GrabTicket();
		new Thread(Gb, "gb1").start();
		new Thread(Gb, "gb2").start();
		new Thread(Gb, "gb3").start();

	}
}
