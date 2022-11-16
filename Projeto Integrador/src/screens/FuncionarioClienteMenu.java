package screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import factorys.FactoryScreens;

public class FuncionarioClienteMenu extends  JFrame implements ActionListener{

    JButton btnCadastrarCliente, btnEditarCliente, btnBuscarCliente, btnVoltarMenu;
    ImageIcon imgFundoTela;
    JLabel lblFundoTela;

    public FuncionarioClienteMenu() {

    	imgFundoTela = new ImageIcon(".\\src\\screens\\fundo_menu.png");
        lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 1000, 750 );
        this.setContentPane(lblFundoTela);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 750);
        this.setTitle("Menu para a edicao dos clientes");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        setResizable(false);

        btnCadastrarCliente = new JButton("Cadastrar novo cliente");
        btnCadastrarCliente.setBounds(175,350,200,50);
        btnCadastrarCliente.addActionListener(this);

        btnEditarCliente = new JButton("Editar cliente");
        btnEditarCliente.setBounds(400, 350, 200,50);
        btnEditarCliente.addActionListener(this);

        btnBuscarCliente = new JButton("Bucar cliente");
        btnBuscarCliente.setBounds(625,350 ,200,50);
        btnBuscarCliente.addActionListener(this);
        
        btnVoltarMenu = new JButton("Voltar");
        btnVoltarMenu.setBounds(50,620 ,100,50);
        btnVoltarMenu.addActionListener(this);

        this.add(btnCadastrarCliente);
        this.add(btnEditarCliente);
        this.add(btnBuscarCliente);
        this.add(btnVoltarMenu);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed (ActionEvent evt) {
    	
    	FactoryScreens chamaTela = new FactoryScreens();
        if (evt.getSource() == btnCadastrarCliente) {
            JOptionPane.showMessageDialog(this, "Trocar tela para tela de cadastro de cliente");
        }

        if (evt.getSource() == btnEditarCliente) {
            JOptionPane.showMessageDialog(this, "Trocar tela para tela de edicao de clientes");
        }

        if (evt.getSource() == btnBuscarCliente) {
            JOptionPane.showMessageDialog(this, "Trocar tela para busca de cliente");
        }
        if (evt.getSource() == btnVoltarMenu) {
        	chamaTela.chamaTelaMenuFunc();
        	this.dispose();
        }
    }
}