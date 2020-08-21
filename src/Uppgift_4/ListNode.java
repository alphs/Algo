package Uppgift_4;

class ListNode {
	public Object element;
	public ListNode next;

	// Constructors
	public ListNode( Object theElement ) {
		this(theElement, null);
	}

	public ListNode( Object theElement, ListNode n ) {
		element = theElement;
		next    = n;
	}

	public static void main (String[] a) {

		ListNode n1 = new ListNode("Nina");
		ListNode n2 = new ListNode("Kalle",n1);
		ListNode n3 = new ListNode("Olle",n2);
		ListNode n4 = new ListNode("Mio",n3);

		ListNode n = n4;
		while(n!=null)
		{
			System.out.println(n.element);
			n=n.next;
		}



	}

}
