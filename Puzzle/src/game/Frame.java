package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import startMenu.MenuPanel;
import game.*;

public class Frame extends JFrame {

	private int n;
	private Panel panel;
	
	public Frame(String str){
		this.setSize(500, 500);
		this.setLocation(200,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(str);	
		this.n = 5;
		this.panel = new Panel(this.n);
		
		this.getContentPane().add(panel, "Center");
		
		Listener list = new Listener(panel);
		this.addKeyListener(list);
	
	}

	public void showIt(){
		this.setVisible(true);
	}
	
	public void hideIt() { 
		this.setVisible(false);
	}


}
