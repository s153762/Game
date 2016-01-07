package startMenu;

import java.awt.event.*;

public class Listener implements ActionListener{
	public void actionPerformed(ActionEvent event){
		String keyPressed = event.getActionCommand();
		
		switch(keyPressed){
			case "Play": System.out.println("Play");
			break;
			
			case "Settings": System.out.println("Settings");
			break;
			
			case "Highscore": System.out.println("Highscore");
			break;
			
			case "Exit": System.out.println("Exit");
		}
	}
	
}
