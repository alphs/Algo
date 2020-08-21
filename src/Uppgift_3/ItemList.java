package Uppgift_3;

/**
 * Klassen ItemList �r en l�nkad lista som inneh�ller noder av Item-objekt.
 * F�rsta noden i listan ( header) inneh�ller inget objekt.
 */

public class ItemList{
	private final Node header;
	private int size;

	public ItemList( ) {
		header = new Node( null );
		size = 0;
	}


	/**
    Skapar ett ny Node-objekt med ett nytt Item objekt och l�gger den i listan. 
    �kar v�rdet av variabel size;
	 */
	public void add(Item newItem) {
		header.next = new Node(newItem, header.next);
		size++;
	}

	/**
    Skapar ett ny Node objekt med ett nytt Item-objekt och l�gger den i listan p� plats index,
    �kar v�rdet av variabel size;
	 */
	public void add(Item newItem, int index) {
		if(index <= size) {
			if(index >= 0) {
				Node abc = header;
				for(int i = 0; i < index; i++) {
					abc = abc.next;
				}
				abc.next = new Node(newItem, abc.next);
				size++;
			}
			else {
				
				System.out.println("Index out of bounds");
			}
		}
	}

	/**
    Returnerar true om det finns ett Item-objekt vars RFIDNR �r lika med metodens parametern id 
	 */
	public boolean find(String id) {
		Node abc = header;
		while(abc.next != null) {
			abc = abc.next;
			if(abc.itm.getItemNumber().equals(id)) {
				return true;
			}
		}
		return false;	 
	}


	/**
	 Removes item with @param and returns it.
	 */
	public Item remove(String id) {
		Node abc = header;
		while(abc.next != null) {
			abc = abc.next;
			if(abc.itm.getItemNumber().equals(id)) {
				abc.next = abc.next.next;
				break;
			}
		}
		size--;
		return abc.itm;
	}

	/**
    R�knar och returnerar antalet Item- objekt med ett vis namn oavsett RFIDNR 
	 */
	public int countObjects(String name) {
		int count = 0;
		Node abc = header;
		while(abc.next != null) {
			abc = abc.next;
			if(abc.itm.getItemName().equals(name)) {
				count++;
			}
		}
		return count;
	}


	/**
	Prints list
	 */
	public void printList() {
		Node node = header.next;
		while(node != null){
			System.out.println(node.itm);
			node = node.next;
		}
	}


	/**
     Returnera true om listan �r tom annars false
	 */
	public boolean isEmpty() {
		return size == 0;
	}


	/**
     Returnera antlet element i listan
	 */
	public int size() {
		return size;
	}
	
	/** returns the header*/
	public Node getHeader() {
		return header;
	}

}