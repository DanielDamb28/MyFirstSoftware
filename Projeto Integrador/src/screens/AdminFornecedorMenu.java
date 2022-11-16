package screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import factorys.FactoryScreens;

public class AdminFornecedorMenu extends JFrame implements ActionListener {
    JButton btnCadastrarFornecedor, btnExcluirFornecedor, btnEditarFornecedor, btnBuscarFornedor, btnVoltarMenu;
    ImageIcon imgFundoTela;
    JLabel lblFundoTela;

    public AdminFornecedorMenu() {

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
        
        btnVoltarMenu = new JButton("Voltar");
        btnVoltarMenu.setBounds(50,620 ,100,50);
        btnVoltarMenu.addActionListener(this);

        this.add(btnCadastrarFornecedor);
        this.add(btnEditarFornecedor);
        this.add(btnExcluirFornecedor);
        this.add(btnBuscarFornedor);
        this.add(btnVoltarMenu);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed (ActionEvent evt) {

    	FactoryScreens chamaTela = new FactoryScreens();
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
        if (evt.getSource() == btnVoltarMenu) {
        	chamaTela.chamaTelaMenuAdmin();
        	this.dispose();
        }
    }
}

