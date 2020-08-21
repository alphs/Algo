import java.util.Arrays;
import java.util.Iterator;

public class mylistAcc {
	public class ReadCount {

	}

	public static void main(String[] args) {

		MyArrayList<Account> mylist = new MyArrayList<Account>();
		for(int i = 0; i < 4; i++) {
			mylist.add(new Account(Integer.toString(((int)(Math.random()*1000000+1))), Math.random()*1000000));
		}

		Iterator<Account> a = mylist.iterator();
		while(a.hasNext()) {
			Account b = a.next();
			b.deposit((Math.random()*4000) + 1000);
		}
		System.out.println(Arrays.toString(mylist.toArray()));

		/**Collections.sort() funkar inte for att MyArrayList arver inte. */
		//Collections.sort(mylist); 

	}

}

