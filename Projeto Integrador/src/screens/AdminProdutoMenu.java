package screens;

import javax.swing.*;

import factorys.FactoryScreens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminProdutoMenu extends  JFrame implements ActionListener{

    JButton btnCadastrarProduto, btnExcluirProduto, btnEditarProduto, btnBuscarProduto, btnVoltarMenu;
    ImageIcon imgFundoTela;
    JLabel lblFundoTela;

    public AdminProdutoMenu() {

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

        btnCadastrarProduto = new JButton("Cadastrar novo produto");
        btnCadastrarProduto.setBounds(50,350,200,50);
        btnCadastrarProduto.addActionListener(this);

        btnEditarProduto = new JButton("Editar produto");
        btnEditarProduto.setBounds(275, 350, 200,50);
        btnEditarProduto.addActionListener(this);
        
        btnExcluirProduto = new JButton("Excluir produto");
        btnExcluirProduto.setBounds(500, 350, 200,50);
        btnExcluirProduto.addActionListener(this); 

        btnBuscarProduto = new JButton("Buscar produto");
        btnBuscarProduto.setBounds(725,350 ,200,50);
        btnBuscarProduto.addActionListener(this);
        
        btnVoltarMenu = new JButton("Voltar");
        btnVoltarMenu.setBounds(50,620 ,100,50);
        btnVoltarMenu.addActionListener(this);

        this.add(btnCadastrarProduto);
        this.add(btnEditarProduto);
        this.add(btnBuscarProduto);
        this.add(btnExcluirProduto);
        this.add(btnVoltarMenu);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed (ActionEvent evt) {
    	
    	FactoryScreens chamaTela = new FactoryScreens();
        if (evt.getSource() == btnCadastrarProduto) {
            JOptionPane.showMessageDialog(this, "Trocar tela para tela de cadastro de produto");
        }

        if (evt.getSource() == btnEditarProduto) {
            JOptionPane.showMessageDialog(this, "Trocar tela para tela de edicao de produto");
        }

        if (evt.getSource() == btnExcluirProduto) {
            JOptionPane.showMessageDialog(this, "Trocar tela para tela de exclusao de produto");
        }

        if(evt.getSource() == btnBuscarProduto) {
            JOptionPane.showMessageDialog(this, "Trocar tela para busca de produto");
        }
        if (evt.getSource() == btnVoltarMenu) {
        	chamaTela.chamaTelaMenuFunc();
        	this.dispose();
        }
    }
}
