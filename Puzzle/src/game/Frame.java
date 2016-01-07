package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import startMenu.MenuPanel;
import game.*;

public class Frame extends JFrame {

	private int n;
	private int x;
	private int y;
	private Panel panel;
	private Model model;
	
	public Frame(String str, int n){
		this.setSize(500, 500);
		this.setLocation(200,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(str);	
		this.n = n;
		this.panel = new Panel(n);
		this.model = new Model(panel);
		Listener list = new Listener(panel);
		this.addKeyListener(list);
		x = n-1;
		y=x;
		this.getContentPane().add(panel, "Center");
	
	}

	public void showIt(){
		this.setVisible(true);
	}
	
	public void hideIt() { 
		this.setVisible(false);
	}


}
