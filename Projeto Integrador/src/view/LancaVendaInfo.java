package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.ControllerLancaVenda;

public class LancaVendaInfo extends JFrame {

	private  JFrame container;
	private ImageIcon imgFundoTela;
	private JLabel lblFundoTela; 
	
	private JLabel lId;
	private JTextField txtId;
	private JLabel lUnidades;
	private JTextField txtUnidades;
	private JTextField txtModelo;
	private JButton btnPesquisar;
	private JButton btnAdicionar;
	private JTable table;
	    
	    
	private String[] columnNames = {"id", "modelo", "marca", "tamanho", "preço", "unidades"};
	
    DefaultTableModel model = new DefaultTableModel() {
	    public boolean isCellEditable(int row, int column) {
	       return false;
	    }
	};
	
	private JLabel lPrecoTotal;
	private JButton btnFazerVenda;
	
	private ControllerLancaVenda controller;
	
	
	public LancaVendaInfo(ControllerLancaVenda ctrl){
		container = new JFrame();
    	
        setScreenDefaultSettings();
        setImageBackground();
        
        lId = setLabel("Id", 75, 10, 50, 30);
        txtId = setTextField(60, 40, 50, 30);
        
        lUnidades = setLabel("Unidades", 150, 10, 100, 30);
        txtUnidades = setTextField(165, 40, 50, 30);
        
        txtModelo = setTextField(250, 20, 250, 50);
        txtModelo.setFont(new Font("ARIAL", Font.PLAIN, 25));
        txtModelo.setEditable(false);
        
        btnPesquisar = createButton("Pesquisar", 540, 20, 100, 50);
        btnAdicionar = createButton("Adicionar", 660, 20, 100, 50);
        
        model.setColumnIdentifiers(columnNames);
        JTable table = createTable();
        JScrollPane scroll = new JScrollPane(table);
        setScroolPaneDefaultSettings(scroll);
        setTableLayout(scroll);
        container.add(scroll);
        
        lPrecoTotal = setLabel("R$ 000.00", 30, 470, 300, 60);
        lPrecoTotal.setFont(new Font("ARIAL", Font.PLAIN, 60));
        
        btnFazerVenda = createButton("Fazer Venda", 550, 470, 200, 70);
        btnFazerVenda.setFont(new Font("ARIAL", Font.PLAIN, 20));
        
        container.setVisible(true);
	}
	
	private void setScreenDefaultSettings() {
        container.setSize(800, 600);
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
	
	 private JLabel setLabel(String mensagem, int xLabel, int yLabel, int width, int height) {
    	JLabel lbl = new JLabel();
    	lbl = new JLabel(mensagem);
    	lbl.setFont(new Font("ARIAL", Font.PLAIN, 20));
    	lbl.setForeground(Color.white);
    	lbl.setBounds(xLabel,yLabel,width,height);
    	container.add(lbl);
    	return lbl;
    }

	private JTextField setTextField(int xText, int yText, int width, int height) {
    	JTextField txt = new JTextField();
    	txt = new JTextField();
    	txt.setBounds(xText,yText,width,height);
    	container.add(txt);
    	return txt;
    }
	
	private JButton createButton(String text, int xPosition, int yPosition, int width, int height) {
        JButton btn = new JButton(text);
        btn.setBounds(xPosition,yPosition,width,height);
        btn.addActionListener(controller);
        container.add(btn);
        return btn;
    }
	
	private JTable createTable() {
        table = new JTable();
        table.setDefaultRenderer(Object.class, new CellRenderer());
        table.setModel(model);
        table.setFillsViewportHeight(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	
        table.setRowHeight(50);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(110);
        table.getColumnModel().getColumn(4).setPreferredWidth(120);
        table.getColumnModel().getColumn(5).setPreferredWidth(70);
        
        return table;
    }
    
    private void setScroolPaneDefaultSettings(JScrollPane scroll) {
    	scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setPreferredSize(new Dimension(745, 400));
    }
    
    private void setTableLayout(JScrollPane scroll) {
    	setLayout(new BorderLayout());
        add(scroll, BorderLayout.SOUTH);
        scroll.setBounds(20, 130, 745, 300);
    }
	
	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JTextField getTxtUnidades() {
		return txtUnidades;
	}

	public void setTxtUnidades(JTextField txtUnidades) {
		this.txtUnidades = txtUnidades;
	}

	public JTextField getTxtModelo() {
		return txtModelo;
	}

	public void setTxtModelo(JTextField txtModelo) {
		this.txtModelo = txtModelo;
	}

	public JButton getBtnPesquisar() {
		return btnPesquisar;
	}

	public void setBtnPesquisar(JButton btnPesquisar) {
		this.btnPesquisar = btnPesquisar;
	}

	public JButton getBtnAdicionar() {
		return btnAdicionar;
	}

	public void setBtnAdicionar(JButton btnAdicionar) {
		this.btnAdicionar = btnAdicionar;
	}

	public JButton getBtnFazerVenda() {
		return btnFazerVenda;
	}

	public void setBtnFazerVenda(JButton btnFazerVenda) {
		this.btnFazerVenda = btnFazerVenda;
	}

	public JFrame getContainer() {
		return container;
	}

	public void setContainer(JFrame container) {
		this.container = container;
	}
	
	
}
