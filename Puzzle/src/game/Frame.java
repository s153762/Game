package game;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import startMenu.HighscorePanel;
import startMenu.MenuPanel;
import startMenu.SettingsPanel;
import game.Panel;

public class Frame extends JFrame {

	private int n = 3;
	private int difficulty = 0;
	private Panel panel;
	private MenuPanel menuPanel;
	private SettingsPanel settingsPanel;
	private InGamePanel inGamePanel;
	private HighscorePanel highscorePanel;
	public static double size = 600;
	
	
	public Frame(){
		//constructing frame
		this.setSize((int) (size*1.25),(int) size);
		this.setLocation(100,50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(n*n-1 + " Sliding Puzzle");	
		this.setLayout(new BorderLayout());
		
		//making the panels to the frame
		this.settingsPanel = new SettingsPanel(this,n);
		this.menuPanel = new MenuPanel(this);
		this.inGamePanel = new InGamePanel(this);
		this.panel = new Panel(this.n, getInGamePanel(), this);
		this.highscorePanel = new HighscorePanel(this);

	}
	
	public void showMenu(){
		//Removing previously used panels
		this.getContentPane().remove(settingsPanel);
		this.getContentPane().remove(panel);
		this.getContentPane().remove(getInGamePanel());
		this.getContentPane().remove(highscorePanel);
		
		//showing the menu panel
		this.setTitle(n*n-1 + " Sliding Puzzle");
		this.getContentPane().add(menuPanel, "Center");
		menuPanel.setVisible(true);
		this.revalidate();
	}
	
	public void showGame(){
		//hiding the menu panel
		menuPanel.setVisible(false);
		menuPanel.setFocusable(false);
		
		//making a new panel for with buttons while playing
		setInGamePanel(new InGamePanel(this));
		this.getContentPane().add(inGamePanel, "South");
		inGamePanel.setVisible(true);
		inGamePanel.startGame();
		
		//making a new game panel
		panel = new Panel(n, getInGamePanel(), this);
		
		this.getContentPane().add(panel, "Center");
		panel.setVisible(true);
		panel.requestFocus(true);
		panel.setFocusable(true);
		this.revalidate();
	}
	
	public void showSettings(){
		//hiding the menu panel
		menuPanel.setVisible(false);
		menuPanel.setFocusable(false);
		
		//making a new settings panel
		this.settingsPanel = new SettingsPanel(this,n);
		this.getContentPane().add(settingsPanel, "Center");
		this.revalidate();
	}
	
	public void showHighscore(){
		//hiding the menu panel
		menuPanel.setVisible(false);
		menuPanel.setFocusable(false);
		
		//making a new highscore panel
		this.highscorePanel = new HighscorePanel(this);
		this.getContentPane().add(highscorePanel, "Center");
		this.revalidate();
	}

	public void showIt(){
		this.setVisible(true);
	}

	//getters and setters
	public void setDifficulty(int difficulty){
		this.difficulty = difficulty;
	}
	
	public int getDifficulty() {
		return difficulty;
	}
	
	public Panel getPanel(){
		return panel;
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
	public int getN()
	{
		return n;
	}


	

}
