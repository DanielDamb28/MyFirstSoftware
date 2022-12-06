package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.factorys.FactoryScreens;
import controller.ControllerAdminVendaMenu;
import controller.ControllerFuncionarioClienteMenu;

public class FuncionarioClienteMenu extends JFrame /*implements ActionListener*/ {

	private ActionListener controller;
	private JFrame container;
	private JButton btnCadastrarCliente, btnEditarCliente, btnBuscarCliente, btnVoltarMenu;
    private ImageIcon imgFundoTela;
    private JLabel lblFundoTela;

    public FuncionarioClienteMenu(ControllerFuncionarioClienteMenu ctrl) {

    	container = new JFrame();
    	
    	screenDefaultSettings();
    	setBackgroundImage(); 
        
    	controller = ctrl; 
        
        btnCadastrarCliente = createButton("Cadastrar Cliente", 175,350,200,50);
        
        btnEditarCliente = createButton("Editar cliente", 400, 350, 200,50); 

        btnBuscarCliente = createButton("Buscar Cliente", 625,350 ,200,50); 
        
        btnVoltarMenu = createButton("Voltar Menu", 50,620 ,100,50); 
        
        container.setVisible(true);
    }
    
    private JButton createButton(String message, int xPosition, int yPosition, int width, int height) {
    	JButton btn = new JButton(message);
        btn.setBounds(xPosition,yPosition,width,height);
        btn.addActionListener(controller);
        container.add(btn);
        return btn;
    }
    
    private void screenDefaultSettings() {
    	container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	container.setSize(1000, 750);
    	container.setTitle("Menu para a edicao dos clientes");
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
    
	public JFrame getContainer() {
		return container;
	}

	public void setContainer(JFrame container) {
		this.container = container;
	}
	
	public JButton getBtnAdd() {
		return btnCadastrarCliente;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnCadastrarCliente = btnAdd;
	}

	/*
	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}
	*/

	public JButton getBtnUpdate() {
		return btnEditarCliente;
	}

	public void setBtnUpdate(JButton btnUpdate) {
		this.btnEditarCliente = btnUpdate;
	}

	public JButton getBtnSearch() {
		return btnBuscarCliente;
	}

	public void setBtnSearch(JButton btnSearch) {
		this.btnBuscarCliente = btnSearch;
	}

	public JButton getBtnVoltar() {
		return this.btnVoltarMenu;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltarMenu = btnVoltar;
	}


    
}