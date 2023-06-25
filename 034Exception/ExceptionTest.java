public class ExceptionTest{
	public static void main(String[] args){
		System.out.println("Running step1.");
		//If we do the exception here the programme can go on safety.
		try{
			int i = 1/0;//Throw exception step.
		}catch(Exception e){//Catch exception step.
			e.printStackTrace();
		}

		System.out.println("Running step2.");
	}
}
