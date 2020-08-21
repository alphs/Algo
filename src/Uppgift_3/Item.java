package Uppgift_3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class Item implements Comparable<Item> {
	private String delivered;   // utl�nd datum, null n�r Item inte �r utl�nad
	private final String RFIDNR;
	private final String name;


	public Item(String thename, String number) {
		name = thename;
		RFIDNR = number;
		delivered=null;
	}


	public Item(String thename, String number, String time) {
		name = thename;
		RFIDNR = number;
		delivered=time;
	}


	public void setDeliverDate(Date d) {
		if (d == null){
			delivered = null;
		} else{
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			delivered = df.format(d);
		}
	}


	public String getDeliverDate() {
		return delivered;
	}


	public String getItemNumber() {
		return RFIDNR;
	}


	public String getItemName() {
		return name;
	}

	@Override
	public int compareTo(Item other) {
		return name.compareTo(other.getItemName());
	}


	public boolean equals(Object other) {
		// Detta g�r du f�rdig. Vi s�ger att tv� objekt �r lika om de har samma RFIDNR  
		return RFIDNR.equals(((Item) other).RFIDNR);
	}


	public String toString() {
		return RFIDNR + " " + name + " " + Objects.requireNonNullElse(delivered, "in storage");
	}


	// See a simple program example to understand how Date class works; 
	public static void main (String [] arg)	{

		Calendar calendar = Calendar.getInstance();

		Date newDate = calendar.getTime();

		// Skapa item- object
		Item itm= new Item ( "Termometer", "1111111111");

		// G�r item-obj utl�nad
		itm.setDeliverDate(newDate);

		System.out.println( itm);

	}

}


