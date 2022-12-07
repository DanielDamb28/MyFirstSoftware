package view;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.ControllerAdminProdutoFiltrar;

public class AdminProdutoFiltrar {
	private JFrame container;
	private JLabel lPesquisa;
	private JTextField tPesquisa;
	private JRadioButton rbModelo;
	private JLabel lModelo;
	private JRadioButton rbMarca;
	private JLabel lMarca;
	private JRadioButton rbTamanho;
	private JLabel lTamanho;
	private JRadioButton rbSemFiltro;
	private JLabel lSemFiltro;
	private JButton btnFiltrar;
	private ButtonGroup tipoFiltragem;
	private ControllerAdminProdutoFiltrar controller;
	private JLabel lblFundoTela; 
	private ImageIcon imgFundoTela;
	
	public AdminProdutoFiltrar(ControllerAdminProdutoFiltrar ctrl) {
		container = new JFrame();
		
		setScreenDefaultSettings();
		setImageBackground();
		
		controller = ctrl;
		
		lPesquisa = new JLabel("Filtrar:");
		lPesquisa.setBounds(54, 60, 100, 40);
		lPesquisa.setFont(new Font("Arial", Font.PLAIN, 30));
		container.add(lPesquisa);
		
		tPesquisa = new JTextField();
		tPesquisa.setBounds(150, 59, 360, 50);
		tPesquisa.setFont(new Font("Arial", Font.PLAIN, 25));
		container.add(tPesquisa);
		
		rbModelo = new JRadioButton();
		rbModelo.setBounds(50, 160, 30, 30);
		rbModelo.setSelected(true);
		rbModelo.addActionListener(controller);
		container.add(rbModelo);
		
		lModelo = new JLabel("Modelo");
		lModelo.setBounds(80, 150, 70, 50);
		lModelo.setFont(new Font("Arial", Font.PLAIN, 20));
		container.add(lModelo);
		
		rbMarca = new JRadioButton();
		rbMarca.setBounds(160, 160, 30, 30);
		rbMarca.addActionListener(controller);
		container.add(rbMarca);
		
		lMarca = new JLabel("Marca");
		lMarca.setBounds(190, 150, 70, 50);
		lMarca.setFont(new Font("Arial", Font.PLAIN, 20));
		container.add(lMarca);
		
		rbTamanho = new JRadioButton();
		rbTamanho.setBounds(270, 160, 30, 30);
		rbTamanho.addActionListener(controller);
		container.add(rbTamanho);
		
		lTamanho = new JLabel("Tamanho");
		lTamanho.setBounds(300, 150, 90, 50);
		lTamanho.setFont(new Font("Arial", Font.PLAIN, 20));
		container.add(lTamanho);
		
		rbSemFiltro = new JRadioButton();
		rbSemFiltro.setBounds(400, 160, 30, 30);
		rbSemFiltro.addActionListener(controller);
		container.add(rbSemFiltro);
		
		lSemFiltro = new JLabel("Sem Filtro");
		lSemFiltro.setBounds(430, 150, 140, 50);
		lSemFiltro.setFont(new Font("Arial", Font.PLAIN, 20));
		container.add(lSemFiltro);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(350, 350, 200, 50);
		btnFiltrar.setFont(new Font("Arial", Font.PLAIN, 30));
		btnFiltrar.addActionListener(controller);
		container.add(btnFiltrar);
		
		
		tipoFiltragem = new ButtonGroup();
		tipoFiltragem.add(rbModelo);
		tipoFiltragem.add(rbMarca);
		tipoFiltragem.add(rbTamanho);
		tipoFiltragem.add(rbSemFiltro);
		
		container.setVisible(true);
	}
	
    private void setScreenDefaultSettings() {
        container.setSize(600, 450);
        container.setTitle("Menu");
        container.setLocationRelativeTo(null);
        container.setLayout(null);
        container.setResizable(false);
    }

	private void setImageBackground() {
		imgFundoTela = new ImageIcon(".\\src\\imagens\\TelaFiltrarCliente.png");
        lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 1000, 750 );
        container.setContentPane(lblFundoTela);
    }

    
	

	public JRadioButton getRbModelo() {
		return rbModelo;
	}

	public void setRbModelo(JRadioButton rbModelo) {
		this.rbModelo = rbModelo;
	}

	public JRadioButton getRbMarca() {
		return rbMarca;
	}

	public void setRbMarca(JRadioButton rbMarca) {
		this.rbMarca = rbMarca;
	}

	public JRadioButton getRbTamanho() {
		return rbTamanho;
	}

	public void setRbTamanho(JRadioButton rbTamanho) {
		this.rbTamanho = rbTamanho;
	}

	public JRadioButton getRbSemFiltro() {
		return rbSemFiltro;
	}

	public void setRbSemFiltro(JRadioButton rbSemFiltro) {
		this.rbSemFiltro = rbSemFiltro;
	}

	public JButton getBtnFiltrar() {
		return btnFiltrar;
	}

	public void setBtnFiltrar(JButton btnFiltrar) {
		this.btnFiltrar = btnFiltrar;
	}

	public JTextField gettPesquisa() {
		return tPesquisa;
	}

	public void settPesquisa(JTextField tPesquisa) {
		this.tPesquisa = tPesquisa;
	}
}
