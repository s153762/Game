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
		
<<<<<<< HEAD
		menuPanel = new MenuPanel(this);
		panel = new Panel(this.n);
		inGamePanel = new InGamePanel(this);
		
=======
		
		this.menuPanel = new MenuPanel(this);
		this.panel = new Panel(this.n);
		this.inGamePanel = new InGamePanel();
>>>>>>> 9c7a90b8f44ff39c1dadb65bd97e9113e3595bf4
		
	}
	
	public void showMenu(){
<<<<<<< HEAD

		this.getContentPane().remove(panel);
		this.getContentPane().remove(inGamePanel);
		
=======
		
		//this.getContentPane().remove(panel);
		//this.getContentPane().remove(inGamePanel);
>>>>>>> 9c7a90b8f44ff39c1dadb65bd97e9113e3595bf4
		this.getContentPane().add(menuPanel, "Center");
		menuPanel.setVisible(true);
	}
	
	public void showGame(){
<<<<<<< HEAD
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
=======
	;
		
		this.getContentPane().remove(menuPanel);
		this.getContentPane().add(panel, "Center");
		panel.getModel().shuffle();
		this.revalidate();
		panel.setFocusable(true);
		panel.requestFocus();
		//panel.setVisible(true);
				//this.getContentPane().add(new JLabel(),"North");
		//this.getContentPane().add(new JLabel(), "East");
		//this.getContentPane().add(new JLabel(), "West");
		//this.addKeyListener(list);
>>>>>>> 9c7a90b8f44ff39c1dadb65bd97e9113e3595bf4
	}
	

	public void showIt(){
		this.setVisible(true);
	}
	
	public void hideIt() { 
		this.setVisible(false);
	}


}
