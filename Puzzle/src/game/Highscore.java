package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Highscore {
	public static void main(String[] args) throws FileNotFoundException{
		//GAME START
		System.out.println("Welcome to the GREATEST GUESSING GAME!");
		System.out.println("I'm thinking of a number between 1 and 100, can you guess it!!");
		Random random = new Random();
		int secretNumber = random.nextInt(100)+1;
		Scanner input = new Scanner(System.in);
		
		int highScore = readHighScore();
		System.out.println("The lowest number of guesses are "+highScore+", can you beat it?");
		
		System.out.println("Guess the number: ");
		int guess = input.nextInt();
		int score = 1;
		
		//GAME RUNNING
		while(guess != secretNumber){
			if( guess > secretNumber){
				System.out.println("Too high!! Guess again: ");
				guess = input.nextInt();
			} else {
				System.out.println("Too low!! Guess again: ");
				guess = input.nextInt();
			}
			score++;
		}
		//GAME END
		System.out.println("Congratulations!! you guessed the correct number "+secretNumber);
		System.out.println("you used "+score+" guesses!!");
		if (score < highScore){
			System.out.println("WHOOHOO! you bet the highscore!!");
			//writeHighScore();
		}
		input.close();
	
	}
	
	public static int readHighScore() {
		try {
			File file = new File("highscore.txt");
			Scanner fileInput = new Scanner (file);
			int highscore = fileInput.nextInt();
			fileInput.close();
			return highscore;
		} catch (FileNotFoundException e) {
		return 100;	
		}
	}
	
	public static void writeHighScore(int score) throws FileNotFoundException {
		File file = new File("highscore.txt");
		PrintStream fileOutput = new PrintStream(file);
		fileOutput.print(score);
		fileOutput.close(); //opdagtere highscoren.. min virker bare ikke!!
	}

}
