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
		
		this.panel = new Panel(this.n);
		this.menuPanel = new MenuPanel(this);
		this.inGamePanel = new InGamePanel();
		
	}
	
	public void showMenu(){
		this.getContentPane().remove(panel);
		this.getContentPane().remove(inGamePanel);
		this.getContentPane().add(menuPanel, "Center");
	}
	
	public void showGame(){
		//this.getContentPane().removeAll();
		this.getContentPane().add(inGamePanel, "South");
		this.getContentPane().add(panel);
		panel.setFocusable(true);
		//this.getContentPane().add(new JLabel(),"North");
		//this.getContentPane().add(new JLabel(), "East");
		//this.getContentPane().add(new JLabel(), "West");
		//this.addKeyListener(list);
	}
	

	public void showIt(){
		this.setVisible(true);
	}
	
	public void hideIt() { 
		this.setVisible(false);
	}


}
