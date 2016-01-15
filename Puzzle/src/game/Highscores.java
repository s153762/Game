package game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Highscores {
	private String fileName;
	private ArrayList<String> highscores;
	private ObjectOutputStream outputStream = null;
    private ObjectInputStream inputStream = null;
	

    
	public Highscores(String fileName){
		this.fileName = fileName;
		highscores = readHighscores();
		updateArray();
		writeHighscores();
		
	}
	
	public ArrayList<String> readHighscores(){
		highscores = new ArrayList<String>();
		try {
            inputStream = new ObjectInputStream(new FileInputStream(fileName));
            highscores = (ArrayList<String>) inputStream.readObject();
            return highscores;
        } catch (FileNotFoundException e) {
            System.out.println("[Laad] FNF Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[Laad] IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[Laad] CNF Error: " + e.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Laad] IO Error: " + e.getMessage());
            }
        }
		return highscores;
	}
	
	public void writeHighscores(){
		try {
            outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            outputStream.writeObject(highscores);
        } catch (FileNotFoundException e) {
            System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
        } catch (IOException e) {
            System.out.println("[Update] IO Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Update] Error: " + e.getMessage());
            }
        }
	}
	
	public void updateArray(){
		for(int i = 0; i<10;i++){
			for(int j = 1; j<highscores.size();j++){
				if(Float.parseFloat(highscores.get(j-1).split(": ")[1]) > Float.parseFloat(highscores.get(j).split(": ")[1]) ){
					String temp = highscores.get(j-1);
					highscores.set(j-1, highscores.get(j));
					highscores.set(j, temp);
				}
				if(j >= 10){
					highscores.remove(j);
				}
			}
		}
	}
	
	public ArrayList<String> getHighscores(){
		return highscores;
	}
	
	public boolean isNewHighscore(float newScore){
		if(!highscores.isEmpty()){
			if(!(newScore <= Float.parseFloat(highscores.get(highscores.size()-1).split(": ")[1]))){
				if(highscores.size() >= 10){
					return false;
				}
				return true;
			} else{
				return true;
			}
		} else {
			return true;
		}
		
	}
	
	public void addNewHighscore(String name, float score){
		highscores.add(name+": "+score);
		updateArray();
		writeHighscores();
	}
	

}
