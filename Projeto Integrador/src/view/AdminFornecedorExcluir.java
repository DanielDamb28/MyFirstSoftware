package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.ControllerAdminFornecedorExcluir;

public class AdminFornecedorExcluir {
	private JFrame container;
	private JLabel lblCnpj;
	private JTextArea info;
	private JTextField txtCnpj; 
	private JButton btnProcurarFornecedor, btnExcluirFornecedor; 
	private ImageIcon imgFundoTela;
	private ControllerAdminFornecedorExcluir controller;


    public AdminFornecedorExcluir(ControllerAdminFornecedorExcluir ctrl) {
    	
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
    	imgFundoTela = new ImageIcon(".\\src\\imagens\\excluirClienteBg.png");
        JLabel lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 600, 450 );
        container.setResizable(false);
        container.setContentPane(lblFundoTela);
    }
    
    private void setDefaultScreenSettings() {
    	container.setSize(600, 450);
    	container.setTitle("Excluir Fornecedor");
    	container.setLocationRelativeTo(null);
    	container.setLayout(null);

    }
    
    private void setCpfCnpjTextField(){
    	lblCnpj = new JLabel("CNPJ:");
    	lblCnpj.setBounds(50,25,100,35);
    	txtCnpj = new JTextField();
    	txtCnpj.setBounds(116,28,135,30);
    }
    
    private void setEditClientButton() {
        btnProcurarFornecedor = new JButton("Pesquisar");
        btnProcurarFornecedor.setBounds(300,25,100,40);
        btnProcurarFornecedor.addActionListener(controller);
    }
    
    private void setDelClientButton() {
        btnExcluirFornecedor = new JButton("Excluir");
        btnExcluirFornecedor.setBounds(450,25,100,40);
        btnExcluirFornecedor.addActionListener(controller);
    }
    
    private void addComponentsToScreen() {
    	
    	container.add(lblCnpj);
    	container.add(txtCnpj);
    	container.add(btnProcurarFornecedor);
    	container.add(btnExcluirFornecedor);
 
    }

	public JTextField getTxtCnpj() {
		return txtCnpj;
	}

	public void setTxtCnpj(JTextField txtCpfCnpj) {
		this.txtCnpj = txtCpfCnpj;
	}

	public JButton getBtnProcurarFornecedor() {
		return btnProcurarFornecedor;
	}

	public void setBtnEditarFornecedor(JButton btnProcurarCliente) {
		this.btnProcurarFornecedor = btnProcurarCliente;
	}

	public JButton getBtnExcluirFornecedor() {
		return btnExcluirFornecedor;
	}

	public void setBtnExcluirFornecedor(JButton btnExcluirCliente) {
		this.btnExcluirFornecedor = btnExcluirCliente;
	}

	public JTextArea getInfo() {
		return info;
	}

	public void setInfo(JTextArea info) {
		this.info = info;
	}
}
