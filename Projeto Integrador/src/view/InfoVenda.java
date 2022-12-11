package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ControllerInfoVenda;

public class InfoVenda extends JFrame{
	
	private JFrame container;
	private ImageIcon imgFundoTela;
	private JLabel lblFundoTela;
	
	private JLabel lCpfCliente;
	private JTextField txtCpfCliente;
	private JLabel lTipoDeVenda;
	private JTextField txtTipoDeVenda;
	
	private JButton btnRegistrarVenda;
	
	private ControllerInfoVenda controller;
	
	public InfoVenda(ControllerInfoVenda ctrl) {
		
		container = new JFrame();
		
		controller = ctrl;
		
		setScreenDefaultSettings();
		setImageBackground();
		
		lCpfCliente = setLabel("CPF do Cliente: ", 20, 150, 150, 30);
		txtCpfCliente = setTextField(200, 150, 200, 30);
		
		lTipoDeVenda = setLabel("Tipo De Venda: ", 20, 250, 150, 30);
		txtTipoDeVenda = setTextField(200, 250, 200, 30);
		
		btnRegistrarVenda = createButton("Registrar Venda", 400, 330, 150, 50);
		
		container.setVisible(true);
		
	}
	
	private void setScreenDefaultSettings() {
        container.setSize(600, 450);
        container.setTitle("Menu");
        container.setLocationRelativeTo(null);
        container.setLayout(null);
        setResizable(false);
    }

	private void setImageBackground() {
		imgFundoTela = new ImageIcon(".\\src\\imagens\\fundo_menu.png");
        lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 600, 450 );
        container.setContentPane(lblFundoTela);
    }
	
	 private JLabel setLabel(String mensagem, int xLabel, int yLabel, int width, int height) {
    	JLabel lbl = new JLabel();
    	lbl = new JLabel(mensagem);
    	lbl.setFont(new Font("ARIAL", Font.PLAIN, 20));
    	lbl.setForeground(Color.white);
    	lbl.setBounds(xLabel,yLabel,width,height);
    	container.add(lbl);
    	return lbl;
    }

	private JTextField setTextField(int xText, int yText, int width, int height) {
    	JTextField txt = new JTextField();
    	txt = new JTextField();
    	txt.setBounds(xText,yText,width,height);
    	container.add(txt);
    	return txt;
    }
	
	private JButton createButton(String text, int xPosition, int yPosition, int width, int height) {
        JButton btn = new JButton(text);
        btn.setBounds(xPosition,yPosition,width,height);
        btn.addActionListener(controller);
        container.add(btn);
        return btn;
    }

	public JTextField getTxtCpfCliente() {
		return txtCpfCliente;
	}

	public void setTxtCpfCliente(JTextField txtCpfCliente) {
		this.txtCpfCliente = txtCpfCliente;
	}

	public JTextField getTxtTipoDeVenda() {
		return txtTipoDeVenda;
	}

	public void setTxtTipoDeVenda(JTextField txtTipoDeVenda) {
		this.txtTipoDeVenda = txtTipoDeVenda;
	}

	public JButton getBtnRegistrarVenda() {
		return btnRegistrarVenda;
	}

	public void setBtnRegistrarVenda(JButton btnRegistrarVenda) {
		this.btnRegistrarVenda = btnRegistrarVenda;
	}

	public JFrame getContainer() {
		return container;
	}

	public void setContainer(JFrame container) {
		this.container = container;
	}
	
	
}
