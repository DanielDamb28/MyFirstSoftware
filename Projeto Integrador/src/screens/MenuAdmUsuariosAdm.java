package menuDeOperacoesAdm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAdmUsuariosAdm extends  JFrame implements ActionListener{

    JButton btnCadastrarUsuario, btnExcluirUsuario, btnBuscarUsuario, btnEditarUsuario;
    ImageIcon imgFundoTela;
    JLabel lblFundoTela;

    public MenuAdmUsuariosAdm() {

        imgFundoTela = new ImageIcon("C:\\Users\\joser\\OneDrive\\IFG\\POO\\Login_Scren\\src\\menuDeOperacoes\\fundo_menu.png");
        lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 1000, 750 );
        this.setContentPane(lblFundoTela);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 750);
        this.setTitle("Menu para a edicao dos clientes");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        setResizable(false);

        btnCadastrarUsuario = new JButton("Cadastrar novo usuario");
        btnCadastrarUsuario.setBounds(50,350,200,50);
        btnCadastrarUsuario.addActionListener(this);

        btnEditarUsuario = new JButton("Editar usuario");
        btnEditarUsuario.setBounds(275, 350, 200,50);
        btnEditarUsuario.addActionListener(this);

        btnExcluirUsuario = new JButton("Excluir usuario");
        btnExcluirUsuario.setBounds(500,350 ,200,50);
        btnExcluirUsuario.addActionListener(this);

        btnBuscarUsuario = new JButton("Buscar usuario");
        btnBuscarUsuario.setBounds(725,350,200,50);
        btnBuscarUsuario.addActionListener(this);

        this.add(btnExcluirUsuario);
        this.add(btnEditarUsuario);
        this.add(btnCadastrarUsuario);
        this.add(btnBuscarUsuario);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed (ActionEvent evt) {

        if (evt.getSource() == btnExcluirUsuario) {
            JOptionPane.showMessageDialog(this, "Trocar tela para tela de excluir usuario");
        }

        if (evt.getSource() == btnEditarUsuario) {
            JOptionPane.showMessageDialog(this, "Trocar tela para tela de edicao usuario");
        }

        if (evt.getSource() == btnCadastrarUsuario) {
            JOptionPane.showMessageDialog(this, "Trocar tela para cadastro de usuario");
        }

        if (evt.getSource() == btnBuscarUsuario) {
            JOptionPane.showMessageDialog(this, "Trocar tela para busca de usuario");
        }

    }
}
