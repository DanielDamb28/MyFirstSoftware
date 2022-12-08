package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControllerAdminFornecedorMenu;
import controller.ControllerAdminUsuarioMenu;
import model.entities.Fornecedor;
import model.entities.Usuario;
import model.factorys.FactoryScreens;

public class AdminUsuarioMenu extends  JFrame{
	
	private JFrame container;
	private ImageIcon imgFundoTela;
    private JLabel lblFundoTela;
    private JTable table;
    
    
    private String[] columnNames = {"Id","Tipo de Acesso"};
    
    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnSearch;
    private JButton btnVoltar;
    private int buttonWidth = 170;
    private int buttonHeight = 50;
    private ControllerAdminUsuarioMenu controller;
    
    
    DefaultTableModel model = new DefaultTableModel() {
	    public boolean isCellEditable(int row, int column) {
	       return false;
	    }
	};
    
    public AdminUsuarioMenu(ControllerAdminUsuarioMenu ctrl) {
    	
    	container = new JFrame();
    	
        setDefaultScreenSettings();
        setImageBackground();
        
        controller = ctrl;
        
        model.setColumnIdentifiers(columnNames);
        JTable table = createTable();
        JScrollPane scroll = new JScrollPane(table);
        setScroolPaneDefaultSettings(scroll);
        
        //fillTableWithDataBaseInformation();
        
        btnAdd = createButton("Adicionar Usuario", 225, 100, buttonWidth, buttonHeight);
        btnDelete = createButton("Excluir Usuario", 425, 100, buttonWidth, buttonHeight);
        btnSearch = createButton("Filtrar", 625, 100, buttonWidth, buttonHeight);
        btnVoltar = createButton("Voltar", 10, 10, 80, 50);
        
        setTableLayout(scroll);
        container.add(scroll);
        container.setVisible(true);
    }
    
    private void setImageBackground() {
    	imgFundoTela = new ImageIcon(".\\src\\imagens\\fundo_menu.png");
        lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 1000, 750 );
        container.setContentPane(lblFundoTela);
    }
    
    private void setDefaultScreenSettings() {
    	container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	container.setSize(1000, 750);
    	container.setTitle("Menu para a edicao dos clientes");
    	container.setLocationRelativeTo(null);
    	container.setLayout(null);
        setResizable(false);
    }
    
    private JTable createTable() {
        table = new JTable();
        table.setDefaultRenderer(Object.class, new CellRenderer());
        table.setModel(model);
        table.setFillsViewportHeight(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	
        table.setRowHeight(50);
        table.getColumnModel().getColumn(0).setPreferredWidth(400);
        table.getColumnModel().getColumn(1).setPreferredWidth(500);
        
        return table;
    }
    
    private void setScroolPaneDefaultSettings(JScrollPane scroll) {
    	scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setPreferredSize(new Dimension(1000, 600));
    }
    
    private void setTableLayout(JScrollPane scroll) {
    	setLayout(new BorderLayout());
        add(scroll, BorderLayout.SOUTH);
        scroll.setBounds(0, 250, 1000, 500);
    }
    
    
    private JButton createButton(String text, int xPosition, int yPosition, int width, int height) {
        JButton btn = new JButton(text);
        btn.setBounds(xPosition,yPosition,width,height);
        btn.addActionListener(controller);
        container.add(btn);
        return btn;
    }
    
    public void fillTableWithAllDataBaseInformation(List<Usuario> usuarios) {
    	try {
    	    model.getDataVector().removeAllElements();
    	    model.fireTableDataChanged();
    	    revalidate();
    	    
        	String id = "";
           	String tipoDeAcesso = "";
        	
        	for(Usuario u: usuarios) {
                id = u.getId();
                tipoDeAcesso = u.getTipoAcesso();
                model.addRow(new Object[]{id, tipoDeAcesso});
        	}
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }
    
    public void findRowWithDataBaseInformationById(String idSearch, List<Usuario> usuarios) {
    	try {
    	    model.getDataVector().removeAllElements();
    	    model.fireTableDataChanged();
    	    revalidate();
        	
    	    String id = "";
           	String tipoDeAcesso = "";
        	
        	for(Usuario u: usuarios) {
        		id = u.getId().strip();
        		if(id.equals(idSearch.strip())) {
        			id = u.getId();
                    tipoDeAcesso = u.getTipoAcesso();
                    model.addRow(new Object[]{id, tipoDeAcesso});
        		}
        	}
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }
    
    public void findRowWithDataBaseInformationByTipoAcesso(String tipoAcesso, List<Usuario> usuarios) {
    	try {
    	    model.getDataVector().removeAllElements();
    	    model.fireTableDataChanged();
    	    revalidate();
        	
    	    String id = "";
           	String tipoDeAcesso = "";
        	
        	if(tipoAcesso.equals("")) {
        		tipoAcesso = "456";
        	}
        	
        	for(Usuario u: usuarios) {
        		tipoDeAcesso = u.getTipoAcesso();
        		if(tipoDeAcesso.toLowerCase().contains(tipoAcesso.toLowerCase())) {
        			id = u.getId();
                    tipoDeAcesso = u.getTipoAcesso();
                    model.addRow(new Object[]{id, tipoDeAcesso});
        		}
        	}
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public JFrame getContainer() {
		return container;
	}

	public void setContainer(JFrame container) {
		this.container = container;
	}
    
    
    
}
