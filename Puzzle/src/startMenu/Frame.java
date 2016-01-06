package startMenu;

import javax.swing.*;

import startMenu.MenuPanel;

public class Frame extends JFrame{
	public Frame(String str){
		this.setSize(500, 500);
		this.setLocation(200,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(str);
		
		MenuPanel panel = new MenuPanel();
		this.getContentPane().add(new MenuPanel());
	}
	
	public void showIt(){
		this.setVisible(true);
	}
	
	public void hideIt() { 
		this.setVisible(false);
	}
}
