package game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Highscore {
	//private File file;
	//private String highscore = ":1000000000";
	private float score;
	private ArrayList<String> highscorelist;
	
	public Highscore(float score){
		highscorelist = readHighScore();
		this.score = score;
	}
	
	public ArrayList<String> readHighScore() {
		//name:float
		ObjectInputStream inputStream = null;
//		FileReader fileread = null;
//		BufferedReader reader = null;
		this.highscorelist = new ArrayList<String>();
		try {
			inputStream = new ObjectInputStream(new FileInputStream("Highscore.dat"));
            highscorelist = (ArrayList<String>) inputStream.readObject();
			
//			fileread = new FileReader("highscore.txt");
//			reader = new BufferedReader(fileread);
//			while(true){
//				String line = reader.readLine();
//				if (line == null){
//					break;
//				}
//				System.out.println(line);
//				highscorelist.add(line);
//			}
//			
			return highscorelist;
		} catch (Exception e) {
			System.out.println("read not");
			return highscorelist;
		} finally{
			try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Laad] IO Error: " + e.getMessage());
            }
//			try{
//				if(fileread != null)
//				reader.close();
//			} catch(IOException e){
//				e.printStackTrace();
//			}
		}
	}
	
	public void writeScore(){
		int i = 0;
		while(highscorelist.size() != i){
			if(score < Float.parseFloat(highscorelist.get(i).split(":")[1])){
				String name = "name";
				highscorelist.set(i, name+":"+score);
				
				File file = new File("Highscore.txt");
				
				if(!file.exists()){
					try{
						file.createNewFile();
					} catch(IOException e){
						e.printStackTrace();
					}
				}
				
				FileWriter writefile = null;
				BufferedWriter writer = null;
				try{
					System.out.println("writing");
					writefile = new FileWriter(file);
					writer = new BufferedWriter(writefile);
					ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Highscore.txt"));
					outputStream.writeObject(highscorelist);
					outputStream.close();
//					writer.newLine();
//					writer.write(highscorelist.get(i));
					
				} catch (Exception e){}
				finally{
					try {
						if (writefile != null){
							writer.close();
							
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}	
			}
			i++;
		}
		
	}
	
	public void updateScore(){
		
	}
	
//	public static void writeHighScore(int score) throws FileNotFoundException {
//		File file = new File("highscore.txt");
//		PrintStream fileOutput = new PrintStream(file);
//		fileOutput.print(score);
//		fileOutput.close(); //opdagtere highscoren.. min virker bare ikke!!
//	}

}
