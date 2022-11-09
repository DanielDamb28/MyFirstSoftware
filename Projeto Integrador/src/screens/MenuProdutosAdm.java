package menuDeOperacoesAdm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuProdutosAdm extends  JFrame implements ActionListener{

    JButton btnCadastrarProduto, btnExcluirProduto, btnEditarProduto, btnBuscarProduto;
    ImageIcon imgFundoTela;
    JLabel lblFundoTela;

    public MenuProdutosAdm() {

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

        btnCadastrarProduto = new JButton("Cadastrar novo produto");
        btnCadastrarProduto.setBounds(50,350,200,50);
        btnCadastrarProduto.addActionListener(this);

        btnEditarProduto = new JButton("Editar produto");
        btnEditarProduto.setBounds(275, 350, 200,50);
        btnEditarProduto.addActionListener(this);

        btnExcluirProduto = new JButton("Excluir produto");
        btnExcluirProduto.setBounds(500,350 ,200,50);
        btnExcluirProduto.addActionListener(this);

        btnBuscarProduto = new JButton("Buscar produto");
        btnBuscarProduto.setBounds(725,350 ,200,50);
        btnBuscarProduto.addActionListener(this);

        this.add(btnCadastrarProduto);
        this.add(btnEditarProduto);
        this.add(btnExcluirProduto);
        this.add(btnBuscarProduto);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed (ActionEvent evt) {

        if (evt.getSource() == btnCadastrarProduto) {
            JOptionPane.showMessageDialog(this, "Trocar tela para tela de cadastro de produto");
        }

        if (evt.getSource() == btnEditarProduto) {
            JOptionPane.showMessageDialog(this, "Trocar tela para tela de edicao de produto");
        }

        if (evt.getSource() == btnExcluirProduto) {
            JOptionPane.showMessageDialog(this, "Trocar tela para exclusao de produto");
        }

        if(evt.getSource() == btnBuscarProduto) {
            JOptionPane.showMessageDialog(this, "Trocar tela para busca de produto");
        }
    }
}
