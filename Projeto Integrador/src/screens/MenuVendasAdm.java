package menuDeOperacoesAdm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuVendasAdm extends JFrame implements ActionListener {

    JButton btnLancarVenda, btnAcessarHistorico;
    ImageIcon imgFundoTela;
    JLabel lblFundoTela;

    public MenuVendasAdm() {

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

        btnLancarVenda = new JButton("Lancar vanda");
        btnLancarVenda.setBounds(290,350,200,50);
        btnLancarVenda.addActionListener(this);

        btnAcessarHistorico = new JButton("Acessar historico");
        btnAcessarHistorico.setBounds(510, 350, 200,50);
        btnAcessarHistorico.addActionListener(this);

        this.add(btnLancarVenda);
        this.add(btnAcessarHistorico);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed (ActionEvent evt) {

        if (evt.getSource() == btnLancarVenda) {
            JOptionPane.showMessageDialog(this, "Trocar tela para tela lancar venda");
        }

        if (evt.getSource() == btnAcessarHistorico) {
            JOptionPane.showMessageDialog(this, "Trocar tela para tela de historico de vendas");
        }

    }
}

