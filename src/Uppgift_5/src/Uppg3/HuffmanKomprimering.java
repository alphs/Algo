package Uppgift_5.src.Uppg3;

//Du f�r (om du vill) �ndra strukturen i klassen Huffman genom att l�gga till metoder eller 
//variabler. Observera att variablerna och metoderna i klassen �r static.

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

class HuffmanKomprimering {

	private static ArrayList<HuffmanTree> huffmanTreeArrayList;
	private static int[] freqs;
	private static String[] codes;
	private static int setSize;
	private static HuffmanTree tree;

	/*
	 * Reads characters one at a time from the file, -1 is EOF, same as ascii.
	 * The corresponding position in the array for the ascii character 1 is added.
	 */
	private static void readFile(String filename) throws IOException {

		BufferedReader in = new BufferedReader(new FileReader(new File(filename)));

		int read = in.read();
		while(read != -1) {
			System.out.print(read + " : ");
			System.out.println( (char) read);
			freqs[read]++;			// here add
			read = in.read();
		}
	}

	/*
	 * Adds the Huffman tree to "huffmanTreeArrayList".
	 * Create the Huffman tree, where a node is idenetifid with ascii and the frequency is the weigh.
	 */
	private static void makeTree() {
		for(int i = 0; i < 256; i++) {

			int weight = freqs[i];
			if(weight != 0) {
				HuffmanTree tree = new HuffmanTree(i, weight);
				huffmanTreeArrayList.add(tree);
			}
		}

		Collections.sort(huffmanTreeArrayList);

		while(huffmanTreeArrayList.size() > 1) {
			//Merging the trees.
			HuffmanTree	tree = new HuffmanTree(huffmanTreeArrayList.remove(0), huffmanTreeArrayList.remove(0));
			huffmanTreeArrayList.add(tree);
			Collections.sort(huffmanTreeArrayList);
		}
		//Margin the final two trees.
		tree = huffmanTreeArrayList.get(0);
	}

	/*
	 *
	 */
	private static void makeCods() {
		// anvander metoden codes() for din slutliga HT. Metoden finns definierad i
		// klassen HuffmanTree. Undersok den.
		tree.codes(codes);
	}

	/*
	 * Prints the results to the "test.txt" file.
	 */
	private static void showResults() throws FileNotFoundException {
		int count = 0;
		StringBuilder temp = new StringBuilder();
		PrintWriter output = new PrintWriter("src/Uppgift_5/src/Uppg3/test.txt");
		for(int nrm : freqs) {
			if(nrm != 0) {
				temp.append("Char: ").append((char) count)
						.append(" Freq: ").append(freqs[count])
						.append(" Codes: ").append(codes[count])
						.append("\n");
			}
			count++;
		}
		output.println(temp);
		output.close();
	}

	private static void makeFile() throws IOException {
		// anv�nd stringTobyte f�r att bygga den komprimerade filen.
		File file = new File("/Users/alexander/IdeaProjects/Algo/src/Uppgift_5/src/Uppg3/testbild1.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader in = new BufferedReader(fileReader);

		PrintWriter outputFile = new PrintWriter("/Users/alexander/IdeaProjects/Algo/src/Uppgift_5/src/Uppg3/compTest.txt");
		String output = "";
		StringBuilder s = new StringBuilder();

		while(in.ready()) s.append(codes[in.read()]);

		for(int i = 0; i < s.length(); i += 8) {
			if(i + 8 > s.length()) {
				int t = i + 8 - s.length();
				s = new StringBuilder(s.substring(i, s.length()));
				while(t > 0) {
					s.insert(0, "0");
					t--;
				}
				outputFile.write((char)stringTobyte(s.toString()));
				break;
			}
			String s = s.substring(i, i+8);
			char c = (char)stringTobyte(s);

			outputFile.write(c);
		}
		outputFile.println(output);
		in.close();
		outputFile.close();
	}

	// metoden tar som argument en str�ng (11000111) och konvertera den till byte
	// anv�nd metoden f�r att konvertera dina koder till byte som skall sedan sparas
	// till filen.
	public static byte stringTobyte(String s) {
		byte b = 0;
		if (s.length() != 8) {
			throw new RuntimeException("The string representation of the byte in not of proper length!");
		}
		for (int i = 0; i < 8; i++) {
			if (s.charAt(i) == '1')
				b |= (1 << (7 - i));
		}
		return b;
	}

	public static void main(String[] a) throws IOException {
		setSize = 256;
		codes = new String[setSize];
		freqs = new int[setSize];
		huffmanTreeArrayList = new ArrayList<>();

		try {
			readFile("/Users/alexander/IdeaProjects/Algo/src/Uppgift_5/src/Uppg3/testbild1.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		makeTree();
		makeCods();
		showResults();
		makeFile();
	}
}
