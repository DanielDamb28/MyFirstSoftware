package view;

import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.ControllerLogin;

public class TelaLogin extends JFrame{
	
	private JFrame container;
	private JPasswordField pswSenha;
	private JTextField txtLogin;
	private JLabel lblSenha, lblLogin, lblMensagem, lblTitulo;
	private JButton btnEntrar;
	private JCheckBox chkMostrarSenha;
	private ImageIcon imgFundoTela;
	private ActionListener controller;

	

    public TelaLogin(ControllerLogin ctrl) {
    	
    	container = new JFrame();
    	controller = ctrl;
    	
    	setDefaultScreenSettings();
    	setBackgroundImage();
    	
    	setLoginTextField();
    	setPasswordTextField();
    	
    	
    	setShowPasswordCheckBox();
    	setWarningMessage();
    	
    	setMakeLoginButton();
    	
    	addComponentsToScreen();
    	
    	

        container.setVisible(true);
    }
    
    private void setBackgroundImage() {
    	imgFundoTela = new ImageIcon(".\\src\\imagens\\bg_login.png");
        JLabel lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 1000, 750 );
        setResizable(false);
        container.setContentPane(lblFundoTela);
    }
    
    private void setDefaultScreenSettings() {
    	container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	container.setSize(1000, 750);
    	container.setTitle("Login");
    	container.setLocationRelativeTo(null);
    	container.setLayout(null);

    }
    
    private void setLoginTextField(){
    	lblLogin = new JLabel("Login");
        lblLogin.setBounds(275,425,100,50);
        txtLogin = new JTextField();
        txtLogin.setBounds(335,425,370,50);
    }
    
    private void setPasswordTextField() {
    	lblSenha = new JLabel("Senha");
        lblSenha.setBounds(275, 500, 100,50);
        pswSenha = new JPasswordField();
        pswSenha.setBounds(335, 500, 370,50);
    }
    
    private void setShowPasswordCheckBox() {
    	 chkMostrarSenha = new JCheckBox("Exibir senha");
         chkMostrarSenha.setBounds(600,570,100,40);
         chkMostrarSenha.addActionListener(controller);
    }
    
    private void setWarningMessage() {
    	lblMensagem = new JLabel("");
        lblMensagem.setBounds(400,570,300,40);
    };
    
    private void setMakeLoginButton() {
        btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(275,570,100,40);
        btnEntrar.addActionListener(controller);

    }
    
    private void addComponentsToScreen() {
    	container.add(lblLogin);
    	container.add(txtLogin);
    	container.add(lblSenha);
    	container.add(pswSenha);
    	container.add(btnEntrar);
    	container.add(chkMostrarSenha);
    	container.add(lblMensagem);
    }

	public JFrame receiveContainer() {
		return container;
	}

	public void setContainer(JFrame container) {
		this.container = container;
	}

	public JPasswordField getPswSenha() {
		return pswSenha;
	}

	public void setPswSenha(JPasswordField pswSenha) {
		this.pswSenha = pswSenha;
	}

	public JTextField getTxtLogin() {
		return txtLogin;
	}

	public void setTxtLogin(JTextField txtLogin) {
		this.txtLogin = txtLogin;
	}

	public JButton getBtnEntrar() {
		return btnEntrar;
	}

	public void setBtnEntrar(JButton btnEntrar) {
		this.btnEntrar = btnEntrar;
	}

	public ActionListener getController() {
		return controller;
	}

	public void setController(ActionListener controller) {
		this.controller = controller;
	}
    
    
}
