package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.ControllerAdminProdutoExcluir;

public class AdminProdutoExcluir {
	private JFrame container;
	private JLabel lblId;
	private JTextArea info;
	private JTextField txtId; 
	private JButton btnProcurarProduto, btnExcluirProduto; 
	private ImageIcon imgFundoTela;
	private ControllerAdminProdutoExcluir controller;


    public AdminProdutoExcluir(ControllerAdminProdutoExcluir ctrl) {
    	
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
    	container.setTitle("Excluir Produto");
    	container.setLocationRelativeTo(null);
    	container.setLayout(null);

    }
    
    private void setCpfCnpjTextField(){
    	lblId = new JLabel("Id:");
    	lblId.setBounds(50,25,100,35);
    	txtId = new JTextField();
    	txtId.setBounds(116,28,135,30);
    }
    
    private void setEditClientButton() {
        btnProcurarProduto = new JButton("Pesquisar");
        btnProcurarProduto.setBounds(300,25,100,40);
        btnProcurarProduto.addActionListener(controller);
    }
    
    private void setDelClientButton() {
        btnExcluirProduto = new JButton("Excluir");
        btnExcluirProduto.setBounds(450,25,100,40);
        btnExcluirProduto.addActionListener(controller);
    }
    
    private void addComponentsToScreen() {
    	
    	container.add(lblId);
    	container.add(txtId);
    	container.add(btnProcurarProduto);
    	container.add(btnExcluirProduto);
 
    }

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtCnpj(JTextField txtId) {
		this.txtId = txtId;
	}

	public JButton getBtnProcurarProduto() {
		return btnProcurarProduto;
	}

	public void setBtnEditarProduto(JButton btnProcurarCliente) {
		this.btnProcurarProduto = btnProcurarCliente;
	}

	public JButton getBtnExcluirProduto() {
		return btnExcluirProduto;
	}

	public void setBtnExcluirProduto(JButton btnExcluirCliente) {
		this.btnExcluirProduto = btnExcluirCliente;
	}

	public JTextArea getInfo() {
		return info;
	}

	public void setInfo(JTextArea info) {
		this.info = info;
	}
}
