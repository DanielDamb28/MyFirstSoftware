package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.ControllerAdminClienteExcluir;

public class AdminClienteExclusao extends JFrame{
    
	private JFrame container;
	private JLabel lblCpfCnpj;
	private JTextArea info;
	private JTextField txtCpfCnpj; 
	private JButton btnProcurarCliente, btnExcluirCliente; 
	private ImageIcon imgFundoTela;
	private ControllerAdminClienteExcluir controller;


    public AdminClienteExclusao(ControllerAdminClienteExcluir ctrl) {
    	
    	container = new JFrame();
    	
    	setBackgroundImage();
    	setDefaultScreenSettings();
    	
    	controller = ctrl;
    	
    	setCpfCnpjTextField();
    	setEditClientButton();
    	setDelClientButton();
    	
    	info = new JTextArea();
    	info.setBounds(45,100,510,280);
    	info.setEditable(false);
    	container.add(info);
    	
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
        btnProcurarCliente = new JButton("Pesquisar");
        btnProcurarCliente.setBounds(300,25,100,40);
        btnProcurarCliente.addActionListener(controller);
    }
    
    private void setDelClientButton() {
        btnExcluirCliente = new JButton("Excluir");
        btnExcluirCliente.setBounds(450,25,100,40);
        btnExcluirCliente.addActionListener(controller);
    }
    
    private void addComponentsToScreen() {
    	
    	container.add(lblCpfCnpj);
    	container.add(txtCpfCnpj);
    	container.add(btnProcurarCliente);
    	container.add(btnExcluirCliente);
 
    }

	public JTextField getTxtCpfCnpj() {
		return txtCpfCnpj;
	}

	public void setTxtCpfCnpj(JTextField txtCpfCnpj) {
		this.txtCpfCnpj = txtCpfCnpj;
	}

	public JButton getBtnProcurarCliente() {
		return btnProcurarCliente;
	}

	public void setBtnEditarCliente(JButton btnProcurarCliente) {
		this.btnProcurarCliente = btnProcurarCliente;
	}

	public JButton getBtnExcluirCliente() {
		return btnExcluirCliente;
	}

	public void setBtnExcluirCliente(JButton btnExcluirCliente) {
		this.btnExcluirCliente = btnExcluirCliente;
	}

	public JTextArea getInfo() {
		return info;
	}

	public void setInfo(JTextArea info) {
		this.info = info;
	}
    
    
}
