import java.util.Arrays;

public class UtilArraysMethod{
	public static void main(String[] args){
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		int[] b = {4,5,6,2,39,9,10};
		//System.out.println(Arrays.toString(a));
		Arrays.sort(b);
		System.out.println(Arrays.toString(b));
		int target = 5;
		System.out.println("The index of "+target+" is: "+binarySearch(b,target));
		Arrays.fill(a, 0, a.length, 100);
		System.out.println(Arrays.toString(a));
	}
	public static int binarySearch(int[] In, int target){
		int l = 0, r = 	In.length-1;
		while(l<=r){
			int m = l+(r-l)/2;
			if(In[m]>target){
				r = m-1;
			}
			else if(In[m]<target){
				l = m+1;
			}
			else{
				return m;
			}
		}
		return -1;
	}
}
