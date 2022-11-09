package menuDeOperacoesAdm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuDoAplicativoAdm extends  JFrame implements ActionListener{

    JButton btnProduto, btnCliente, btnFornecedor, btnAdmUsuarios, btnVenda;
    ImageIcon imgFundoTela;
    JLabel lblFundoTela;

    public MenuDoAplicativoAdm() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 750);
        this.setTitle("Menu");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        setResizable(false);

        imgFundoTela = new ImageIcon("C:\\Users\\joser\\OneDrive\\IFG\\POO\\Login_Scren\\src\\menuDeOperacoes\\fundo_menu.png");
        lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 1000, 750 );
        this.setContentPane(lblFundoTela);

        btnAdmUsuarios = new JButton("Adminstrar usuarios");
        btnAdmUsuarios.setBounds(50,350,150,50);
        btnAdmUsuarios.addActionListener(this);

        btnProduto = new JButton("Produtos");
        btnProduto.setBounds(225, 350, 150,50);
        btnProduto.addActionListener(this);

        btnCliente = new JButton("Clientes");
        btnCliente.setBounds(400,350 ,150,50);
        btnCliente.addActionListener(this);

        btnFornecedor = new JButton("Fornecedores");
        btnFornecedor.setBounds(575 ,350 ,150,50);
        btnFornecedor.addActionListener(this);

        btnVenda = new JButton("Vendas");
        btnVenda.setBounds(750 ,350 ,150,50);
        btnVenda.addActionListener(this);

        this.add(btnProduto);
        this.add(btnAdmUsuarios);
        this.add(btnCliente);
        this.add(btnVenda);
        this.add(btnFornecedor);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed (ActionEvent evt) {

        if (evt.getSource() == btnAdmUsuarios) {
            JOptionPane.showMessageDialog(this, "Trocar tela para administracao de usuarios");
        }

        if (evt.getSource() == btnCliente) {
            JOptionPane.showMessageDialog(this, "Trocar tela para modificacao de clientes");
        }

        if (evt.getSource() == btnProduto) {
            JOptionPane.showMessageDialog(this, "Trocar tela para acesso dos produtos");
        }

        if (evt.getSource() == btnVenda) {
            JOptionPane.showMessageDialog(this, "Trocar tela para acesso de vendas");
        }

        if (evt.getSource() == btnFornecedor) {
            JOptionPane.showMessageDialog(this, "Trocar tela para modificacao de fornecedor");
        }

    }

}