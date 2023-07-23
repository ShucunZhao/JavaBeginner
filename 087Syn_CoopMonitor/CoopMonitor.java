/**
  * Producer and consumer cooperation mode:
  * 1.Monitor mode:
  *   Include producer, consumer, buffer, product.
  */

public class CoopMonitor{
	public static void main(String[] args){
		Buffer buf = new Buffer();
		new Producer(buf).start();
		new Consumer(buf).start();
	}
}

class Producer extends Thread{
	Buffer buf;
	public Producer(Buffer buf){
		this.buf = buf;
	}
	@Override
	public void run(){
		//Producing:
		for(int i=0;i<100;i++){
			System.out.println("Produce -->No."+i+" product.");	
			buf.push(new Product(i));
		}
	}
}

class Consumer extends Thread{
	Buffer buf;
	public Consumer(Buffer buf){
		this.buf = buf;
	}

	@Override
	public void run(){
		//Consuming:
		for(int i=0;i<100;i++){
			System.out.println("Consume -->No."+buf.pop().id+" product.");	
		}
	
	}
}

class Buffer{
	Product[] pros = new Product[10];//Size of buffer is 10.
	int cnt = 0;//Counter.
	//Store:
	public synchronized void push(Product In){
		if(cnt==pros.length){
			try{
				this.wait();//This will block the thread until the consumer notify it.
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		
		}
		pros[cnt] = In;
		cnt++;
		this.notifyAll();//Notify thera has product to consume.
	}
	//Get:
	public synchronized Product pop(){
		if(cnt==0){//If the buffer is empty, just waiting.
			try{
				this.wait();//This will block the thread until the produce notify it.
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		cnt--;
		Product out = pros[cnt];
		this.notifyAll();//Notify here which means there has space in buffer.
		return out;
	}
}

class Product{
	int id;
	public Product(int id){
		this.id = id;
	}
}



