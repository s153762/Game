package game;

import java.awt.event.*;
import game.*;

public class Listener implements KeyListener, ActionListener {
	private Model model;
	private Panel panel;
	private InGamePanel timePanel;
	private int n;
	private int x;
	private int y;
	
	public Listener(Panel panel, Model model){
		this.panel = panel;
		this.model = model;
		this.x = model.getX();
		this.y = model.getY();
		this.n = panel.getN();

	}
	
	public Listener(InGamePanel timePanel){
		this.timePanel = timePanel;
	}
	
	public void keyPressed(KeyEvent e){
		int c = e.getKeyCode();
		model.movement(c);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		timePanel.updatePanel();

	}


}
