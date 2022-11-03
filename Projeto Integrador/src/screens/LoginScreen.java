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

public class LoginScreen extends JFrame implements ActionListener {

    JPasswordField pswSenha;
    JTextField txtLogin;
    JLabel lblSenha, lblLogin, lblMensagem, lblTitulo;
    JButton btnEntrar;
    JCheckBox chkMostrarSenha;
    ImageIcon imgFundoTela;



    public LoginScreen() {

        imgFundoTela = new ImageIcon(".\\src\\screens\\bg_login.png");
        JLabel lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 1000, 750 );
        setResizable(false);
        this.setContentPane(lblFundoTela);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 750);
        this.setTitle("Login");
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        lblLogin = new JLabel("Login");
        lblLogin.setBounds(275,425,100,50);
        txtLogin = new JTextField();
        txtLogin.setBounds(335,425,370,50);

        lblSenha = new JLabel("Senha");
        lblSenha.setBounds(275, 500, 100,50);
        pswSenha = new JPasswordField();
        pswSenha.setBounds(335, 500, 370,50);

        chkMostrarSenha = new JCheckBox("Exibir senha");
        chkMostrarSenha.setBounds(600,570,100,40);
        chkMostrarSenha.addActionListener(this);

        lblMensagem = new JLabel("");
        lblMensagem.setBounds(400,570,300,40);

        btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(275,570,100,40);
        btnEntrar.addActionListener(this);

        this.add(lblLogin);
        this.add(txtLogin);
        this.add(lblSenha);
        this.add(pswSenha);
        this.add(btnEntrar);
        this.add(chkMostrarSenha);
        this.add(lblMensagem);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed (ActionEvent evt) {

        if (evt.getSource() == btnEntrar) {
        	
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
    			lblMensagem.setText("Login Efetuado");
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
