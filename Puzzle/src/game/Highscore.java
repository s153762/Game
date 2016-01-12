package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Highscore {
	public static void main(String[] args) throws FileNotFoundException{

		int highScore = readHighScore();
		System.out.println("The lowest number of guesses are "+highScore+", can you beat it?");
		
		System.out.println("Guess the number: ");
		int score = 1;
		
		//GAME END
		System.out.println("Congratulations!! you guessed the correct number ");
		System.out.println("you used "+score+" guesses!!");
		if (score < highScore){
			System.out.println("WHOOHOO! you bet the highscore!!");
			//writeHighScore();
		}
		input.close();
	
	}
	
	public static float readHighScore() {
		try {
			File file = new File("highscore.txt");
			Scanner fileInput = new Scanner (file);
			float highscore = fileInput.nextFloat();
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
