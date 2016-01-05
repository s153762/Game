package game;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Model;

public class Panel extends JPanel{
private Model model;
private int number;

	
	public Panel(){
		model = new Model(this);
		GridLayout gLay = new GridLayout(3,3);
		this.setLayout(gLay);
		this.number = 3;
		
		
		JLabel number1 = new JLabel("1");
		JLabel number2 = new JLabel("2");
		JLabel number3 = new JLabel("3");
		JLabel number4 = new JLabel("4");
		JLabel number5 = new JLabel("5");
		JLabel number6 = new JLabel("6");
		JLabel number7 = new JLabel("7");
		JLabel number8 = new JLabel("8");
		JLabel number0 = new JLabel(" ");
		
		
		this.add(number1, "East");
		this.add(number2, "Center");
		this.add(number3, "Center");
		this.add(number4, "Center");
		this.add(number5, "Center");
		this.add(number6, "Center");
		this.add(number7, "Center");
		this.add(number8, "Center");
		this.add(number0, "Center");
		
	}
	
}
