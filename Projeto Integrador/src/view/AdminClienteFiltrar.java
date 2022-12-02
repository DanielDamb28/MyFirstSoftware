package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.ControllerAdminClienteFiltrar;

public class AdminClienteFiltrar extends JFrame{

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
	private ControllerAdminClienteFiltrar controller;
	
	public AdminClienteFiltrar(ControllerAdminClienteFiltrar ctrl) {
		container = new JFrame();
		
		setScreenDefaultSettings();
		
		controller = ctrl;
		
		lPesquisa = new JLabel("Filtrar");
		lPesquisa.setBounds(50, 50, 100, 40);
		lPesquisa.setFont(new Font("Arial", Font.PLAIN, 30));
		container.add(lPesquisa);
		
		tPesquisa = new JTextField();
		tPesquisa.setBounds(200, 50, 300, 50);
		tPesquisa.setFont(new Font("Arial", Font.PLAIN, 25));
		container.add(tPesquisa);
		
		rbCpfCnpj = new JRadioButton();
		rbCpfCnpj.setBounds(70, 150, 30, 30);
		rbCpfCnpj.setSelected(true);
		rbCpfCnpj.addActionListener(controller);
		container.add(rbCpfCnpj);
		
		lCpfCnpj = new JLabel("CPF/CNPJ");
		lCpfCnpj.setBounds(100, 140, 100, 50);
		lCpfCnpj.setFont(new Font("Arial", Font.PLAIN, 20));
		container.add(lCpfCnpj);
		
		
		rbNome = new JRadioButton();
		rbNome.setBounds(250, 150, 30, 30);
		rbNome.addActionListener(controller);
		container.add(rbNome);
		
		lNome = new JLabel("Nome");
		lNome.setBounds(280, 140, 70, 50);
		lNome.setFont(new Font("Arial", Font.PLAIN, 20));
		container.add(lNome);
		
		rbSemFiltro = new JRadioButton();
		rbSemFiltro.setBounds(360, 150, 30, 30);
		rbSemFiltro.addActionListener(controller);
		container.add(rbSemFiltro);
		
		lSemFiltro = new JLabel("Sem Filtro");
		lSemFiltro.setBounds(390, 140, 140, 50);
		lSemFiltro.setFont(new Font("Arial", Font.PLAIN, 20));
		container.add(lSemFiltro);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(350, 350, 200, 50);
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
        setResizable(false);
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

    
    
}
