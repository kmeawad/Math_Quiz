package kmeawad_lab04;
import java.util.Scanner;

/**
 * @author Kareem
 *
 */
public class kmeawad_lab04_q3 {
	public static void printHeader ( int labNum , int questionNum , String fName , String lName , String mission ) {
		int max;
		int sum = fName.length() + lName.length()+6;
		max = Math.max(mission.length(), sum);
		for(int i = 1; i <= max ; i++) System.out.print("*");
		System.out.println("\n"+mission);
		for(int i = 1; i <= max ; i++) System.out.print("*");
		System.out.println("\nLab " + labNum +"\nQuestion "+ questionNum+"\nName: " + fName+lName);
		for(int i = 1; i <= max ; i++) System.out.print("*");
		System.out.println("");
	}

	public static int sum(int difficulty ,int i) {
		int counter=0, random1=0, random2=0;
		random1 = fetchDifficulty(difficulty);
		random2 = fetchDifficulty(difficulty);
		int sum = random1+ random2;
		Scanner input = new Scanner(System.in);
		System.out.println("\nQuestion "+ i +"\nWhat is the result of: " + random1 + " + " + random2);
		int result = input.nextInt();
		if (sum == result){ System.out.println("Correct!"); counter++;}
		else System.out.println("Incorrect! The correct answer was: "+sum);
		return counter;
	}

	public static int sub(int difficulty ,int i) {
		int counter=0, random1=0, random2=0;
		random1 = fetchDifficulty(difficulty);
		random2 = fetchDifficulty(difficulty);
		int sub = random1 - random2;
		Scanner input = new Scanner(System.in);
		System.out.println("\nQuestion "+ i +"\nWhat is the result of: " + random1 + " - " + random2);
		int result = input.nextInt();
		if (sub == result){ System.out.println("Correct!"); counter++;}
		else System.out.println("Incorrect! The correct answer was: "+sub);
		return counter;
	}

	public static int mult(int difficulty ,int i) {
		int counter=0, random1=0, random2=0;
		random1 = fetchDifficulty(difficulty);
		random2 = fetchDifficulty(difficulty);
		long mult = random1 * random2;
		Scanner input = new Scanner(System.in);
		System.out.println("\nQuestion "+ i +"\nWhat is the result of: " + random1 + " X " + random2);
		long result = input.nextLong();
		if (mult == result){ System.out.println("Correct!"); counter++;}
		else System.out.println("Incorrect! The correct answer was: "+mult);
		return counter;
	}

	public static int fetchDifficulty(int difficulty) {
		int random = 0;
		switch (difficulty) {
		case 1:
			random = (int) (Math.random()*10);
			break;
		case 2:
			random = (int) (Math.random()*100);

			break;
		case 3:
			random = (int) (Math.random()*200)-100;
			break;
		}
		return random;
	}
	
	public static void main(String[] args) {
		// Store variables
		int difficulty=0, choice=0 , counter =0 , x=2;
		double startTime;
		Scanner input = new Scanner(System.in);
		//Variables stored for the header
		int labNum = 5, questionNum = 2;
		String fname = "k", lname = "meawad"  , mission = "Practicing simple math problems";
		printHeader(labNum, questionNum , fname,lname,mission);
		
		do{System.out.println("\nPlease choose a difficulty level\n1) Easy: Integers ranging 0 to 10\r\n" + 
				"2) Medium: Integers ranging 0 to 100\r\n" + 
				"3) Hard: Integers ranging -100 to 100\r\n" + 
				"Please input a choice (1-3):");
		difficulty = input.nextInt();
		while (difficulty > 3 || difficulty < 1) {
			System.out.println("Invalid difficulty choice!\r\nPlease input a choice (1-3):");
			difficulty = input.nextInt();
		}
		System.out.println("\nPlease select the type(s) of problems:\r\n" + 
				"1. Addition\r\n" + 
				"2. Subtraction\r\n" + 
				"3. Multiplication\r\n" + 
				"4. Random\r\n" + 
				"5. Change Difficulty\r\n" + 
				"6. Exit\r\n" + 
				"Please input a choice (1-6):");
		choice = input.nextInt();
		while (!(choice <= 6 && choice >= 1)) {
			System.out.println("\nInvalid choice!\nPlease select the type(s) of problems:");
			choice = input.nextInt();}
		if(choice == 4) choice =(int) (Math.random()*3)+1;
		startTime = System.currentTimeMillis();
		switch(choice) {
		case 1: 
			startTime = System.currentTimeMillis();
			for(int i = 1;i<11;i++) {
				counter = counter + sum(difficulty, i);}
			x=2;
			break;

		case 2: 
			for(int i = 1;i<11;i++) {
				counter = counter + sub(difficulty, i);}
			x=2;
			break;

		case 3: 
			for(int i = 1;i<11;i++) {
				counter = counter + mult(difficulty, i);}
			x = 2;
			break;	
		case 5: x=1; break;
		case 6: x=2; break;
		}}while(x == 1);
		double endTime = System.currentTimeMillis();
		double timeElapsed = (endTime - startTime)/10000;
		if(choice != 6)System.out.println("\nYou scored "+ counter+"/10 questions correctly and\nthe average question time was "+timeElapsed+ " seconds\n");
		System.out.println("Goodbye!");
	}

}


