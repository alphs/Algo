
import java.io.BufferedReader;
//import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Del_1_8 {
	public static void main(String[] arg) {
		//File file = new File("klasslista.txt");
		String string;
		ArrayList<String> klassList = new ArrayList<String>();
		
		try {
			Scanner scan = new Scanner(new BufferedReader(new FileReader("klasslista.txt"))); //creates a scanner
			while(scan.hasNextLine()) { //checks if there's content left in the document
				string = scan.nextLine(); //loads the next line of the doc i.e. a  name into the variable string
				string = string.replaceAll("[ \\t]",  " "); //removes the tabs in the document
				klassList.add(string); //adds the name to the arraylist
			}
			scan.close(); //closes the scanner scan
		}
		catch( Exception exp) {
			System.out.println(exp);
		}
		//test if the method addToList works, should display false if the name already exists and true if it didn't and wher added
		System.out.println("Have " + "Bong Nillson" +" been added in the list? " + addToList(klassList, "Bong Nilsson"));
		System.out.println("Have " + "ADAKJ jjloma" +" been added in the list? " + addToList(klassList, "ADAKJ lkznsclkn"));

		System.out.println(klassList);
	
	}
	
	public static boolean addToList(ArrayList<String> list, String name) {
		if(list.contains(name)) {		//checks if the list contains the name.
			return false;
		}
		else {
			String [] te1 = name.split(" "); //splits the names into a array whereas firstname is on index 0 and lastname on 1
			String[] te2;
			int parts = te1.length; 
			if(parts == 1) { //checks if the name consists of botha first and lastname, if not displays lastname as "UNKNOWN" and sets it at the top of the list
				list.add(0, name + "\"UNKNOWN\"");
			}
				else {
				for(int i = 0; i < list.size(); i++) { 		//
					te2 = ((String) list.get(i)).split(" "); 		//splits a name from the list, same as on row 39
					if(te1[1].compareTo(te2[1]) <= 0) { //compares the lastname of both the name given and the name taken from the list.
						list.add(i, name);
						break;				//have found match, therefore want it to end -> break
					}
				}
			}
		}
		return true;
	}
	
}




