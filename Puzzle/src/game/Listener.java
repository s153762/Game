package game;

import java.awt.event.*;
import game.*;

public class Listener implements KeyListener, ActionListener {
	private Model model;
	private Panel panel;
	private InGamePanel timePanel;
	
	//constructor
	public Listener(Panel panel, Model model){
		this.panel = panel;
		this.model = model;
	}
	
	//constructor
	public Listener(InGamePanel timePanel){
		this.timePanel = timePanel;
	}
	
	//sends the key pressed to model.movement (if not paused)
	public void keyPressed(KeyEvent e){
		if(!panel.getInGamePanel().getPaused()){
		int c = e.getKeyCode();
		model.movement(c);
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	
	//making the timer
	public void actionPerformed(ActionEvent e) {
		timePanel.updatePanel();
	}


}
