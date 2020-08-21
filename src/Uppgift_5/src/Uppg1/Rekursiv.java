package Uppgift_5.src.Uppg1;

public class Rekursiv {

	public static void main(String[] args) {
		printTo(5);
		System.out.println(palindrome("aaaaa", 0));
		System.out.println(exponent(2, 2));
	}

	public static void printTo(int a) {
		if(a == 0) {
			System.out.print(a);
			System.out.println();
		}
		else {
			System.out.print(a + " ");
			a--;
			printTo(a);
		}
	} 

	public static boolean palindrome(String abc, int c) {
		char[] alpha = abc.toCharArray();

		if(c == alpha.length/2) {
			return true;
		}
		if(alpha[c] == alpha[alpha.length-1]-c) {
			if(palindrome(abc, ++c));
			return true;
		}
		return false;
	}

	public static double exponent(double base, double exp) {
		if(exp < 0) {
			System.out.println("exponent() not applicable for numbers x < 0");
			return 0;
		}
		else if(exp == 0) {
			return 1;
		}
		else {
			return base * exponent(base, exp-1);
		}

	}



}



