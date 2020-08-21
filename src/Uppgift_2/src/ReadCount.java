//import java.io.BufferedReader;
import java.io.File;
//import java.io.FileReader;
import java.util.*;
public class ReadCount {
	public static void main(String[] args) {
		//	File file = new File("europa.txt");

		ArrayList<Land> lista = new ArrayList<Land>();	
		try {
			//Scanner scan = new Scanner(new BufferedReader(new FileReader("europa.txt"))); //creates a scanner
			Scanner scan = new Scanner(new File("europa.txt"));
			//Scanner scan = new Scanner(file);

			while(scan.hasNext()) {
				String coun = scan.next();
				int pop = scan.nextInt();
				int size = scan.nextInt();
				String capital = scan.next();
				lista.add(new Land(coun, capital, pop, (double)size));
			}
			scan.close();
		}
		catch( Exception exp) {
			System.out.println(exp);
		}
		Scanner user = new Scanner(System.in);
		System.out.println("Hur vill du sortera Europa?");
		System.out.println("1: Sortera efter namn");
		System.out.println("2: Sortera efter invånare");
		System.out.println("3: Sortera efter area");
		int val = user.nextInt();
		user.close();
		Iterator<Land> itr;

		switch(val) {
		case 1: {
			Collections.sort(lista, new NameComp());
			itr = lista.iterator();
			System.out.println("Sorterad efter namn");
			while(itr.hasNext()) {
				System.out.println(itr.next());
			} 
			break;
		}

		case 2: {
			itr = lista.iterator();
			System.out.println("Sorterad efter invånare");
			Collections.sort(lista, new PopComp());
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}
			break;
		}

		case 3: {
			itr = lista.iterator();
			System.out.println("Sorterad efter yta");
			Collections.sort(lista, new AreaComp());
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}
			break;
		}

		default: {
			System.out.println("Välj mellan alternativen 1-3");
			break;
		}

		}
	}
}
