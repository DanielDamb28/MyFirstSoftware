package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.ControllerAdminUsuarioExcluir;

public class AdminUsuarioExcluir {
	private JFrame container;
	private JLabel lblId;
	private JTextArea info;
	private JTextField txtId; 
	private JButton btnProcurarUsuario, btnExcluirUsuario; 
	private ImageIcon imgFundoTela;
	private ControllerAdminUsuarioExcluir controller;


    public AdminUsuarioExcluir(ControllerAdminUsuarioExcluir ctrl) {
    	
    	container = new JFrame();
    	
    	setBackgroundImage();
    	setDefaultScreenSettings();
    	
    	controller = ctrl;
    	
    	setIdTextField();
    	setSearchUserButton();
    	setDelUserButton();
    	
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
    
    private void setIdTextField(){
    	lblId = new JLabel("Id:");
    	lblId.setBounds(50,25,100,35);
    	txtId = new JTextField();
    	txtId.setBounds(116,28,135,30);
    }
    
    private void setSearchUserButton() {
        btnProcurarUsuario = new JButton("Pesquisar");
        btnProcurarUsuario.setBounds(300,25,100,40);
        btnProcurarUsuario.addActionListener(controller);
    }
    
    private void setDelUserButton() {
        btnExcluirUsuario = new JButton("Excluir");
        btnExcluirUsuario.setBounds(450,25,100,40);
        btnExcluirUsuario.addActionListener(controller);
    }
    
    private void addComponentsToScreen() {
    	
    	container.add(lblId);
    	container.add(txtId);
    	container.add(btnProcurarUsuario);
    	container.add(btnExcluirUsuario);
 
    }

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JButton getBtnProcurarUsuario() {
		return btnProcurarUsuario;
	}

	public void setBtnProcurarUsuario(JButton btnProcurarUsuario) {
		this.btnProcurarUsuario = btnProcurarUsuario;
	}

	public JButton getBtnExcluirUsuario() {
		return btnExcluirUsuario;
	}

	public void setBtnExcluirUsuario(JButton btnExcluirUsuario) {
		this.btnExcluirUsuario = btnExcluirUsuario;
	}

	public JTextArea getInfo() {
		return info;
	}

	public void setInfo(JTextArea info) {
		this.info = info;
	}

    
    
}
