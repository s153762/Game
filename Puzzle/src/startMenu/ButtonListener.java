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
				buttonPanel.pause();
			break;
			
			case "Resume":
				System.out.println("Pause");
				buttonPanel.pause();
			break;
			
			case "Back to menu":
				System.out.println("Back");
				frame.showMenu();
			break;
		}
		
	}
	
}
