package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.ControllerAdminVendaMenu;
import model.factorys.FactoryScreens;

public class AdminVendaMenu extends JFrame{
	
	private JFrame container;
	private JButton btnLancarVenda, btnAcessarHistorico, btnVoltarMenu;
	private ImageIcon imgFundoTela;
	private JLabel lblFundoTela;
	private ActionListener controller;

    public AdminVendaMenu(ControllerAdminVendaMenu ctrl) {

    	container = new JFrame();
    	
    	setBackgroundImage();
        setScreenDefaultSettings();
        
        controller = ctrl;
        
        btnLancarVenda = createButton("Lançar venda", 290,350,200,50);
        btnAcessarHistorico = createButton("Acessar historico", 510, 350, 200,50);
        btnVoltarMenu = createButton("Voltar", 50,620 ,100,50);

        container.setVisible(true);
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

