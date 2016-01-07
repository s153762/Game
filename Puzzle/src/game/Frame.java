package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import startMenu.MenuPanel;
import game.*;

public class Frame extends JFrame {

	private int n = 30;
	private Panel panel;
	private MenuPanel menuPanel;
	private InGamePanel inGamePanel;
	private Listener list;
	public static int size = 500;
	
	public Frame(String str){
		this.setSize(size, size);
		this.setLocation(200,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(str);	
		
		this.panel = new Panel(this.n);
		this.getContentPane().add(panel, "Center");
		
		this.menuPanel = new MenuPanel(this);
		this.getContentPane().add(menuPanel, "Center");
		
		this.inGamePanel = new InGamePanel();
		this.getContentPane().add(inGamePanel, "South");
		
		Listener list = new Listener(panel);
		this.addKeyListener(list);
	
	}
	
	public void showMenu(){
		this.getContentPane().removeKeyListener(list);
		this.getContentPane().remove(panel);
		this.getContentPane().remove(inGamePanel);
		this.getContentPane().add(menuPanel, "Center");
	}
	
	public void showGame(){
		this.getContentPane().removeAll();
		this.getContentPane().add(inGamePanel, "South");
		this.getContentPane().add(panel, "Center");
		this.addKeyListener(list);
	}
	

	public void showIt(){
		this.setVisible(true);
	}
	
	public void hideIt() { 
		this.setVisible(false);
	}


}
