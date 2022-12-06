package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.ControllerAdminMenuPrincipal;
import model.factorys.FactoryScreens;

public class AdminMenuPrincipal extends  JFrame{
	
	private JFrame container;
    private JButton btnProduto, btnCliente, btnFornecedor, btnAdmUsuarios, btnVenda, btnDeslogar;
    private ImageIcon imgFundoTela;
    private JLabel lblFundoTela;
    private ActionListener controller;

    public AdminMenuPrincipal(ControllerAdminMenuPrincipal control) {

        setScreenDefaultSettings();

        setBackgroundImage();
        
        controller = control;
        
        btnAdmUsuarios = createButton("Administrar usuarios", 50, 350, 170, 50);
        btnProduto = createButton("Produtos", 245, 350, 150, 50);
        btnCliente = createButton("Clientes", 420, 350, 150, 50);
        btnFornecedor = createButton("Fornecedores", 595, 350, 150, 50);
        btnVenda = createButton("Vendas", 770, 350, 150, 50);
        btnDeslogar = createButton("Deslogar", 50, 620, 100, 50);
        
        container.setVisible(true);
    }
    
    private void setScreenDefaultSettings() {
    	container = new JFrame();
    	container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	container.setSize(1000, 750);
        container.setTitle("Menu");
        container.setLocationRelativeTo(null);
        container.setLayout(null);
        setResizable(false);
    }
    
    private void setBackgroundImage() {
    	imgFundoTela = new ImageIcon(".\\src\\imagens\\fundo_menu.png");
        lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 1000, 750 );
        container.setContentPane(lblFundoTela);
    }
    
    private JButton createButton(String message, int xPosition, int yPosition, int width, int height) {
    	JButton btn = new JButton(message);
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