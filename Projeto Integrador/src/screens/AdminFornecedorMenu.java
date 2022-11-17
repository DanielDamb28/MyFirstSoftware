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

    	setImageBackground();
    	setScreenDefaultSettings();
 
        this.setVisible(true);
    }
    
    private void setImageBackground() {
    	imgFundoTela = new ImageIcon(".\\src\\imagens\\fundo_menu.png");
        lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 1000, 750 );
        this.setContentPane(lblFundoTela);
    }
    
    private void setScreenDefaultSettings() {
    	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setSize(1000, 750);
         this.setTitle("Menu para a edicao dos clientes");
         this.setLocationRelativeTo(null);
         this.setLayout(null);
         setResizable(false);
    }
    
    private JButton createButton(String mensagem, int xPosition, int yPosition, int width, int height) {
    	JButton btn = new JButton(mensagem);
    	btn.setBounds(xPosition,yPosition,width,height);
    	btn.addActionListener(this);
        this.add(btn);
        return btn;
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

