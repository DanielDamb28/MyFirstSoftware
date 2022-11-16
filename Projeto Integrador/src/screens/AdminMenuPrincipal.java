package screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import factorys.FactoryScreens;

public class AdminMenuPrincipal extends  JFrame implements ActionListener{

    JButton btnProduto, btnCliente, btnFornecedor, btnAdmUsuarios, btnVenda, btnDeslogar;
    ImageIcon imgFundoTela;
    JLabel lblFundoTela;

    public AdminMenuPrincipal() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 750);
        this.setTitle("Menu");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        setResizable(false);

        imgFundoTela = new ImageIcon(".\\src\\screens\\fundo_menu.png");
        lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 1000, 750 );
        this.setContentPane(lblFundoTela);

        btnAdmUsuarios = new JButton("Adminstrar usuarios");
        btnAdmUsuarios.setBounds(50,350,170,50);
        btnAdmUsuarios.addActionListener(this);

        btnProduto = new JButton("Produtos");
        btnProduto.setBounds(245, 350, 150,50);
        btnProduto.addActionListener(this);

        btnCliente = new JButton("Clientes");
        btnCliente.setBounds(420,350 ,150,50);
        btnCliente.addActionListener(this);

        btnFornecedor = new JButton("Fornecedores");
        btnFornecedor.setBounds(595 ,350 ,150,50);
        btnFornecedor.addActionListener(this);

        btnVenda = new JButton("Vendas");
        btnVenda.setBounds(770 ,350 ,150,50);
        btnVenda.addActionListener(this);
        
        btnDeslogar = new JButton("Deslogar");
        btnDeslogar.setBounds(50,620 ,100,50);
        btnDeslogar.addActionListener(this);

        this.add(btnProduto);
        this.add(btnAdmUsuarios);
        this.add(btnCliente);
        this.add(btnVenda);
        this.add(btnFornecedor);
        this.add(btnDeslogar);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed (ActionEvent evt) {
    	FactoryScreens chamaTela = new FactoryScreens();
    	
        if (evt.getSource() == btnAdmUsuarios) {
            chamaTela.chamaTelaDeMenuDeUsuarios();
            this.dispose();
        }

        if (evt.getSource() == btnCliente) {
            chamaTela.chamaAdminMenuCliente();
            this.dispose();
        }

        if (evt.getSource() == btnProduto) {
            chamaTela.chamaTelaDeMenuDeProduto();
            this.dispose();
        }

        if (evt.getSource() == btnVenda) {
            chamaTela.chamaTelaDeMenuDeVendas();
            this.dispose();
        }

        if (evt.getSource() == btnFornecedor) {
            chamaTela.chamaTelaDeMenuDeFornecedor();
            this.dispose();
        }
        
        if (evt.getSource() == btnDeslogar) {
        	chamaTela.chamaTelaLogin();
        	this.dispose();
        }

    }

}