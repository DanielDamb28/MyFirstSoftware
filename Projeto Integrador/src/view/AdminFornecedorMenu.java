package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.ControllerAdminFornecedorMenu;
import model.factorys.FactoryScreens;

public class AdminFornecedorMenu extends JFrame{
    
	private JFrame container;
	//private JButton btnCadastrarFornecedor, btnExcluirFornecedor, btnEditarFornecedor, btnBuscarFornedor, btnVoltarMenu;
    private ImageIcon imgFundoTela;
    private JLabel lblFundoTela;
    private ActionListener controller;

    public AdminFornecedorMenu(ControllerAdminFornecedorMenu ctrl) {

    	setImageBackground();
    	setScreenDefaultSettings();
    	
    	controller = ctrl;
 
        container.setVisible(true);
    }
    
    private void setImageBackground() {
    	imgFundoTela = new ImageIcon(".\\src\\imagens\\fundo_menu.png");
        lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 1000, 750 );
        container.setContentPane(lblFundoTela);
    }
    
    private void setScreenDefaultSettings() {
    	container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	container.setSize(1000, 750);
    	container.setTitle("Menu para a edicao dos clientes");
    	container.setLocationRelativeTo(null);
    	container.setLayout(null);
         setResizable(false);
    }
    
    private JButton createButton(String mensagem, int xPosition, int yPosition, int width, int height) {
    	JButton btn = new JButton(mensagem);
    	btn.setBounds(xPosition,yPosition,width,height);
    	btn.addActionListener(controller);
        this.add(btn);
        return btn;
    }

}

