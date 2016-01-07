package startMenu;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

import startMenu.MenuPanel;

public class Frame extends JFrame{
	private MenuPanel menuPanel;
	
	public Frame(String str){
		this.setSize(500, 500);
		this.setLocation(200,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(str);
		this.menuPanel = new MenuPanel();
		this.add(menuPanel);
	}
	
	
	
	public void showIt(){
		this.setVisible(true);
	}
	
	public void hideIt() { 
		this.setVisible(false);
	}
}
