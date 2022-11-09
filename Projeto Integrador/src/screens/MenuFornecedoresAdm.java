package screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFornecedoresAdm extends JFrame implements ActionListener {
    JButton btnCadastrarFornecedor, btnExcluirFornecedor, btnEditarFornecedor, btnBuscarFornedor;
    ImageIcon imgFundoTela;
    JLabel lblFundoTela;

    public MenuFornecedoresAdm() {

    	imgFundoTela = new ImageIcon(".\\src\\screens\\fundo_menu.png");
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

        btnCadastrarFornecedor = new JButton("Cadastrar novo fornecedor");
        btnCadastrarFornecedor.setBounds(50,350,200,50);
        btnCadastrarFornecedor.addActionListener(this);

        btnEditarFornecedor = new JButton("Editar fornecedor");
        btnEditarFornecedor.setBounds(275, 350, 200,50);
        btnEditarFornecedor.addActionListener(this);

        btnExcluirFornecedor = new JButton("Excluir fornecedor");
        btnExcluirFornecedor.setBounds(500,350 ,200,50);
        btnExcluirFornecedor.addActionListener(this);

        btnBuscarFornedor = new JButton("Buscar fornecedor");
        btnBuscarFornedor.setBounds(725,350 ,200,50);
        btnBuscarFornedor.addActionListener(this);

        this.add(btnCadastrarFornecedor);
        this.add(btnEditarFornecedor);
        this.add(btnExcluirFornecedor);
        this.add(btnBuscarFornedor);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed (ActionEvent evt) {

        if (evt.getSource() == btnCadastrarFornecedor) {
            JOptionPane.showMessageDialog(this, "Trocar tela para tela de cadastro de fornecedor");
        }

        if (evt.getSource() == btnEditarFornecedor) {
            JOptionPane.showMessageDialog(this, "Trocar tela para tela de edicao de fornecedor");
        }

        if (evt.getSource() == btnExcluirFornecedor) {
            JOptionPane.showMessageDialog(this, "Trocar tela para exclusao de fornecedor");
        }

        if (evt.getSource() == btnBuscarFornedor) {
            JOptionPane.showMessageDialog(this, "Trocar tela para busca de fornecedor");
        }
    }
}

