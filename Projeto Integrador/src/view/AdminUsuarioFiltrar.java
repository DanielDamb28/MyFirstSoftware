package view;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.ControllerAdminUsuarioFiltrar;

public class AdminUsuarioFiltrar {
	private JFrame container;
	private JLabel lPesquisa;
	private JTextField tPesquisa;
	private JRadioButton rbId;
	private JLabel lId;
	private JRadioButton rbTipoAcesso;
	private JLabel lTipoAcesso;
	private JRadioButton rbSemFiltro;
	private JLabel lSemFiltro;
	private JButton btnFiltrar;
	private ButtonGroup tipoFiltragem;
	private ControllerAdminUsuarioFiltrar controller;
	private JLabel lblFundoTela; 
	private ImageIcon imgFundoTela;
	
	public AdminUsuarioFiltrar(ControllerAdminUsuarioFiltrar ctrl) {
		container = new JFrame();
		
		setScreenDefaultSettings();
		setImageBackground();
		
		controller = ctrl;
		
		lPesquisa = new JLabel("Filtrar:");
		lPesquisa.setBounds(70, 60, 100, 40);
		lPesquisa.setFont(new Font("Arial", Font.PLAIN, 30));
		container.add(lPesquisa);
		
		tPesquisa = new JTextField();
		tPesquisa.setBounds(170, 59, 360, 50);
		tPesquisa.setFont(new Font("Arial", Font.PLAIN, 25));
		container.add(tPesquisa);
		
		
		rbId = new JRadioButton();
		rbId.setBounds(70, 150, 20, 30);
		rbId.addActionListener(controller);
		container.add(rbId);
		
		lId = new JLabel("Id");
		lId.setBounds(100, 140, 70, 50);
		lId.setFont(new Font("Arial", Font.PLAIN, 20));
		container.add(lId);
		
		rbTipoAcesso = new JRadioButton();
		rbTipoAcesso.setBounds(180, 150, 20, 30);
		rbTipoAcesso.addActionListener(controller);
		container.add(rbTipoAcesso);
		
		lTipoAcesso = new JLabel("Tipo de Acesso");
		lTipoAcesso.setBounds(210, 140, 150, 50);
		lTipoAcesso.setFont(new Font("Arial", Font.PLAIN, 20));
		container.add(lTipoAcesso);
		
		rbSemFiltro = new JRadioButton();
		rbSemFiltro.setBounds(400, 150, 20, 30);
		rbSemFiltro.addActionListener(controller);
		container.add(rbSemFiltro);
		
		lSemFiltro = new JLabel("Sem Filtro");
		lSemFiltro.setBounds(420, 140, 142, 50);
		lSemFiltro.setFont(new Font("Arial", Font.PLAIN, 20));
		container.add(lSemFiltro);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(350, 350, 200, 50);
		btnFiltrar.setFont(new Font("Arial", Font.PLAIN, 30));
		btnFiltrar.addActionListener(controller);
		container.add(btnFiltrar);
		
		
		tipoFiltragem = new ButtonGroup();
		tipoFiltragem.add(rbId);
		tipoFiltragem.add(rbTipoAcesso);
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

	public JTextField gettPesquisa() {
		return tPesquisa;
	}

	public void settPesquisa(JTextField tPesquisa) {
		this.tPesquisa = tPesquisa;
	}

	public JRadioButton getRbTipoAcesso() {
		return rbTipoAcesso;
	}

	public void setRbTipoAcesso(JRadioButton rbTipoAcesso) {
		this.rbTipoAcesso = rbTipoAcesso;
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

	public ButtonGroup getTipoFiltragem() {
		return tipoFiltragem;
	}

	public void setTipoFiltragem(ButtonGroup tipoFiltragem) {
		this.tipoFiltragem = tipoFiltragem;
	}

	public JRadioButton getRbId() {
		return rbId;
	}

	public void setRbId(JRadioButton rbId) {
		this.rbId = rbId;
	}
	
	
}
