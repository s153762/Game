package game;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import startMenu.MenuPanel;
import startMenu.SettingsPanel;
import game.Panel;

public class Frame extends JFrame {

	private int n = 4;
	private Panel panel;
	private MenuPanel menuPanel;
	private SettingsPanel settingsPanel;
	private InGamePanel inGamePanel;
	public static double size = 600;
	
	public Frame(){

		this.setSize((int) (size*1.25),(int) size);
		this.setLocation(100,50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(n*n-1 + " Sliding Puzzle");	
		this.setLayout(new BorderLayout());
		settingsPanel = new SettingsPanel(this,n);
		menuPanel = new MenuPanel(this);
		setInGamePanel(new InGamePanel(this));
		panel = new Panel(this.n, getInGamePanel());
	}
	
	public void showMenu(){
		this.setTitle(n*n-1 + " Sliding Puzzle");
		this.getContentPane().remove(settingsPanel);
		
		this.getContentPane().remove(panel);
		this.getContentPane().remove(getInGamePanel());
		
		this.getContentPane().add(menuPanel, "Center");
		menuPanel.setVisible(true);
	}
	
	public void showGame(){
		//n = settingsPanel.returnN();
		menuPanel.setVisible(false);
		menuPanel.setFocusable(false);
		//this.getContentPane().remove(settingsPanel);
		//this.getContentPane().remove(menuPanel);
	
//		this.setContentPane(menuPanel);
		
		

		setInGamePanel(new InGamePanel(this));
		this.getContentPane().add(inGamePanel, "South");
		getInGamePanel().setVisible(true);
		inGamePanel.startGame();
		panel = new Panel(n, getInGamePanel());
		//this.getContentPane().add(panel, "Center");
		//this.setContentPane(panel);
		this.getContentPane().add(panel, "Center");
		panel.setVisible(true);
		panel.requestFocus(true);
		panel.setFocusable(true);
	}
	
	public void showSettings(){
		this.getContentPane().remove(menuPanel);
		menuPanel.setVisible(false);
		menuPanel.setFocusable(false);
		settingsPanel = new SettingsPanel(this,n);
		this.getContentPane().add(settingsPanel, "Center");
		this.revalidate();
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
	
	public void setN(int n)
	{
		this.n=n;
	}
	

}
