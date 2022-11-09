package screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuClientesAdm extends  JFrame implements ActionListener{

    JButton btnCadastrarCliente, btnExcluirClinte, btnEditarCliente, btnBuscarCliente;
    ImageIcon imgFundoTela;
    JLabel lblFundoTela;

    public MenuClientesAdm() {

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
        btnCadastrarCliente.setBounds(50,350,200,50);
        btnCadastrarCliente.addActionListener(this);

        btnEditarCliente = new JButton("Editar cliente");
        btnEditarCliente.setBounds(275, 350, 200,50);
        btnEditarCliente.addActionListener(this);

        btnExcluirClinte = new JButton("Excluir cliente");
        btnExcluirClinte.setBounds(500,350 ,200,50);
        btnExcluirClinte.addActionListener(this);

        btnBuscarCliente = new JButton("Bucar cliente");
        btnBuscarCliente.setBounds(725,350 ,200,50);
        btnBuscarCliente.addActionListener(this);

        this.add(btnCadastrarCliente);
        this.add(btnEditarCliente);
        this.add(btnExcluirClinte);
        this.add(btnBuscarCliente);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed (ActionEvent evt) {

        if (evt.getSource() == btnCadastrarCliente) {
            JOptionPane.showMessageDialog(this, "Trocar tela para tela de cadastro de cliente");
        }

        if (evt.getSource() == btnEditarCliente) {
            JOptionPane.showMessageDialog(this, "Trocar tela para tela de edicao de clientes");
        }

        if (evt.getSource() == btnExcluirClinte) {
            JOptionPane.showMessageDialog(this, "Trocar tela para exclusao de cliente");
        }

        if (evt.getSource() == btnBuscarCliente) {
            JOptionPane.showMessageDialog(this, "Trocar tela para busca de cliente");
        }
    }
}