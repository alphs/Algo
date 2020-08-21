package Uppgift_3;

/**
 * Klassen SimpleLinkedList �r en l�nkad lista som inneh�ller noder av objekt.
 * F�rsta noden i listan inneh�ller inget objekt.
 */

public class SimpleLinkedList {
	private final ListNode header;
	private int count = 0;
	
	private SimpleLinkedList() {
		header = new ListNode( null );
	}

	/**
	 * Skapar en ny ListNode  med ett nytt objekt och l�gger den i listan
	 */
	private void insert(String theobj) {
		ListNode nynode = new ListNode(theobj);
		ListNode temp = header;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = nynode;
		count++;
	}


	/* Ta bort noden som inneh�ller respektive objekt */
	public void remove(String theobj) {
		ListNode node = header;
		while(node.next != null){
			if(node.next.element.equals(theobj)){
				node.next = node.next.next;
				break;
			}
			node = node.next;
		}
		count--;
	}

	/**
    Skriver ut inneh�llet i listan
	 */
	private void print() {
		ListNode node = header.next;
		while(node != null){
			System.out.println(node.element);
			node = node.next;
		}
	}   

	
	public void insert2(String theobj ) {
		header.next = new ListNode(theobj, header.next);
		count++;
	}

	
	// Detta skall du g?ra 
	private void insert(String obj, int index) {
		if(index <= count) {
			if(index >= 0) {
				ListNode abc = header;
				for(int i = 0; i < index; i++) {
					abc = abc.next;
				}
				abc.next = new ListNode(obj, abc.next);
				count++;
			}
			else {
				
				System.out.println("Index out of bounds");
			}
		}
	}

	
	// Returnerar och tar bort ett objkt fr�n lista
	private String remove(String obj, int index) {
		ListNode abc = header;
		ListNode aaa = new ListNode("");
		for(int i = 0; i < index; i++) {
			abc = abc.next;
		}
		if(abc.next.element.equals(obj)) {
			aaa = abc.next;
			abc.next = abc.next.next;
			count--;
			return aaa.element + " has been removed";
		}
		return ("obj doesn't exist");
	}

	//returnerar storleken p� listan. L�gg till i klasssen  en variabel f�r detta
	// uppdatera variabeln n�r det �r fallet

	private int size() {
		return count;
	} 

	
	public String toString() {
		StringBuilder temp = new StringBuilder("[ ");
		ListNode abc = header.next;	
		while(abc.next != null) {
			temp.append(abc.element).append(", ");
			abc = abc.next;
		}
		return temp + abc.element + " ]";
	} 

	
	public static void main (String[] arg) {
		// testa metoderna fr�n klassen SimpleLinkedList
		SimpleLinkedList klassLista=new SimpleLinkedList();
		klassLista.insert("0");
		klassLista.insert("1");
		klassLista.insert("2");
		klassLista.insert("3");
		klassLista.insert("4");
		klassLista.insert("5");
		klassLista.insert("7", 0);
		klassLista.print();
		System.out.println(klassLista.toString());

		
		System.out.println("--------");
		System.out.println(klassLista.remove("3", 4));
		System.out.println("--------");
		System.out.println(klassLista.toString());
		klassLista.print();
		System.out.println("size: " + klassLista.size());
	}
}


