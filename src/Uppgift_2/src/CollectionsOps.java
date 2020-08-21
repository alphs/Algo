import java.util.*;

public class CollectionsOps {

	public static void main(String[] args) {
		List<Integer> heltal = new ArrayList<Integer>();		//create 3 narrays "heltal" containing integers, "flyttal" containig doubles and "campusLindholmen" containing Strings
		for(int i = 0; i < 6; i++) {
			heltal.add(i);
		} 
		List<Double> flyttal = new ArrayList<Double>();
		flyttal.add(1.25);
		flyttal.add(3.14);
		flyttal.add(9.7);
		List<String> campusLindholmen = new ArrayList<String>();
		campusLindholmen.add("Saga");
		campusLindholmen.add("Svea");
		campusLindholmen.add("Jupiter");

		print(heltal);
		CollectionsOps.print(CollectionsOps.reverse(heltal));

		print(flyttal);
		CollectionsOps.print(CollectionsOps.reverse(flyttal));

		print(campusLindholmen);
		CollectionsOps.print(CollectionsOps.reverse(campusLindholmen));

	}

	public static <T> void print(Collection<T> l) {
		if(l.isEmpty()) {
			System.out.println("[]");
		}
		else {
			int i = 0;
			System.out.print("[");				//prints out the list adding "[" and "]" to start and end with "," between elements.
			for(T t: l) {
				if(i == l.size()-1) {
					System.out.print(t + "]");
				}
				else {
					System.out.print(t + ",");
				}
				i++;
			}
			System.out.println();
		}
	}


	public static <T> List<T> reverse(List<T> l){	//adds the last element to the list and then removes the old "copy" (the added element is placed at the end and the the same element that was added was removed)
		for(int i = 0; i < l.size(); i++) {
			l.add(l.get(l.size()-i-1));
			l.remove(l.size()-i-2);
		}

		return l;	
	}

}