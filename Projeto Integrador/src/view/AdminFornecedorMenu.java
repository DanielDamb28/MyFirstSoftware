package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControllerAdminClienteMenu;
import controller.ControllerAdminFornecedorMenu;
import model.entities.Cliente;
import model.entities.Fornecedor;

public class AdminFornecedorMenu extends JFrame{
	
	private JFrame container;
	private ImageIcon imgFundoTela;
    private JLabel lblFundoTela;
    private JTable table;
    
    
    private String[] columnNames = {"Cnpj", "Nome", "Cep", "Endereço", "Telefone", "Email"};
    
    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnSearch;
    private JButton btnVoltar;
    private int buttonWidth = 170;
    private int buttonHeight = 50;
    private ControllerAdminFornecedorMenu controller;
    
    
    DefaultTableModel model = new DefaultTableModel() {
	    public boolean isCellEditable(int row, int column) {
	       return false;
	    }
	};
    
    public AdminFornecedorMenu(ControllerAdminFornecedorMenu ctrl) {
    	
    	container = new JFrame();
    	
        setDefaultScreenSettings();
        setImageBackground();
        
        controller = ctrl;
        
        model.setColumnIdentifiers(columnNames);
        JTable table = createTable();
        JScrollPane scroll = new JScrollPane(table);
        setScroolPaneDefaultSettings(scroll);
        
        //fillTableWithDataBaseInformation();
        
        btnAdd = createButton("Adicionar Fornecedor", 225, 100, buttonWidth, buttonHeight);
        btnDelete = createButton("Excluir Fornecedor", 425, 100, buttonWidth, buttonHeight);
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
        table.getColumnModel().getColumn(0).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setPreferredWidth(180);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(270);
        table.getColumnModel().getColumn(4).setPreferredWidth(90);
        table.getColumnModel().getColumn(5).setPreferredWidth(200);
        
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
    
    public void fillTableWithAllDataBaseInformation(List<Fornecedor> fornecedores) {
    	try {
    	    model.getDataVector().removeAllElements();
    	    revalidate();
    	    
        	String cnpj = "";
        	String nome = "";
           	String cep = "";
        	String endereco = "";
        	String telefone = "";
        	String email = "";
        	
        	for(Fornecedor f: fornecedores) {
                cnpj = f.getCnpj();
                nome = f.getNome();
                endereco = f.getEndereco();
                telefone = f.getTelefone();
                cep = f.getCep();
                email = f.getEmail();
                model.addRow(new Object[]{cnpj, nome, cep, endereco, telefone, email});
        	}
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }
    
    public void findRowWithDataBaseInformationByCnpj(String cpfSearch, List<Fornecedor> fornecedores) {
    	try {
    	    model.getDataVector().removeAllElements();
    	    model.fireTableDataChanged();
        	
    	    String cnpj = "";
        	String nome = "";
           	String cep = "";
        	String endereco = "";
        	String telefone = "";
        	String email = "";
        	
        	for(Fornecedor f: fornecedores) {
        		cnpj = f.getCnpj().strip();
        		if(cnpj.equals(cpfSearch.strip())) {
        			cnpj = f.getCnpj();
                    nome = f.getNome();
                    endereco = f.getEndereco();
                    telefone = f.getTelefone();
                    cep = f.getCep();
                    email = f.getEmail();
                    model.addRow(new Object[]{cnpj, nome, cep, endereco, telefone, email});
        		}
        	}
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }
    
    public void findRowWithDataBaseInformationByName(String nameSearch, List<Fornecedor> fornecedores) {
    	try {
    	    model.getDataVector().removeAllElements();
    	    model.fireTableDataChanged();
        	
    	    String cnpj = "";
        	String nome = "";
           	String cep = "";
        	String endereco = "";
        	String telefone = "";
        	String email = "";
        	
        	if(nameSearch.equals("")) {
        		nameSearch = "456";
        	}
        	
        	for(Fornecedor f: fornecedores) {
        		nome = f.getNome();
        		if(nome.toLowerCase().contains(nameSearch.toLowerCase())) {
        			cnpj = f.getCnpj();
                    nome = f.getNome();
                    endereco = f.getEndereco();
                    telefone = f.getTelefone();
                    cep = f.getCep();
                    email = f.getEmail();
                    model.addRow(new Object[]{cnpj, nome, cep, endereco, telefone, email});
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
    
    
    
}

