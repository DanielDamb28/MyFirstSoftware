package screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import factorys.FactoryScreens;

public class MenuDoAplicativoFunc extends  JFrame implements ActionListener{

    JButton btnProduto, btnCliente, btnFornecedor, btnVenda, btnDeslogar;
    ImageIcon imgFundoTela;
    JLabel lblFundoTela;

    public MenuDoAplicativoFunc() {

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

        btnProduto = new JButton("Produtos");
        btnProduto.setBounds(50, 350, 200,50);
        btnProduto.addActionListener(this);

        btnCliente = new JButton("Clientes");
        btnCliente.setBounds(275,350 ,200,50);
        btnCliente.addActionListener(this);

        btnFornecedor = new JButton("Fornecedores");
        btnFornecedor.setBounds(500 ,350 ,200,50);
        btnFornecedor.addActionListener(this);

        btnVenda = new JButton("Vendas");
        btnVenda.setBounds(725 , 350, 200,50);
        btnVenda.addActionListener(this);
        
        btnDeslogar = new JButton("Deslogar");
        btnDeslogar.setBounds(50, 620, 100 ,50);
        btnDeslogar.addActionListener(this);

        this.add(btnProduto);
        this.add(btnCliente);
        this.add(btnVenda);
        this.add(btnFornecedor);
        this.add(btnDeslogar);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed (ActionEvent evt) {
    	FactoryScreens chamaTela = new FactoryScreens();

        if (evt.getSource() == btnCliente) {
            chamaTela.chamaTelaDeMenuClientesFunc();
            this.dispose();
        }

        if (evt.getSource() == btnProduto) {
            chamaTela.chamaTelaDeMenuProdutosFunc();
            this.dispose();
        }

        if (evt.getSource() == btnVenda) {
            chamaTela.chamaTelaDeMenuVendasFunc();
            this.dispose();
        }

        if (evt.getSource() == btnFornecedor) {
            chamaTela.chamaTelaDeMenuFornecedoresFunc();
            this.dispose();
        }
        
        if (evt.getSource() == btnDeslogar) {
        	chamaTela.chamaTelaLogin();
        	this.dispose();
        }

    }

}