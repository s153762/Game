package game;

import javax.swing.JFrame;

import game.Panel;

public class Frame extends JFrame{
	public Frame(String str){
		this.setSize(500, 500);
		this.setLocation(200,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(str);
		
		Panel panel = new Panel();
		this.getContentPane().add(panel, "Center");

	}
	
	public void showIt(){
		this.setVisible(true);
	}
	
	public void hideIt() { 
		this.setVisible(false);
	}

}
