package Uppgift_3;

class Node {
	public final Item itm;
	public Node next;

	// Constructors
	public Node(Item theItem) {
		this(theItem, null);
	}
	
	public Node( Item theItem, Node n ) {
		next = n;
		itm = theItem;
	}


	public static void main (String [] a) {

		Node n1 = new Node(new Item("Dermatoskop","1111111111"));

		Node temp= new Node(new Item ("EKG","1111111112"),n1);
		while(temp!=null) {
			System.out.println(temp.itm.toString());
			temp=temp.next;
		}


	}

}