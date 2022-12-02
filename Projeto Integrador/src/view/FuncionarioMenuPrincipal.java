package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;

//import model.factorys.FactoryScreens;
import controller.ControllerFuncionarioMenuPrincipal;

public class FuncionarioMenuPrincipal extends  JFrame /*implements ActionListener*/{

    private JButton btnProduto, btnCliente, btnFornecedor, btnVenda, btnDeslogar;
    private ImageIcon imgFundoTela;
    private JLabel lblFundoTela;
    private JFrame container;
    private ActionListener controller;

    public FuncionarioMenuPrincipal(ControllerFuncionarioMenuPrincipal ctrl) {
    	
    	container = new JFrame(); 
    	setScreenDefaultSettings();
    	setImageBackground();
    	
    	controller = ctrl; 
    	
    	btnProduto = createButton("Produtos", 50, 350, 200, 50);
    	btnCliente = createButton("Clientes", 275, 350, 200, 50);
    	btnFornecedor = createButton("Fornecedores", 500, 350, 200, 50);
    	btnVenda = createButton("Vendas", 725, 350, 200, 50);
        btnDeslogar = createButton("Deslogar", 50, 625, 100, 50);

        container.setVisible(true);
    }
    
    private void setScreenDefaultSettings() {
    	container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	container.setSize(1000, 750);
    	container.setTitle("Menu");
    	container.setLocationRelativeTo(null);
    	container.setLayout(null);
        setResizable(false);
    }
    
    private void setImageBackground() {
    	imgFundoTela = new ImageIcon(".\\src\\imagens\\fundo_menu.png");
        lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 1000, 750 );
        container.setContentPane(lblFundoTela);
    }
    
    private JButton createButton(String mensagem, int xPosition, int yPosition, int width, int height) {
    	JButton btn = new JButton(mensagem);
    	btn.setBounds(xPosition,yPosition,width,height);
    	btn.addActionListener(controller);
        container.add(btn);
        return btn;
    }
    
	public JFrame getContainer() {
		return container;
	}

	public void setContainer(JFrame container) {
		this.container = container;
	}

}