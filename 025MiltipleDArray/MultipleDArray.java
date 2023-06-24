import java.util.Arrays;
public class MultipleDArray{
	public static void main(String[] args){
		int[][] matrix = new int[3][3];
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.println(matrix[i][j]);
			}
		}
		//Object: id, name, age, job, entry date.
		Object[] o1 = {1, "Frank", 20, "Front-end", "05/06/22"};
		Object[] o2 = {1, "Eric", 20, "Back-end", "05/06/22"};
		Object[] o3 = {1, "David", 20, "Testing", "05/06/22"};
		Object[][] oSet = new Object[3][];
		oSet[0] = o1;
		oSet[1] = o2;
		oSet[2] = o3;
		for(int i=0;i<oSet.length;i++){
		//	for(int j=0;j<oSet[0].length;j++){
				//System.out.print(oSet[i][j]+",");
			System.out.println(Arrays.toString(oSet[i]));
		//	}
	//		System.out.println("");
		}
		Employee[] Emp = new Employee[]{
			new Employee(1, "Frank", 20, "Front-end", "05/06/22"),
			new Employee(1, "Eric", 20, "Back-end", "05/06/22"),
		  	new Employee(1, "Eric", 20, "Back-end", "05/06/22")
		};
		for(Employee emp : Emp){
			System.out.println(emp.toString());	
		}
	}
}

class Employee{
	private int id;
	private String name;
	private int age;
	private String job;
	private String entryDate;
	public Employee(){}
	public Employee(int id, String name, int age, String job, String date){
		this.id = id;
		this.name = name;
		this.age = age;
		this.job = job;
		this.entryDate = date;
	}
	public void setId(int In){
		this.id = In;
	}
	public void setName(String In){
		this.name = In;
	}
	public void setAge(int In){
		this.age = In;
	}
	public void setJob(String In){
		this.job = In;
	}
	public void setEntryDate(String In){
		this.entryDate = In;
	}
	public int getId(){
		return this.id;
	}
	public String getName(){
		return this.name;	
	}
	public int getAge(){
		return this.age;
	}
	public String getJob(){
		return this.job;
	}
	public String getEntryDate(){
		return this.entryDate;
	}
	
	@Override
	public String toString(){
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", job=" + job + ", entryDate=" + entryDate + "]";
	}
	
}
