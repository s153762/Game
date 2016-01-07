package startMenu;

import java.awt.event.*;
import game.*;
import startMenu.*;

public class ButtonListener implements ActionListener{
	private Frame frame;
	
	public ButtonListener(Frame frame){
		this.frame = frame;
	}
	
	public ButtonListener(){
	}
	
	public void actionPerformed(ActionEvent event){
		String buttonPressed = event.getActionCommand();
		
		switch(buttonPressed){
			case "Play": 
				System.out.println("Play");
				frame.showGame();
			break;
			
			case "Settings": 
				System.out.println("Settings");
			break;
				
			case "Highscore": 
				System.out.println("Highscore");
			break;
				
			case "Exit": 
				System.out.println("Exit");
			break;
			
			case "Pause":
				System.out.println("Pause");
			break;
			
			case "Back to menu":
				System.out.println("Back");
			break;
		}
	}
	
}
