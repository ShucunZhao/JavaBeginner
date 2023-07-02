import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;

public class StoreTableByContainer{
	public static void main(String[] args){

		//Method1: Store by containers:
		//Map<String,Object> r1 = new HashMap<>();
		Map<String,Object> r1 = new TreeMap<>();
		r1.put("id", 1001);
		r1.put("name", "Frank");
		r1.put("salary", 5000);
		r1.put("entryDate", "22/05/20");
		//Map<String,Object> r2 = new HashMap<>();
		Map<String,Object> r2 = new TreeMap<>();
		r2.put("id", 1002);
		r2.put("name", "George");
		r2.put("salary", 4000);
		r2.put("entryDate", "21/03/01");
		//Map<String,Object> r3 = new HashMap<>();
		Map<String,Object> r3 = new TreeMap<>();
		r2.put("id", 1003);
		r2.put("name", "Sam");
		r2.put("salary", 3900);
		r2.put("entryDate", "22/08/31");	

		List<Map<String, Object> > table1 = new ArrayList<>();
		table1.add(r1);
		table1.add(r2);
		table1.add(r3);
		for(Map<String, Object> row : table1){
			Set<String> keySet = row.keySet();
			for(String s : keySet){
				System.out.print(s+":"+row.get(s)+"\t");
			}
			System.out.println("");
		}

		//Method2: Store by javabean object and Map:
		Emp e1 = new Emp(1001, "Frank", 5000, "22/05/20");
		Emp e2 = new Emp(1002, "George", 4000, "21/03/01");
		Emp e3 = new Emp(1003, "Sam", 3900, "22/08/31");
		List<Emp> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		for(int i=0;i<list.size();i++){
			Emp tmp = list.get(i);
			System.out.println("id:"+tmp.getId()+"\t"+"name:"+tmp.getName()+"\t"+"salary:"+tmp.getSalary()+"\t"+"entryDate:"+tmp.getEntryDate());
		}
	}
}

class Emp{
	private int id;
	private String name;
	private double salary;
	private String entryDate;

	public Emp(){}

	public Emp(int id, String name, double salary, String entryDate){
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.entryDate = entryDate;
	}

	public void setId(int In){
		this.id = In;
	}

	public int getId(){
		return this.id;
	}
		
	public void setName(String In){
		this.name = In;
	}

	public String getName(){
		return this.name;
	}

	public void setSalary(double In){
		this.salary = In;
	}

	public double getSalary(){
		return this.salary;
	}

	public void setEntryDate(String In){
		this.entryDate = In;
	}

	public String getEntryDate(){
		return this.entryDate;
	}

}
