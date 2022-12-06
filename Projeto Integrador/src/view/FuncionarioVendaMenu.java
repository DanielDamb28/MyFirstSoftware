package view;

import javax.swing.*;

import model.factorys.FactoryScreens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ControllerAdminVendaMenu;
import controller.ControllerFuncionarioVendaMenu;

public class FuncionarioVendaMenu extends JFrame /*implements ActionListener*/ {

    private JButton btnLancarVenda, btnAcessarHistorico, btnVoltarMenu;
    private ImageIcon imgFundoTela;
    private JLabel lblFundoTela;
    private JFrame container;
    private ActionListener controller;

    public FuncionarioVendaMenu(ControllerFuncionarioVendaMenu ctrl) {
    	
    	container = new JFrame();

    	setScreenDefaultSettings(); 

    	setImageBackground(); 
    	
    	controller = ctrl; 
    	
        btnLancarVenda = createButton("Lançar venda", 290,350,200,50);

        btnAcessarHistorico = createButton("Acessar historico", 510, 350, 200,50);
        
        btnVoltarMenu = createButton("Voltar", 50,620 ,100,50);

        container.setVisible(true);
    }

    private void setScreenDefaultSettings() {
    	container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	container.setSize(1000, 750);
    	container.setTitle("Menu");
    	container.setLocationRelativeTo(null);
    	container.setLayout(null);
        setResizable(false);
    }
    
    private void setImageBackground() {
    	imgFundoTela = new ImageIcon(".\\src\\imagens\\fundo_menu.png");
        lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 1000, 750 );
        container.setContentPane(lblFundoTela);
    }
    
    private JButton createButton(String text, int xPosition, int yPosition, int width, int height) {
        JButton btn = new JButton(text);
        btn.setBounds(xPosition,yPosition,width,height);
        btn.addActionListener(controller);
        container.add(btn);
        return btn;
    }

    public JFrame getContainer() {
		return container;
	}

	public void setContainer(JFrame container) {
		this.container = container;
	}

	public JButton getBtnLancarVenda() {
		return btnLancarVenda;
	}

	public void setBtnLancarVenda(JButton btnLancarVenda) {
		this.btnLancarVenda = btnLancarVenda;
	}

	public JButton getBtnAcessarHistorico() {
		return btnAcessarHistorico;
	}

	public void setBtnAcessarHistorico(JButton btnAcessarHistorico) {
		this.btnAcessarHistorico = btnAcessarHistorico;
	}

	public JButton getBtnVoltarMenu() {
		return btnVoltarMenu;
	}

	public void setBtnVoltarMenu(JButton btnVoltarMenu) {
		this.btnVoltarMenu = btnVoltarMenu;
	}
}

