package game;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import startMenu.MenuPanel;
import game.Panel;

public class Frame extends JFrame {

	private int n = 3;
	private Panel panel;
	private MenuPanel menuPanel;
	private InGamePanel inGamePanel;
	public static double size = 600;
	
	public Frame(){
		this.setSize((int) (size*1.25),(int) size);
		this.setLocation(100,50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(n*n-1 + " Sliding Puzzle");	
		this.setLayout(new BorderLayout());
		
		menuPanel = new MenuPanel(this);
		setInGamePanel(new InGamePanel(this));
		panel = new Panel(this.n, getInGamePanel());
	}
	
	public void showMenu(){

		this.getContentPane().remove(panel);
		this.getContentPane().remove(getInGamePanel());
		
		this.getContentPane().add(menuPanel, "Center");
		menuPanel.setVisible(true);
	}
	
	public void showGame(){
		menuPanel.setVisible(false);
		menuPanel.setFocusable(false);
		//this.getContentPane().remove(menuPanel);
		
		setInGamePanel(new InGamePanel(this));
		this.getContentPane().add(getInGamePanel(), "South");
		getInGamePanel().setVisible(true);
		
		panel = new Panel(this.n, getInGamePanel());
		this.getContentPane().add(panel, "Center");
		panel.setVisible(true);
		panel.requestFocus(true);
		panel.setFocusable(true);
	}
	

	public void showIt(){
		this.setVisible(true);
	}
	
	public void hideIt() { 
		this.setVisible(false);
	}

	public InGamePanel getInGamePanel() {
		return inGamePanel;
	}

	public void setInGamePanel(InGamePanel inGamePanel) {
		this.inGamePanel = inGamePanel;
	}


}
