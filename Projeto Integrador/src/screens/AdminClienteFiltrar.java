package screens;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AdminClienteFiltrar extends JFrame implements ActionListener{

	
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
	
	public AdminClienteFiltrar() {
		setScreenDefaultSettings();
		
		lPesquisa = new JLabel("Filtrar");
		lPesquisa.setBounds(50, 50, 100, 40);
		lPesquisa.setFont(new Font("Arial", Font.PLAIN, 30));
		this.add(lPesquisa);
		
		tPesquisa = new JTextField();
		tPesquisa.setBounds(200, 50, 300, 50);
		tPesquisa.setFont(new Font("Arial", Font.PLAIN, 25));
		this.add(tPesquisa);
		
		rbCpfCnpj = new JRadioButton();
		rbCpfCnpj.setBounds(70, 150, 30, 30);
		rbCpfCnpj.setSelected(true);
		rbCpfCnpj.addActionListener(this);
		this.add(rbCpfCnpj);
		
		lCpfCnpj = new JLabel("CPF/CNPJ");
		lCpfCnpj.setBounds(100, 140, 100, 50);
		lCpfCnpj.setFont(new Font("Arial", Font.PLAIN, 20));
		this.add(lCpfCnpj);
		
		
		rbNome = new JRadioButton();
		rbNome.setBounds(250, 150, 30, 30);
		rbNome.addActionListener(this);
		this.add(rbNome);
		
		lNome = new JLabel("Nome");
		lNome.setBounds(280, 140, 70, 50);
		lNome.setFont(new Font("Arial", Font.PLAIN, 20));
		this.add(lNome);
		
		rbSemFiltro = new JRadioButton();
		rbSemFiltro.setBounds(360, 150, 30, 30);
		rbSemFiltro.addActionListener(this);
		this.add(rbSemFiltro);
		
		lSemFiltro = new JLabel("Sem Filtro");
		lSemFiltro.setBounds(390, 140, 140, 50);
		lSemFiltro.setFont(new Font("Arial", Font.PLAIN, 20));
		this.add(lSemFiltro);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(350, 350, 200, 50);
		btnFiltrar.setFont(new Font("Arial", Font.PLAIN, 30));
		this.add(btnFiltrar);
		
		
		
		tipoFiltragem = new ButtonGroup();
		tipoFiltragem.add(rbCpfCnpj);
		tipoFiltragem.add(rbNome);
		tipoFiltragem.add(rbSemFiltro);
		
		setVisible(true);
	}
	
    private void setScreenDefaultSettings() {
        this.setSize(600, 450);
        this.setTitle("Menu");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        setResizable(false);
    }
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnFiltrar) {
			if(e.getSource() == rbSemFiltro) {
				
			}
		}
		
	}

}
