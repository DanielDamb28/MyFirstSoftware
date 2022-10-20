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
		setSize(800,450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		Container c = getContentPane();
		
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon("C:\\Users\\danie\\OneDrive\\Área de Trabalho\\Estudos\\Faculdade\\Projeto Integrador\\Projeto Integrador\\src\\screens\\background800.jpg"));
		Dimension size = label.getPreferredSize();
		label.setBounds(800, 450, size.width, size.height);
	
		c.add(label);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
