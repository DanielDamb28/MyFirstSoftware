package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.ControllerAdminProdutoMenu;
import model.factorys.FactoryScreens;

public class AdminProdutoMenu extends  JFrame{
	
	private JFrame container;
    private JButton btnCadastrarProduto, btnExcluirProduto, btnEditarProduto, btnBuscarProduto, btnVoltarMenu;
    private ImageIcon imgFundoTela;
    private JLabel lblFundoTela;
    private ActionListener controller;

    public AdminProdutoMenu(ControllerAdminProdutoMenu ctrl) {

    	setBackgroundImage();
    	setScreenDefaultSettings();
    	
    	controller = ctrl;
    	
    	btnCadastrarProduto = createButton("Cadastrar novo produto", 50,350,200,50);
    	btnEditarProduto = createButton("Editar produto", 275, 350, 200,50);
    	btnExcluirProduto = createButton("Excluir produto", 500, 350, 200,50);
    	btnBuscarProduto = createButton("Buscar produto", 725,350 ,200,50);
    	btnVoltarMenu = createButton("Voltar", 50,620 ,100,50);

        this.setVisible(true);
    }

    private void setBackgroundImage() {
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
    
    private JButton createButton(String text, int xPosition, int yPosition, int width, int height) {
        JButton btn = new JButton(text);
        btn.setBounds(xPosition,yPosition,width,height);
        btn.addActionListener(controller);
        container.add(btn);
        return btn;
    }
}
