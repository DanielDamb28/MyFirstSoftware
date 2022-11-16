package screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import conexaopostgree.ConexaoLogin;
import entities.Usuario;
import factorys.FactoryScreens;

public class TelaLogin extends JFrame implements ActionListener {

    JPasswordField pswSenha;
    JTextField txtLogin;
    JLabel lblSenha, lblLogin, lblMensagem, lblTitulo;
    JButton btnEntrar;
    JCheckBox chkMostrarSenha;
    ImageIcon imgFundoTela;



    public TelaLogin() {
    	
    	setBackgroundImage();
    	setDefaultScreenSettings();
    	
    	setLoginTextField();
    	setPasswordTextField();
    	
    	setShowPasswordCheckBox();
    	setWarningMessage();
    	
    	setMakeLoginButton();
    	
    	addComponentsToScreen();

        this.setVisible(true);
    }
    
    private void setBackgroundImage() {
    	imgFundoTela = new ImageIcon(".\\src\\imagens\\bg_login.png");
        JLabel lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 1000, 750 );
        setResizable(false);
        this.setContentPane(lblFundoTela);
    }
    
    private void setDefaultScreenSettings() {
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 750);
        this.setTitle("Login");
        this.setLocationRelativeTo(null);
        this.setLayout(null);

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
         chkMostrarSenha.addActionListener(this);
    }
    
    private void setWarningMessage() {
    	lblMensagem = new JLabel("");
        lblMensagem.setBounds(400,570,300,40);
    };
    
    private void setMakeLoginButton() {
        btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(275,570,100,40);
        btnEntrar.addActionListener(this);

    }
    
    private void addComponentsToScreen() {
    	this.add(lblLogin);
        this.add(txtLogin);
        this.add(lblSenha);
        this.add(pswSenha);
        this.add(btnEntrar);
        this.add(chkMostrarSenha);
        this.add(lblMensagem);
    }
    
    public void actionPerformed (ActionEvent evt) {

        if (evt.getSource() == btnEntrar) {
        	
        	FactoryScreens chamaTela = new FactoryScreens();
        	
        	ConexaoLogin login = new ConexaoLogin();
    		String id = txtLogin.getText();;
    		String senha = new String(pswSenha.getPassword());
    		
    		Usuario usuario = login.fazerLogin(id);
    		if(usuario == null) {
    			JOptionPane.showMessageDialog(this, "Usuario não encontrado");
    			txtLogin.setText("");
                pswSenha.setText("");
    		}
    		else if(!senha.equals(usuario.getSenha())) {
    			JOptionPane.showMessageDialog(this ,"Senha inválida!");
    			pswSenha.setText("");
    		} else {
    			System.out.println("Id: " + usuario.getId() + ", Senha: " + usuario.getSenha() + ", Tipo de Acesso: "+  usuario.getTipoAcesso());
    			if(usuario.getTipoAcesso().equals("gerente")) {
    				chamaTela.chamaTelaMenuAdmin();
    				this.dispose();
    			}
    			else if(usuario.getTipoAcesso().equals("usuario")) {
    				chamaTela.chamaTelaMenuFunc();
    				this.dispose();
    			}
    		}
        }

        if(evt.getSource() == chkMostrarSenha) {
            if(chkMostrarSenha.isSelected()) {
                pswSenha.setEchoChar((char)0);
            } else {
                pswSenha.setEchoChar('*');
            }
        }
    }

}
