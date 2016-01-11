package game;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import startMenu.MenuPanel;
import game.Panel;

public class Frame extends JFrame {

	private int n = 5;
	private Panel panel;
	private MenuPanel menuPanel;
	private InGamePanel inGamePanel;
	public static double size = 600;
	
	public Frame(String str){
		this.setSize((int) (size*1.25),(int) size);
		this.setLocation(100,50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(str);	
		this.setLayout(new BorderLayout());
		
		menuPanel = new MenuPanel(this);
		panel = new Panel(this.n);
		inGamePanel = new InGamePanel(this);
		
		
	}
	
	public void showMenu(){

		this.getContentPane().remove(panel);
		this.getContentPane().remove(inGamePanel);
		
		this.getContentPane().add(menuPanel, "Center");
		menuPanel.setVisible(true);
	}
	
	public void showGame(){
		menuPanel.setVisible(false);
		menuPanel.setFocusable(false);
		//this.getContentPane().remove(menuPanel);
		
		this.getContentPane().add(inGamePanel, "South");
		inGamePanel.setVisible(true);
		
		panel = new Panel(this.n);
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


}
