package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.factorys.FactoryScreens;

public class FuncionarioMenuPrincipal extends  JFrame implements ActionListener{

    JButton btnProduto, btnCliente, btnFornecedor, btnVenda, btnDeslogar;
    ImageIcon imgFundoTela;
    JLabel lblFundoTela;

    public FuncionarioMenuPrincipal() {
    	
    	setScreenDefaultSettings();
    	setImageBackground();
    	
    	btnProduto = createButton("Produtos", 50, 350, 200, 50);
    	btnCliente = createButton("Clientes", 275, 350, 200, 50);
    	btnFornecedor = createButton("Fornecedores", 500, 350, 200, 50);
    	btnVenda = createButton("Vendas", 725, 350, 200, 50);
        btnDeslogar = createButton("Deslogar", 50, 625, 100, 50);

        this.setVisible(true);
    }
    
    private void setScreenDefaultSettings() {
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 750);
        this.setTitle("Menu");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        setResizable(false);
    }
    
    private void setImageBackground() {
    	imgFundoTela = new ImageIcon(".\\src\\imagens\\fundo_menu.png");
        lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 1000, 750 );
        this.setContentPane(lblFundoTela);
    }
    
    private JButton createButton(String mensagem, int xPosition, int yPosition, int width, int height) {
    	JButton btn = new JButton(mensagem);
    	btn.setBounds(xPosition,yPosition,width,height);
    	btn.addActionListener(this);
        this.add(btn);
        return btn;
    }
    
    public void actionPerformed (ActionEvent evt) {
    	FactoryScreens chamaTela = new FactoryScreens();

        if (evt.getSource() == btnCliente) {
            chamaTela.chamaFuncionarioClienteMenu();
            this.dispose();
        }

        if (evt.getSource() == btnProduto) {
            chamaTela.chamaFuncionarioProdutoMenu();
            this.dispose();
        }

        if (evt.getSource() == btnVenda) {
            chamaTela.chamaFuncionarioVendaMenu();
            this.dispose();
        }

        if (evt.getSource() == btnFornecedor) {
            chamaTela.chamaFuncionarioFornecedorMenu();
            this.dispose();
        }
        
        if (evt.getSource() == btnDeslogar) {
        	chamaTela.chamaTelaLogin();
        	this.dispose();
        }

    }

}