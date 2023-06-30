public class HashMapImplement<K,V>{
	HashNode[] table;//Bucket array.
	private int size = 0;//The number of <k,v> pairs.
	
	public HashMapImplement(){
		table = new HashNode[16];//The length should be integer power of 2.
	}

	public int size(){
		return this.size;
	}

	public V get(K inKey){
		/*	
		//Do not use this traverse all node method, just find the representive hash value of input key, then traverse that node.
		if(size==0){
			return null;
		}
		for(int i=0;i<table.length;i++){
			HashNode cur = table[i];
			while(cur!=null){
				if(cur.key.equals(inKey)){
					return cur.value;
				}
				cur = cur.next;
			}
		}
		*/
		
		int hash = myHashCal(inKey.hashCode(), table.length);
		//Object ans = null;
		if(table[hash]!=null){
			HashNode cur = table[hash];
			while(cur!=null){
				if(cur.key.equals(inKey)){
					return (V)cur.value;
				}
				cur = cur.next;
			}
		}		
		return null;
	}

	public void put(K key, V value){
		/*Step1: define a new node.*/
		HashNode<K,V> newNode = new HashNode<>();
		newNode.hash = myHashCal(key.hashCode(), table.length);
		newNode.key = key;
		newNode.value = value;
		/*According to hash value of node to put it into right position in table array.*/
		HashNode tmp = table[newNode.hash];
		if(tmp==null){
			table[newNode.hash] = newNode;
			size++;
		}
		else{
			//If the key exists, override it.
			boolean exist = false;
			//If it's a new key, add it to last node of list.
			//System.out.println("new key: "+newNode.key);
			if(tmp.key.equals(newNode.key)){
				exist = true;
			}
			while(!exist&&tmp.next!=null){
				if(tmp.key.equals(newNode.key)){
					exist = true;
				}
				tmp = tmp.next;
			}
			System.out.println("Key exist: "+exist);
			if(exist){
				tmp.value = newNode.value;//Only change the value, the hash,key and next remain.
			}
			else{
				tmp.next = newNode;
				size++;
			}
		}
	}

	public static int myHashCal(int val, int len){
		//val is the hash code of key.
		//lem must be integer power of 2.
		//System.out.println("Hash value of my Hash method: "+(val&(len-1)));//Do the bit operation will be more effective.
		//System.out.println("Hash value of my Hash method: "+(val%(len-1)));//Same effect as & opt but less efficient, but value is not the same.	
		return val&(len-1);
	}

	@Override
	public String toString(){
		//Format: {10:aa, 20:bb}
		StringBuilder sb = new StringBuilder();
		if(size==0) return sb.toString();
		sb.append("{");
		for(int i=0;i<table.length;i++){
			HashNode cur = table[i];
			while(cur!=null){
				sb.append(cur.key+":"+cur.value+",");
				cur = cur.next;
			}
		}
		sb.setCharAt(sb.length()-1, '}');
		return sb.toString();
	}

	public static void main(String[] args){
		HashMapImplement<Integer, String> myHM = new HashMapImplement<>();
		myHM.put(10, "aa");
		myHM.put(20, "aa");
		myHM.put(30, "aa");
		myHM.put(10, "cc");
		/*
		for(int i=10;i<100;i++){
			
		}
		*/
		//The 10, 26 and 42 has same hash value:
		myHM.put(26, "aa");
		myHM.put(42, "cc");
		System.out.println("Size of myHM: "+myHM.size());
		System.out.println("---------------------");
		System.out.println(myHM);
		System.out.println("---------------------");
		System.out.println(myHM.get(10));
		System.out.println(myHM.get(20));
		System.out.println(myHM.get(30));
		System.out.println(myHM.get(26));
		System.out.println(myHM.get(42));
		System.out.println(myHM.get(0));
	}
}


