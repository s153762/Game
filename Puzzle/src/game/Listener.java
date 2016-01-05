package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import game.Model;

public class Listener implements ActionListener{
	private Model model;
	
	public Listener(Model model){
		this.model = model;
	}
	
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(actionCommand.equals("X")){
			//game.taken();
		} else if(actionCommand.equals("O")){
			//game.taken();
		} else{
			System.out.println("ERROR");
		}
	}
	
	
}
