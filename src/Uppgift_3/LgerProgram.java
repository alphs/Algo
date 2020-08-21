package Uppgift_3;

import java.util.*;
import java.io.*;

public class LgerProgram {
	private static Scanner scan = new Scanner(System.in);
	private static ItemList inStore = new ItemList();
	private static ItemList outStore = new ItemList();
	private static long nr = 1111111111;

	public static void main(String[] args) {
		printMenu();
		int choice = scan.nextInt();
		scan.nextLine(); 

		while (choice != 0) {
			dispatch(choice);
			printMenu();
			choice = scan.nextInt();
			scan.nextLine();  
		}
		//need to call for the case 0 (choice is 0)which saves to file
		dispatch(choice); 
	}

	private static boolean takeOut(String rfid) {
		if(inStore.find(rfid)) {
			Item item = inStore.remove(rfid);
			System.out.println("item: " + item);
			int c = outStore.size();
			Node abc = outStore.getHeader();
			Calendar calendar = Calendar.getInstance();
			item.setDeliverDate(calendar.getTime());

			for(int i = 0; i < c; i++) {
				abc = abc.next;
				if(item.compareTo(abc.itm) <= 0){
					c = i;
					break;
				}
			}
			outStore.add(item, c);
			System.out.println("Article has been withdrawn");
			return true;
		}
		else {
			System.out.println("The article isn't in store");
			return false;
		}
	}

	private static boolean returnArticle(String rfid) {
		if(outStore.find(rfid)) {
			Item item = outStore.remove(rfid);
			int c = outStore.size();
			Node abc = outStore.getHeader();
			for(int i = 0; i < c; i++) {
				abc = abc.next;
				if(item.compareTo(abc.itm) <= 0) {
					c = i;
					break;
				}
			}
			item.setDeliverDate(null);
			inStore.add(item, c);
			System.out.println("Article succesfully returned");
			return true;
		}
		else if(inStore.find(rfid)){
			System.out.println("Article hasn't been taken out, still in store");
			return false;
		}
		else {
			System.out.println("Article doesn't exist");
			return false;
		}
	}

	private static ItemList searchArticle(String string) {
		Node abc = inStore.getHeader();
		ItemList a = new ItemList();
		StringBuilder print = new StringBuilder();
		while(abc.next != null) {
			abc = abc.next;
			if(abc.itm.getItemNumber().equals(string)) {
				print.append(abc.itm).append('\n');
				a.add(abc.itm);
			}
			else if(abc.itm.getItemName().equals(string)) {
				print.append(abc.itm).append('\n');
				a.add(abc.itm);
			}
		}
		if(!print.toString().equals("")) {
			System.out.println(print);
			return a;
		}
		else {
			System.out.println("Article doesn't exist in storage");
			return null;
		}
	}

	private static Item newArticle(String name) {
		Node abc = inStore.getHeader();
		String rfid;
		int c = inStore.size();
		Item item;

		do {
			rfid = getRFID();
			item = new Item(name, rfid);

			for(int i = 0; i < c; i++) {
				abc = abc.next;
				if(item.compareTo(abc.itm) <= 0) {
					i = 0;
					break;
				}
			}

			inStore.add(item, c);
			System.out.println("Article has been succesfully added");
		}while(!inStore.find(rfid));

		return item;
	}

	private static String getRFID() {
		return "" + nr++;
	}

	private static void dispatch(int choice) {
		switch(choice) {

		case 0: {
			try {
				FileWriter file = new FileWriter("Storage.txt");
				BufferedWriter toFile = new BufferedWriter(file);
				toFile.write("In Storage: ");
				toFile.write("==========");
				toFile.write('\n');

				Node abc = inStore.getHeader();
				while(abc.next != null) {
					abc = abc.next;
					toFile.write(abc.itm.toString() + '\n');
				}

				toFile.write('\n' + '\n' + "Withdrawn articles: ");
				toFile.write("==================");
				toFile.write('\n');

				abc = outStore.getHeader();
				while(abc.next != null) {
					abc = abc.next;
					toFile.write(abc.itm.toString() + '\n');
				}

				toFile.close();
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}


			System.out.println("EXIT");
			System.exit(0);
			break;
		}

		case 1: {
			try {
				Scanner scan = new Scanner(new File("src/Uppgift_3/Medisinskutr.txt"));

				while(scan.hasNext()) {
					newArticle(scan.nextLine());
				}
				scan.close();
			}
			catch(IOException e) {
				System.out.println("File doesn't exist");
			}
			break;
		}

		case 2: {
			System.out.print("Enter the articles RFID nummber: ");
			String rfid = scan.next();
			takeOut(rfid);
			break;
		}

		case 3: {
			System.out.print("Enter the articles RFID nummber: ");
			String rfid = scan.next();
			returnArticle(rfid);
			break;
		}

		case 4: {
			System.out.print("Enter the name of the new article: ");
			String name = scan.next();
			newArticle(name);
			break;
		}

		case 5: {
			outStore.printList();
			break;
		}

		case 6: {
			inStore.printList();
			break;
		}

		case 7: {
			System.out.print("Enter the name or RFID nummer of the article: ");
			String tag = scan.next();
			searchArticle(tag);
			break;
		}

		default:
			System.out.println("Sorry, invalid choice");
		}
	}


	private static void printMenu() {
		System.out.println("\nWelcome" + "\n");
		System.out.println("0: Exit");
		System.out.println("1: Setup Store");
		System.out.println("2: Withdraw article");
		System.out.println("3: Return article" );
		System.out.println("4: New article");
		System.out.println("5: Show all withdrawn articles");
		System.out.println("6: Show all articles in storage");
		System.out.println("7: Search for article by RFID or name");
		System.out.print("\nEnter your choice: ");
	}


}

/*
try{
       Scanner filescan = new Scanner(new File("Verktyg.txt"));
		 while( filescan.hasNext())
		 System.out.println( filescan.next());
		 }

		 catch(IOException ex){System.out.println("Filen finns inte");
 */