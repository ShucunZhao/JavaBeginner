import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest{
	public static void main(String[] args){
		Set<Integer> tset = new TreeSet<>();
		tset.add(16);
		tset.add(20);
		tset.add(10);
		tset.add(15);
		for(Integer i : tset){//Ascending order.
			System.out.println(i);
		}
		Set<Emp> tset2 = new TreeSet<>();
		tset2.add(new Emp(3,"Sam",3000));
		tset2.add(new Emp(2,"Sam",3100));
	 	tset2.add(new Emp(1,"Sam",3200));
		for(Emp e : tset2){
			System.out.println(e);
		}
	}
}

class Emp implements Comparable<Emp>{
	int id; 
	String name;
	double salary;

	public Emp(int id, String name, double salary){
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString(){
		return "id:"+id+",name:"+name+",salray:"+salary;
	}

	@Override
	public int compareTo(Emp O){
	/**
	  * Compare this object with the specific input object, 
	  * if less than: return -1,
	  * if equal: return 0,
	  * if greater than: return 1.
	  */
		if(this.salary>O.salary){
			return 1;
		}
		else if(this.salary<O.salary){
			return -1;
		}
		else{//If the salary is same, we use id to sort.
			if(this.id>O.id){
				return 1;
			}
			else if(this.id<O.id){
				return -1;
			}
			return 0;
		}
		//return 0;
	}
}
