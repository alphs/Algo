package Uppgift_5.src.Uppg2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TreeSetCounter extends TreeSet<String> {

	private static Map<String, Integer> map = new ConcurrentHashMap<>();

	private static int counter = 0;
	private String string = "";

	public static void main(String[] arg) {
		TreeSetCounter tree = new TreeSetCounter();
		BufferedReader in;
		File file;
		FileReader fileReader;

		try {
			file = new File("src/Uppgift_5/src/Uppg2/wordlist.txt");
			fileReader = new FileReader(file);
			in = new BufferedReader(fileReader);

			for(int i = 0; i < 700; i++) {
				tree.addWord(in.readLine());
			}
		} catch (IOException e) { e.printStackTrace(); }

		for (String s : tree) {
			System.out.println(map.get(s) + " : " + s);
		}
		System.out.println("maxfreq: " + tree.getMaxFrek() + " " + counter);
	}

	public void addWord(String s) {
		System.out.println(!add(s));
		if(!add(s)) {
			int c = 0;
			if(map.get(s) != null){
				c = map.get(s);
				System.out.println(c);
			}
			map.put(s, c + 1);
			c = map.get(s);
			if(c > counter) {
				string = s;
				counter = c;
			}
		}
	}

	public void makeEmpty() {
		clear();
	}

	public String getMaxFrek() {
		return string;
	}

	public java.util.Iterator<String> iterator() {
		return super.iterator();
	}
}
