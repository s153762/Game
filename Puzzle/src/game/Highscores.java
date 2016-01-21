package game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Highscores {
	private String fileName;
	private ArrayList<String> highscores;
	private ObjectOutputStream outputStream = null;
    private ObjectInputStream inputStream = null;
	
    //constructor: reading, updating and rewriting the highscores in a file
	public Highscores(String fileName){
		this.fileName = fileName;
		this.highscores = readHighscores();
		updateArray();
		writeHighscores();
	}
	
	//reading the highscores by using ObjectInputStream and catching errors
	@SuppressWarnings("unchecked")
	public ArrayList<String> readHighscores(){
		highscores = new ArrayList<String>();
		try {
            inputStream = new ObjectInputStream(new FileInputStream(fileName));
            highscores = (ArrayList<String>) inputStream.readObject();
            return highscores;
        } catch (FileNotFoundException e) {
            System.out.println("[Reading] File-not-found-error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[Reading] IO-error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[Reading] Class-not-found-error: " + e.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println("IO-error: " + e.getMessage());
            }
        }
		return highscores;
	}
	
	//overwriting the file data to match the new information using ObjectOutputStream and catching errors.
	//by using FileOutputStream the program simply creates a new file, if one is not found.
	public void writeHighscores(){
		try {
            outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            outputStream.writeObject(highscores);
        } catch (FileNotFoundException e) {
            System.out.println("[Writing] File-not-found-error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[Writing] IO-error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Writing] Error: " + e.getMessage());
            }
        }
	}
	
	//updating the highscores array, so only the top 10 is shown
	public void updateArray(){
		if (highscores.size() != 0){
			
			float valueToInsert = Float.parseFloat(highscores.get(highscores.size()-1).split(": ")[1]);
			
			int pointer = highscores.size()-1;
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
	
	//checking if the new score is on the top 10
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
	
	//adding a new score to the array and inserting it in the correct position
	public void addNewHighscore(String name, float score){
		highscores.add(name+": "+score);
		updateArray();
		writeHighscores();
	}
	
	//a getter
	public ArrayList<String> getHighscores(){
		return highscores;
	}
	

}

