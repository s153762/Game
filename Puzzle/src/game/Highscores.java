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
		this.highscores = readHighscores();
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
		if (highscores.size() != 0){
			
			float valueToInsert = Float.parseFloat(highscores.get(highscores.size()-1).split(": ")[1]);
			
			int pointer = highscores.size()-1;
			//String temp = highscores.get(pointer);
			while(pointer> 0 && valueToInsert<Float.parseFloat(highscores.get(pointer-1).split(": ")[1])){
				String temp = highscores.get(pointer-1);
				highscores.set(pointer-1, highscores.get(pointer));
				highscores.set(pointer, temp);
				pointer--;
			}
			if(highscores.size() > 10){
			highscores.remove(10);
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

