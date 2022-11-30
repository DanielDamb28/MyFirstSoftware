package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.ControllerAdminUsuarioMenu;
import model.factorys.FactoryScreens;

public class AdminUsuarioMenu extends  JFrame{
	
	JFrame container;
    JButton btnCadastrarUsuario, btnExcluirUsuario, btnBuscarUsuario, btnEditarUsuario, btnVoltarMenu;
    ImageIcon imgFundoTela;
    JLabel lblFundoTela;
    ActionListener controller;

    public AdminUsuarioMenu(ControllerAdminUsuarioMenu ctrl) {
    	
    	controller = ctrl;
    	
    	setBackgroundImage();
    	setScreenDefaultSettings();
    	
    	
    	btnCadastrarUsuario = createButton("Cadastrar novo usuario", 50, 350, 200, 50);
    	btnEditarUsuario = createButton("Editar usuario", 275, 350, 200,50);
    	btnExcluirUsuario = createButton("Excluir usuario", 500,350 ,200,50);
    	btnBuscarUsuario = createButton("Cadastrar novo usuario", 725,350,200,50);
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
