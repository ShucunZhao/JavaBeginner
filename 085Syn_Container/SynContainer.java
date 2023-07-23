import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;//

public class SynContainer{
	public static void main(String[] args){
		//Default available seats:
		CopyOnWriteArrayList<Integer> available = new CopyOnWriteArrayList<>();
		for(int i=0;i<5;i++){
			available.add(i);
		}
		CopyOnWriteArrayList<Integer> seats1 = new CopyOnWriteArrayList<>();
		seats1.add(1);
		seats1.add(2);
		CopyOnWriteArrayList<Integer> seats2 = new CopyOnWriteArrayList<>();
		seats2.add(4);
		seats2.add(5);
		seats2.add(6);

		Ticket t1 = new Ticket(available, "T1");
		new Thread(new Customer(t1, seats1), "Joker").start();
		new Thread(new Customer(t1, seats2), "Alice").start();
	}
}

class Customer implements Runnable{
	Ticket ticket;
	CopyOnWriteArrayList<Integer> seats;
	public Customer(Ticket ticket, CopyOnWriteArrayList<Integer> seats){
		this.ticket = ticket;
		this.seats = seats;
	}
	@Override
	public void run(){
		boolean flag = ticket.ifBook(seats);
		if(flag){
			System.out.println("Booked successfully "+Thread.currentThread().getName()+"-<total seats: "+seats);
		}
		else{
			System.out.println("Failed to book "+Thread.currentThread().getName()+"-<seats were not enough");

		}
	}
}

class Ticket{
	CopyOnWriteArrayList<Integer> available;
	String name;	
	public Ticket(CopyOnWriteArrayList<Integer> available, String name){
		this.available = available;
		this.name = name;
	}
	public boolean ifBook(CopyOnWriteArrayList<Integer> seats){
		//synchronized(this){	
		System.out.println("Available seats: "+available);
		CopyOnWriteArrayList<Integer> copy = new CopyOnWriteArrayList<Integer>();
		copy.addAll(available);//Deep copy.
		//Detract:
		copy.removeAll(seats);
		//Compare:
		if(available.size()-copy.size()!=seats.size()){
			return false;
		}
		available = copy;
		return true;
		//}
	}
} 
