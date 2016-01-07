package startMenu;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

import startMenu.MenuPanel;

<<<<<<< HEAD:Puzzle/src/startMenu/MenuFrame.java
public class MenuFrame extends JFrame{
	public MenuFrame(String str){
=======
public class Frame extends JFrame{
	private MenuPanel menuPanel;
	
	public Frame(String str){
>>>>>>> 8bd4123ae77a812314611db38c629a1b68713ac7:Puzzle/src/startMenu/Frame.java
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
