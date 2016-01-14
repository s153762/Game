package game;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import startMenu.MenuPanel;
import startMenu.SettingsPanel;
import game.Panel;

public class Frame extends JFrame {

	private int n = 3;
	private int hardMode = 0;
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
		
		this.settingsPanel = new SettingsPanel(this,n);
		this.menuPanel = new MenuPanel(this);
		this.inGamePanel = new InGamePanel(this);
		this.panel = new Panel(this.n, getInGamePanel(), this);

	}
	
	public void showMenu(){
		this.setTitle(n*n-1 + " Sliding Puzzle");
		//panel.setVisible(false);
		//panel.setFocusable(false);
		//inGamePanel.setVisible(false);
		//inGamePanel.setFocusable(false);
//		settingsPanel.setVisible(false);
//		settingsPanel.setFocusable(false);
		this.getContentPane().remove(settingsPanel);
		this.getContentPane().remove(panel);
		this.getContentPane().remove(getInGamePanel());
		
		//this.menuPanel = new MenuPanel(this);
		this.getContentPane().add(menuPanel, "Center");
		menuPanel.setVisible(true);
		//menuPanel.setFocusable(true);
		//this.revalidate();
	}
	
	public void showGame(){
		//n = settingsPanel.returnN();
		menuPanel.setVisible(false);
		menuPanel.setFocusable(false);
		
		//this.getContentPane().remove(settingsPanel);
		//this.getContentPane().remove(menuPanel);
	
		//this.setContentPane(menuPanel);
		
		setInGamePanel(new InGamePanel(this));
		this.getContentPane().add(inGamePanel, "South");
		inGamePanel.setVisible(true);
		inGamePanel.startGame();
		
		panel = new Panel(n, getInGamePanel(), this);
		//panel.setDifficulty(this.hardMode);

		this.getContentPane().add(panel, "Center");
		panel.setVisible(true);
		panel.requestFocus(true);
		panel.setFocusable(true);
		this.revalidate();
	}
	
	public void showSettings(){
		this.getContentPane().remove(menuPanel);
		//this.getContentPane().remove(panel);
		//this.getContentPane().remove(inGamePanel);
		menuPanel.setVisible(false);
		menuPanel.setFocusable(false);
		this.settingsPanel = new SettingsPanel(this,n);
		this.getContentPane().add(settingsPanel, "Center");
		//settingsPanel.setVisible(true);
		//settingsPanel.setFocusable(false);
		this.revalidate();
	}
	

	public void showIt(){
		this.setVisible(true);
	}
	
	public void hideIt() { 
		this.setVisible(false);
	}
	public void setHardMode(int hardmode){
		this.hardMode= hardmode;
	}
	public int getHardMode(){
		return hardMode;	
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
