public class StringTest{
	public static void main(String[] args){
		String str1 = new String("abc");
		String str2 = "abc";
		String str3 = "ABC";
		String str4 = "c";
		System.out.println("If str1==str2? "+(str1==str2));
		System.out.println("If content of str1 is equal to str2? "+str1.equals(str2));
		//System.out.println(str1.charAt(0));
		System.out.println("If content of str1 is equal to str3 by ignoring case? "+str1.equalsIgnoreCase(str3));
		//System.out.println(str1.indexOf(str4));
		//System.out.println(str1.indexOf("A"));
		System.out.println("abcdefgdefg".lastIndexOf("def"));
		String str5 = "abcdbcd".replace('d', 'D');
		System.out.println(str5);
		System.out.println(str5.substring(4,5));
		System.out.println(str5.toUpperCase());
		String str6 = "   What  ?  up  ?    ";
		System.out.println(str6.trim());
	}
}
