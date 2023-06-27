public class TestGeneric{
	public static void main(String[] args){
		Generic<String> strG = new Generic<>();
		System.out.println(strG.getFlag());
		strG.setFlag("Hey!");
		System.out.println(strG.getFlag());
		Generic<Integer> intG = new Generic<>();
		intG.setFlag(100);
		System.out.println(intG.getFlag());

		GenericImplement GIm = new GenericImplement();
		System.out.println(GIm.getName("Jude"));

		GenericInterface<String> GI = new GenericImplement();
		System.out.println(GI.getName("Sup"));
	}
}
