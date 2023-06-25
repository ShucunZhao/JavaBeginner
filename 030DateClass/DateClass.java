import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class DateClass{
	public static void main(String[] args) throws ParseException{
		Date d1 = new Date();
		System.out.println(d1);
		System.out.println(d1.getTime());
		//String and Date object convertion mutually:
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date d2 = df.parse("1971-3-10 10:40:52");
		System.out.println(d2.getTime());

		Date d3 = new Date(1000L*3600*23);
		String str = df.format(d3);
		System.out.println(str);
	}
}
