package telaLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JPasswordField pswSenha;
    JTextField txtLogin;
    JLabel lblSenha, lblLogin, lblMensagem, lblTitulo;
    JButton btnEntrar;
    JCheckBox chkMostrarSenha;
    ImageIcon imgFundoTela;



    MyFrame() {

        imgFundoTela = new ImageIcon("C:\\Users\\joser\\OneDrive\\IFG\\POO\\Login_Scren\\src\\telaLogin\\bg_login.png");
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

        lblMensagem = new JLabel("Mensagem");
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
            String strLogin = txtLogin.getText();
            String strSenha = new String(pswSenha.getPassword());

            if (strLogin.equalsIgnoreCase("Login") && strSenha.equalsIgnoreCase("Senha")) {
                //lblMensagem.setText("Login efetuado com sucesso!");
                JOptionPane.showMessageDialog(this, "Loggin efetuado com Sucesso!!");
            } else {
                //lblMensagem.setText("Acesso negado, tente novamente!");
                JOptionPane.showMessageDialog(this, "Usuario nao encontrado!");
                txtLogin.setText("");
                pswSenha.setText("");
            }

            /*
            para obter o login do usuario: txtLogin.getText();
            para obter a senha do usuario: new String(pswSenha.getPassword();
             */
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
