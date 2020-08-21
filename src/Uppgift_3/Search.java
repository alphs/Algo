package Uppgift_3;

public class Search {
	public static void main(String[] args) {
		int[] a = createArray(100000, 0, 1000);
		int x = (int)(Math.random()*(1000)*1000);

		for(int i = 0; i < 10; i++) {
			long time0 = System.nanoTime();
			linearSearch(a, x);
			long time1 = System.nanoTime();
			System.out.println("the linearSearch took: " + (time1-time0) + " ns");
		}
		
		java.util.Arrays.sort(a);
		for(int i = 0; i < 10; i++) {
			long time0 = System.nanoTime();
			binarySearch(a, x);
			long time1 = System.nanoTime();
			System.out.println("the binarySearch took: " + (time1-time0) + " ns");
		}	

}
	
	private static int linearSearch(int[] a, int x) {
		for(int i = 0; i < a.length; i++) {
			if(i == x) {
				return a[i];
			}
		}	
		return -1;
	}
	
	private static int binarySearch(int[] a, int x){
		int low = 0;
		int high = a.length - 1;
		int mid;
		
		while( low <= high ) {
			mid = ( low + high ) / 2;
			if ( x > a[ mid ] )
				low = mid + 1; // leta i högra halvan
			else if(x < a[ mid ] )
				high = mid - 1; // leta i vänstra halvan
			else
				return mid;
		}

		return -1;
	}
	
	private static int [] createArray(int size, int min, int max) {
		int[] a = new int[size];
			for(int i = 0; i < a.length; i++){
				a[i] = (int)(Math.random()*(max-min) + min);
			}	

		return a;
	}
}
