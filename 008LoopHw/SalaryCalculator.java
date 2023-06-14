import java.util.Scanner;

public class SalaryCalculator{
	public static void main(String[] args){
		int monSalary = 0, month = 0, total = 0;
		Scanner Sc = new Scanner(System.in);
		String str = "";
		while(true){
			System.out.print("Please enter the monthly salary:\n");
			if(Sc.hasNextInt()){
				monSalary = Sc.nextInt();
			}
			else{
				str = Sc.next();
				if(str.equals("exit")){
					break;
				}
				else if(str.equals("next")){
					continue;
				}
			}
			System.out.print("Please enter how many months can get salary in one year:\n");
			if(Sc.hasNextInt()){
				month = Sc.nextInt();
			}
			else{
				str = Sc.next();
				if(str.equals("exit")){
					break;
				}
				else if(str.equals("next")){
					continue;
				}
			}
		
			total = monSalary*month;
			System.out.print("The total salary is:\n");
			System.out.println(total);
			if(total>100000&&total<=200000){
				System.out.print("Congratuations! You surpassed 90% people.\n");
			}
			else if(total>200000){
				System.out.print("Congratuations! You surpassed 98% people.\n");
			}
		}
	}
}
