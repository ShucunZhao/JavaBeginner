/**
  *	Implement my own ArrayList.
  * @author SC
  */
public class ArrayListImplement<E>{
	private Object[] elemData;
	private int size = 0;
	private final int DEFAULT_CAPACITY = 10;
	public ArrayListImplement(){
		elemData = new Object[DEFAULT_CAPACITY];
	}
	public ArrayListImplement(int In){
		if(In<=0){
			throw new RuntimeException("Invalid input size:"+In);
		}
		elemData = new Object[In];
	}
	public static void main(String[] args){
		ArrayListImplement<String> myAL = new ArrayListImplement<>();	
		
		for(int i=0;i<10;i++){
			myAL.add("a");
		}
		
		myAL.add("aa");
		myAL.add("bb");
		System.out.println(myAL);
		System.out.println("-----------------");
		System.out.println("Size: "+myAL.size());
		myAL.set("c", myAL.size()-2);
		System.out.println(myAL);
		System.out.println("-----------------");
		myAL.remove("a");
		System.out.println(myAL);
		myAL.remove(myAL.size()-1);
		System.out.println(myAL);
		System.out.println("Is empty: "+myAL.isEmpty());
		//System.out.println()
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		//for(Object obj : elemData){
		for(int i=0;i<size;i++){
			sb.append(elemData[i]+",");
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}

	public E get(int i){
		if(i<0||i>=size){
			throw new RuntimeException("Invalid index:"+size);	
		}
		return (E)elemData[i];
	}

	public void set(E In, int i){
		if(i<0||i>=size){
			throw new RuntimeException("Invalid index:"+size);
		}
		elemData[i] = In;
	}

	public void add(E obj){
		if(size>=elemData.length){//This is used for array extension.
			Object[] newArray = new Object[elemData.length+(elemData.length>>1)];//Extend to plus half of original length.
			//System.out.println("New size: "+newArray.length);
			//System.out.println("Address of newArray: "+newArray);
			System.arraycopy(elemData,0,newArray,0,elemData.length);
			//System.out.println("Address of elemData(before): "+elemData);
			elemData = newArray;
			//System.out.println("Address of elemData(after): "+elemData);
		}
		
		elemData[size++] = obj;
	}

	public boolean isEmpty(){
		return size==0;
	}

	public void remove(E In){
		for(int i=0;i<size;i++){
			if(get(i).equals(In)){
				remove(i);
				break;
			}
		}
	}

	public void remove(int i){
		if(i<0||i>=size){
			throw new RuntimeException("Invalid index:"+size);
		}
		int validLength = elemData.length-i-1; 
		if(validLength>0){
			System.arraycopy(elemData,i+1,elemData,i,validLength);
		}
		elemData[size-1] = null;
		size--;
	} 

	//@Override
	public int size(){
		return this.size;
	}
}
