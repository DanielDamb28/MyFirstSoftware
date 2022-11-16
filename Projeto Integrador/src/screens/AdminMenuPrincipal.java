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

        setScreenDefaultSettings();

        setBackgroundImage();
        
        btnAdmUsuarios = createButton("Administrar usuarios", 50, 350, 170, 50);
        btnProduto = createButton("Produtos", 245, 350, 150, 50);
        btnCliente = createButton("Clientes", 420, 350, 150, 50);
        btnFornecedor = createButton("Fornecedores", 595, 350, 150, 50);
        btnVenda = createButton("Vendas", 770, 350, 150, 50);
        btnDeslogar = createButton("Deslogar", 50, 620, 100, 50);
        
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
    
    private void setBackgroundImage() {
    	imgFundoTela = new ImageIcon(".\\src\\imagens\\fundo_menu.png");
        lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 1000, 750 );
        this.setContentPane(lblFundoTela);
    }
    
    private JButton createButton(String message, int xPosition, int yPosition, int width, int height) {
    	JButton btn = new JButton(message);
        btn.setBounds(xPosition,yPosition,width,height);
        btn.addActionListener(this);
        this.add(btn);
        return btn;
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