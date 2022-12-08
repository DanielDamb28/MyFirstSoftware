package view;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.ControllerAdminFornecedorFiltrar;

public class AdminFornecedorFiltrar {
	private JFrame container;
	private JLabel lPesquisa;
	private JTextField tPesquisa;
	private JRadioButton rbCpfCnpj;
	private JLabel lCpfCnpj;
	private JRadioButton rbNome;
	private JLabel lNome;
	private JRadioButton rbSemFiltro;
	private JLabel lSemFiltro;
	private JButton btnFiltrar;
	private ButtonGroup tipoFiltragem;
	private ControllerAdminFornecedorFiltrar controller;
	private JLabel lblFundoTela; 
	private ImageIcon imgFundoTela;
	
	public AdminFornecedorFiltrar(ControllerAdminFornecedorFiltrar ctrl) {
		container = new JFrame();
		
		setScreenDefaultSettings();
		setImageBackground();
		
		controller = ctrl;
		
		lPesquisa = new JLabel("Filtrar:");
		lPesquisa.setBounds(73, 60, 100, 40);
		lPesquisa.setFont(new Font("Arial", Font.PLAIN, 30));
		container.add(lPesquisa);
		
		tPesquisa = new JTextField();
		tPesquisa.setBounds(168, 58, 360, 50);
		tPesquisa.setFont(new Font("Arial", Font.PLAIN, 25));
		container.add(tPesquisa);
		
		rbCpfCnpj = new JRadioButton();
		rbCpfCnpj.setBounds(75, 150, 30, 30);
		rbCpfCnpj.setSelected(true);
		rbCpfCnpj.addActionListener(controller);
		container.add(rbCpfCnpj);
		
		lCpfCnpj = new JLabel("CPF/CNPJ");
		lCpfCnpj.setBounds(105, 140, 100, 50);
		lCpfCnpj.setFont(new Font("Arial", Font.PLAIN, 20));
		container.add(lCpfCnpj);
		
		rbNome = new JRadioButton();
		rbNome.setBounds(255, 150, 30, 30);
		rbNome.addActionListener(controller);
		container.add(rbNome);
		
		lNome = new JLabel("Nome");
		lNome.setBounds(285, 140, 70, 50);
		lNome.setFont(new Font("Arial", Font.PLAIN, 20));
		container.add(lNome);
		
		rbSemFiltro = new JRadioButton();
		rbSemFiltro.setBounds(365, 150, 30, 30);
		rbSemFiltro.addActionListener(controller);
		container.add(rbSemFiltro);
		
		lSemFiltro = new JLabel("Sem Filtro");
		lSemFiltro.setBounds(395, 140, 140, 50);
		lSemFiltro.setFont(new Font("Arial", Font.PLAIN, 20));
		container.add(lSemFiltro);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(350, 250, 200, 50);
		btnFiltrar.setFont(new Font("Arial", Font.PLAIN, 30));
		btnFiltrar.addActionListener(controller);
		container.add(btnFiltrar);
		
		tipoFiltragem = new ButtonGroup();
		tipoFiltragem.add(rbCpfCnpj);
		tipoFiltragem.add(rbNome);
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
		imgFundoTela = new ImageIcon(".\\src\\imagens\\TelaFiltrar.png");
        lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 1000, 750 );
        container.setContentPane(lblFundoTela);
    }

    
	public JRadioButton getRbCpfCnpj() {
		return rbCpfCnpj;
	}

	public void setRbCpfCnpj(JRadioButton rbCpfCnpj) {
		this.rbCpfCnpj = rbCpfCnpj;
	}

	public JRadioButton getRbNome() {
		return rbNome;
	}

	public void setRbNome(JRadioButton rbNome) {
		this.rbNome = rbNome;
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
