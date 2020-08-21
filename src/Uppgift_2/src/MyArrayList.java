import java.util.*;

public class MyArrayList<AnyType> implements Iterable<AnyType> {
	private AnyType[] list;
	private int count;


	@SuppressWarnings("unchecked")
	public MyArrayList(){
		list = (AnyType[]) new Object[10];
		count=0;
	}


	@SuppressWarnings("unchecked")
	public MyArrayList(int initialCapacity){
		list = (AnyType[]) new Object[initialCapacity];
	}

	/*Appends the specified element to the end of this list.*/

	@SuppressWarnings("unchecked")
	public boolean add(AnyType o){  	//clones the array, doubles it and writes the previous values to the new array.
		if(count >= list.length) {
			AnyType[] a = list.clone();
			System.arraycopy(a, 0, list = (AnyType[]) new Object[a.length*2], 0, a.length);
		}
		if(o == null) {
			return false;
		}
		else {
			list[count] = o; 
			count++;
			return true;
		}
	}


	/** tests if the specified element is a component of this list*/
	public boolean contains(AnyType o){
		for(int i = 0; i < list.length; i++) {
			if(list[i] != null) {
				if(list[i].equals(o)) {
					return true;
				}
			}
		}

		return false;
	}


	/** returns the component at the specified index*/
	public AnyType get(int index){
		if(index > count-1 || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else {
			return list[index];
		}
	}


	/** Search for the first occurrence of the given argument testing for the equality using
	equals method*/
	public int indexOf(AnyType o){
		if(list != null) {
			for(int i = 0; i < count; i++) {
				if(list[i].equals(o)) {
					return i;
				}
			}
		}
		return -1;
	}


	/** tests if this list has no components*/
	public boolean isEmpty(){
		return count == 0;
	}


	/** removes the first occurrence of the specified element in this list
	if the list contains the */
	public boolean remove(AnyType o){
		for(int i = 0; i < count; i++) {
			if(list[i].equals(o)) {
				for(int k  = i; k < list.length-1; k++) {
					list[k] = list[k+1];
				}
				count--;
				return true;

			}
		}
		return false;		
	}


	/** returns the number of components in this list*/
	public int size(){
		if(list == null) {
			return -1;
		}
		else {
			return count;
		}
	}


	/** returns an array containing all elements in this list in the correct order*/
	public Object[] toArray(){
		if(count == 0) {
			return null;
		}
		return list;
	}


	/** return object ArayListIterator */
	public Iterator<AnyType> iterator(){
		ArrayListIterator<AnyType> itr = new ArrayListIterator<AnyType>(list, count);
		return itr;
	}
	
	public String toString() {
		String string = "";
		for(int i = 0; i < list.length; i++) {
			string = string + list[i];
		}
		return string;
	}
	

}