package screens;

import javax.swing.*;

import factorys.FactoryScreens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminVendaMenu extends JFrame implements ActionListener {

    JButton btnLancarVenda, btnAcessarHistorico, btnVoltarMenu;
    ImageIcon imgFundoTela;
    JLabel lblFundoTela;

    public AdminVendaMenu() {

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

        btnLancarVenda = new JButton("Lançar venda");
        btnLancarVenda.setBounds(290,350,200,50);
        btnLancarVenda.addActionListener(this);

        btnAcessarHistorico = new JButton("Acessar historico");
        btnAcessarHistorico.setBounds(510, 350, 200,50);
        btnAcessarHistorico.addActionListener(this);
        
        btnVoltarMenu = new JButton("Voltar");
        btnVoltarMenu.setBounds(50,620 ,100,50);
        btnVoltarMenu.addActionListener(this);

        this.add(btnLancarVenda);
        this.add(btnAcessarHistorico);
        this.add(btnVoltarMenu);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed (ActionEvent evt) {
    	
    	FactoryScreens chamaTela = new FactoryScreens();
        if (evt.getSource() == btnLancarVenda) {
            JOptionPane.showMessageDialog(this, "Trocar tela para tela lancar venda");
        }

        if (evt.getSource() == btnAcessarHistorico) {
            JOptionPane.showMessageDialog(this, "Trocar tela para tela de historico de vendas");
        }
        if (evt.getSource() == btnVoltarMenu) {
        	chamaTela.chamaTelaMenuAdmin();
        	this.dispose();
        }

    }
}

