
import java.io.BufferedReader;
//import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Del1_5{
	public static void main(String[] args) {

		String string;
		int[] a = new int[127];
		float antal = 0;
	//	File file = new File("klasslista.txt");
		int c = 0;
		try {
			Scanner scan = new Scanner(new BufferedReader(new FileReader("klasslista.txt")));
			while(scan.hasNext()) {
				c++;
				string = scan.next();
				for(int i = 0; i < string.length(); i++){
					if(string.charAt(i)<127) {
						a[string.charAt(i)]++;
						antal++;
					}
				}
			}
			scan.close();
		}
		
		catch( Exception exp) {
			System.out.println(exp);
		}
	
		System.out.println("Bokstav:        Antal:        Frekvens:");
		for(int i = 0; i < a.length; i++) {
			if(a[i] > 0) {
				System.out.println((char) i + "                " + a[i] + "              " + (float) ((a[i]/antal)*100) + "%");
			}
			
		}
	System.out.println(c);
	}
}