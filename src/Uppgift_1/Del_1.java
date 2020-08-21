import java.util.Random;

public class Del_1 {
	public static void main(String[] arg) {
		
		int c = 0;													//variable for counter
		String abcdef = String.valueOf(generatePassword());			//generatePassword() returns a char[] whilst passWordCheck() takes a string as a argument, converts here.
		for(int i = 0; i < 1000; i++){								//loop that creates 1000 passwords and check if they passes as eligible according to the criteria in the task.
			if (passwordCheck(abcdef));{
			c++;
			}
			System.out.println(abcdef); 
		}
		System.out.println("Number of correct passwords: " + c);			//prints the counter variable, i.e. shows how many passwords met the criteria.
		System.out.println("Number of incorrect passwords: " + (1000-c));

	}	
	public static char[] generatePassword() {						//method that generates the passwords from 3 separate arrays.
		int randPass = (int) (Math.random()*5) + 8;					//variable for determining the length of the password (8-12).
		char[] passWord = new char[randPass];						
		char[] alphabetLo = "abcdefghjklmnopqrstuvwxyz".toCharArray();		//array over the lower case alphabet, for choosing letters between a-z.
		char[] alphabetUp = "abcdefghjklmnopqrstuvwxyz".toUpperCase().toCharArray(); //array over the uppercase alphabet, for choosing letters between A-Z.
		char[] numbers = "0123456789".toCharArray();							//array over the numbers 0-9
		
		int randU = (int) (Math.random()*(randPass-2))+1;			//variable for randomly choosing how many uppercase letters should be in the password.
		int randL = (int) (Math.random()*((randPass-randU)-1))+1;	//variable for randomly choosing how many lowercase letters should be in the password.
		//int randNum = (int) Math.random()*((randPass-randU-randL)); //(not needed, since the remaining positions in the passWord array will all be numbers) //variable for randomly choosing how many numbers should be in the password.
		int r;
		for(int i = 0; i < randU; i++) {							//loop for randomly assigning uppercased letters to the password array randU times. 
			r = (int) (Math.random()*(alphabetUp.length));			
			passWord[i] = alphabetUp[r];
		}
		for(int i = randU; i < randL+randU; i++) {					//loop for randomly assigning lowercased letters to the password array randL times.
			r = (int) (Math.random()*(alphabetLo.length));
			passWord[i] = alphabetLo[r];
		}
		for(int i = (randU+randL); i < passWord.length; i++) {		//loop for randomly assigning numbers to the password array passWord.length - (randU-randL) (the remaining positions) times.
			r = (int) (Math.random()*numbers.length);
			passWord[i] = numbers[r];
		}
		
		Random rand = new Random();
		char temp;
		for(int i = passWord.length -1; i > 0; i--) {				//loop for shuffling/randomizing the passWord array, before the characters are all in groups e.g. AHGGhjj1231
			r = rand.nextInt(i + 1);
			temp = passWord[r];
			passWord[r] = passWord[i];
			passWord[i] = temp;
		}
		
	return passWord;
	}
	
	
	public static boolean passwordCheck(String password) {	 //method for checking if the a password passes the given criteria.
	return(password.length() > 7 && password.length() < 13 && password.matches(".*[0-9]+.*") && password.matches(".*[a-z]+.*") && password.matches(".*[A-Z]+.*")); //setting up the criterias via regex and equalities
	}

}
