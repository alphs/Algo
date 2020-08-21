

public class Del_1_4 {
	public static void main(String[] args) {

		for(int i = 0; i < 10; i++) {						//loop for testing the addAtIndex method, creating a a random indexe and a random number "index" and "x" calling the function to add the number "x" at index "index" in the array a 10 times.
			int[] a = new int[] {1,2,3,4,5};
			int	index = ((int)(Math.random()*a.length));
			int	x = ((int)(Math.random()*a.length));

			System.out.print("Original: ");		//prints out the oringinal array before calling the method.
			System.out.println(java.util.Arrays.toString(a));

			addAtIndex(a, x, index);				//calls the function
			System.out.print("Index: " + index +", X: " + x + " ");	//prints out the what "index" and "x" is aswell as the new array.
			System.out.println(java.util.Arrays.toString(a));
			System.out.println("-----------");

		}
	}


public static void addAtIndex(int[] a, int x, int index) { //method for putting a number "x" in a array at index "index"
		if(a[index] != 0) {
			for(int i = a.length -1; i > index; i--) { //moves all the elements backwards untill it reaches "index" and puts it as "x"
				a[i] = a[i-1];
			}
				a[index] = x;
		}
		
	}
}