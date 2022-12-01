package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.ControllerAdminFornecedorMenu;
import model.factorys.FactoryScreens;

public class AdminFornecedorMenu extends JFrame{
    
	private JFrame container;
	private JButton btnCadastrarFornecedor, btnExcluirFornecedor, btnEditarFornecedor, btnBuscarFornedor, btnVoltarMenu;
    private ImageIcon imgFundoTela;
    private JLabel lblFundoTela;
    private ActionListener controller;

    public AdminFornecedorMenu(ControllerAdminFornecedorMenu ctrl) {

    	container = new JFrame();
    	
    	setImageBackground();
    	setScreenDefaultSettings();
    	
    	controller = ctrl;
    	
    	btnCadastrarFornecedor = createButton("Cadastrar novo fornecedor", 50, 350, 200, 50);
    	btnEditarFornecedor = createButton("Editar fornecedor", 275, 350, 200,50);
    	btnExcluirFornecedor = createButton("Excluir fornecedor", 500,350 ,200,50);
    	btnBuscarFornedor = createButton("Cadastrar novo fornecedor", 725,350,200,50);
    	btnVoltarMenu = createButton("Voltar", 50,620 ,100,50);
 
        container.setVisible(true);
    }
    
    private void setImageBackground() {
    	imgFundoTela = new ImageIcon(".\\src\\imagens\\fundo_menu.png");
        lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 1000, 750 );
        container.setContentPane(lblFundoTela);
    }
    
    private void setScreenDefaultSettings() {
    	container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	container.setSize(1000, 750);
    	container.setTitle("Menu para a edicao dos fornecedores");
    	container.setLocationRelativeTo(null);
    	container.setLayout(null);
        container.setResizable(false);
    }
    
    private JButton createButton(String text, int xPosition, int yPosition, int width, int height) {
        JButton btn = new JButton(text);
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

	public JButton getBtnCadastrarFornecedor() {
		return btnCadastrarFornecedor;
	}

	public void setBtnCadastrarFornecedor(JButton btnCadastrarFornecedor) {
		this.btnCadastrarFornecedor = btnCadastrarFornecedor;
	}

	public JButton getBtnExcluirFornecedor() {
		return btnExcluirFornecedor;
	}

	public void setBtnExcluirFornecedor(JButton btnExcluirFornecedor) {
		this.btnExcluirFornecedor = btnExcluirFornecedor;
	}

	public JButton getBtnEditarFornecedor() {
		return btnEditarFornecedor;
	}

	public void setBtnEditarFornecedor(JButton btnEditarFornecedor) {
		this.btnEditarFornecedor = btnEditarFornecedor;
	}

	public JButton getBtnBuscarFornedor() {
		return btnBuscarFornedor;
	}

	public void setBtnBuscarFornedor(JButton btnBuscarFornedor) {
		this.btnBuscarFornedor = btnBuscarFornedor;
	}

	public JButton getBtnVoltarMenu() {
		return btnVoltarMenu;
	}

	public void setBtnVoltarMenu(JButton btnVoltarMenu) {
		this.btnVoltarMenu = btnVoltarMenu;
	}
    
    
}

