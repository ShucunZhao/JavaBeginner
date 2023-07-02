import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest{
	public static void main(String[] args){
		Map<Integer, String> TM = new TreeMap<>();	
		TM.put(10, "aa");
		TM.put(20, "bb");
		TM.put(30, "cc");
		//TreeMap will according to the ascending order to sort key,
		//where HashMap will not.
		for(Integer k : TM.keySet()){
			System.out.println(k+":"+TM.get(k));
		}
		System.out.println("--------------------");
		Map<Emp, String> TM2 = new TreeMap<>();
		TM2.put(new Emp(1,"Frank",5000),"Boss");
		TM2.put(new Emp(2,"David",4000),"Administrator");
		TM2.put(new Emp(3,"Mandy",6000),"Founder");
		TM2.put(new Emp(4,"George",5000),"Boss");
		for(Emp e : TM2.keySet()){
			//System.out.println(e.name+":"+e.salary);
			System.out.println(e+":"+TM2.get(e));
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
