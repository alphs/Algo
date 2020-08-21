public class SimpleDataStructure {
	private String [] friends;
	private int counter;

	public static void main( String [] arg) {
		SimpleDataStructure myfriends = new
				SimpleDataStructure(); 
		myfriends.add("a");
		myfriends.add("b");
		myfriends.add("d");
		myfriends.addSort("c");
		myfriends.printFriends();

	}


	public SimpleDataStructure() {
		friends = new String[5]; 
		counter = 0;
	}


	/*Appends the other friend name to the end of this list.*/
	public boolean add(String other) {
		if(counter >= friends.length) {
			String[] a = friends.clone();
			System.arraycopy(a, 0, friends = new String[a.length*2], 0, a.length);
		}
		friends[counter] = other; 
		counter++;
		return true;
	}


	/** returns the name at the specified index*/ 
	public String get(int index) {
		if(index < friends.length) {
			return friends[index];
		}
		else {
			return null;
		}
	}



	/** removes the first occurrence of the specified element
	in this list if the list contains the name*/
	public boolean remove( String name) {
		for(int i = 0; i < counter; i++) {
			if( friends[i].equals(name)) {
				for(int k  = i; k < friends.length-1; k++) {
					friends[k] = friends[k+1];
				}
				return true;
			}
		}
		return false;
	}


	/** prints all names in the array friends*/ 
	public void printFriends() {
		for(int i = 0;i < friends.length; i++) {
			if(friends[i] != null) {
				System.out.print(friends[i] + " " );
			}
		}
		System.out.println();
	}


	public boolean addSort(String name) {
		for(int i = 0; i < friends.length; i++) {
			if(friends[i].equals(name)) {
				return false;
			}
			else {
				if(name.compareTo(friends[i]) <= 0) { 
					friends[friends.length - 1] = name;
					for(int k  = friends.length - 1; k > i; k--) {
						String temp = friends[k];
						friends[k] = friends[k-1];
						friends[k-1] = temp;
					}
					break;
				}
			}
		}
		return true;
	}	

}