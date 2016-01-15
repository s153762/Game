package startMenu;

import java.awt.event.*;
import game.*;
import startMenu.*;

public class ButtonListener implements ActionListener{
	private Frame frame;
	private InGamePanel buttonPanel;
	
	public ButtonListener(Frame frame){
		this.frame = frame;
	}
	
	public ButtonListener(Frame frame, InGamePanel buttonPanel){
		this.frame = frame;
		this.buttonPanel = buttonPanel;
	}
	
	public void actionPerformed(ActionEvent event){
		String buttonPressed = event.getActionCommand();
		
		switch(buttonPressed){
			case "Play": 
				frame.showGame();
			break;
			
			case "Settings": 
				frame.showSettings();
			break;
				
			case "Highscore": 
				frame.showHighscore();
			break;
				
			case "Exit": 
				System.exit(0);
			break;
			
			case "Pause":
				buttonPanel.pause();
			break;
			
			case "Resume":
				buttonPanel.pause();
			break;
			
			case "Back to menu":
				frame.showMenu();
			break;
		}
		
	}
	
}
