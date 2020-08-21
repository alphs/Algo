package Uppgift_3;

class ListNode {
	public final String element;
	public ListNode next;

	// Constructors

	public ListNode( String theElement ) {
		this( theElement, null );
	}

	public ListNode( String theElement, ListNode n ) {
		element = theElement;
		next    = n;
	}


	public static void main (String[] a) {

		ListNode n1 = new ListNode("Nina");
		ListNode n2 = new ListNode("Kalle", n1);
		ListNode n3 = new ListNode("Olle", n2);

		ListNode n = new ListNode("Mio", n3);
		while(n != null) {
			System.out.println(n.element);
			n=n.next;
		}



	}

}
