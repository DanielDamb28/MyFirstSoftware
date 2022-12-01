package view;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ControllerAdminClienteMenu;

public class AdminClienteExclusao extends JFrame{
    
	private JFrame container;
	private JLabel lblCpfCnpj; 
	private JTextField txtCpfCnpj; 
	private JButton btnEditarCliente, btnExcluirCliente; 
	private ImageIcon imgFundoTela;
	private ControllerAdminClienteMenu controller;


    public AdminClienteExclusao(ControllerAdminClienteMenu ctrl) {
    	
    	container = new JFrame();
    	
    	setBackgroundImage();
    	setDefaultScreenSettings();
    	
    	controller = ctrl;
    	
    	setCpfCnpjTextField();
    	setEditClientButton();
    	setDelClientButton();
    	
    	addComponentsToScreen();

    	container.setVisible(true);
    }
    
    private void setBackgroundImage() {
    	imgFundoTela = new ImageIcon(".\\src\\imagens\\atualizarClienteBg.png");
        JLabel lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 600, 450 );
        container.setResizable(false);
        container.setContentPane(lblFundoTela);
    }
    
    private void setDefaultScreenSettings() {
    	container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	container.setSize(600, 450);
    	container.setTitle("Cadastro de cliente");
    	container.setLocationRelativeTo(null);
    	container.setLayout(null);

    }
    
    private void setCpfCnpjTextField(){
    	lblCpfCnpj = new JLabel("CPF/CNPJ:");
    	lblCpfCnpj.setBounds(50,25,100,35);
    	txtCpfCnpj = new JTextField();
    	txtCpfCnpj.setBounds(116,28,135,30);
    }
    
    private void setEditClientButton() {
        btnEditarCliente = new JButton("Pesquisar");
        btnEditarCliente.setBounds(300,25,100,40);
        btnEditarCliente.addActionListener(controller);
    }
    
    private void setDelClientButton() {
        btnExcluirCliente = new JButton("Excluir");
        btnExcluirCliente.setBounds(450,25,100,40);
        btnExcluirCliente.addActionListener(controller);
    }
    
    private void addComponentsToScreen() {
    	
    	container.add(lblCpfCnpj);
    	container.add(txtCpfCnpj);
    	container.add(btnEditarCliente);
    	container.add(btnExcluirCliente);
 
    }
    
    public void actionPerformed (ActionEvent evt) {

        if (evt.getSource() == btnEditarCliente) {
        	
        	/* BRILHA NO BACKEND DANIBOY */
        }
        
        if (evt.getSource() == btnExcluirCliente) {
        	
        	/* BRILHA NO BACKEND DANIBOY */
        }

    }
}
