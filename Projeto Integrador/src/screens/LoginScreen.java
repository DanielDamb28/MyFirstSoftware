package screens;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoginScreen extends JFrame implements ActionListener{
	
	
	
	public LoginScreen() {
		
		setTitle("Login");
		setSize(1280,720);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		Container c = getContentPane();
		
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(".\\src\\screens\\background.png"));
		Dimension size = label.getPreferredSize();
		label.setBounds(1920, 1080, size.width, size.height);
	
		c.add(label);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
