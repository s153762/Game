package startMenu;

import java.awt.BorderLayout;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import game.Frame;
import game.Listener;

public class SettingsPanel extends JPanel implements ChangeListener {
	private Frame frame;
	private int n = 4;
	public SettingsPanel(Frame frame, int n){
	this.n = n;
	this.setLayout(new BorderLayout());
    JSlider slider = new JSlider(JSlider.HORIZONTAL, 3, 100, n);
    this.frame = frame;
    slider.setPaintLabels(true);
    slider.setPaintTicks(true);  
    slider.setMinorTickSpacing(1);
    slider.setMajorTickSpacing(2);

    
	
    ButtonListener buttonList = new ButtonListener(frame);
	
	
	JButton backButton = new JButton("Back to menu");
	this.add(backButton, BorderLayout.SOUTH);
	backButton.addActionListener(buttonList);
    // We'll just use the standard numeric labels for now...
    slider.setLabelTable(slider.createStandardLabels(5,5));
    slider.addChangeListener(this);
    this.add(slider, BorderLayout.CENTER);
	}

	@Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        
        if (!source.getValueIsAdjusting()) {
            int n = (int)source.getValue();
            frame.setN(n);
            
            
        }
    }
 

}
