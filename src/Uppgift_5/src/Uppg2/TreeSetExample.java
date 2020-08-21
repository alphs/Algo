package Uppgift_5.src.Uppg2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class TreeSetExample{

	public static void main(String[] arg) {
		TreeSet<String> tree = new TreeSet<>();
		BufferedReader in;
		FileWriter writer;
		BufferedWriter out;
		String string;
		try {
			File file = new File("src/Uppgift_5/src/Uppg2/wordlist.txt");
			FileReader fileReader = new FileReader(file);
			in = new BufferedReader(fileReader);
			for (int i = 0; i < 700; i++) {
				string = in.readLine();
				tree.add(string + " " + i);
			}
			writer = new FileWriter("src/Uppgift_5/src/Uppg2/wtreeExample.txt");
			out = new BufferedWriter(writer);

			for (String s : tree) {
				out.write(s + "\n");
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
