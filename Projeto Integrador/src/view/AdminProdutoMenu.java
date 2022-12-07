package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.time.LocalDate;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControllerAdminProdutoMenu;
import model.entities.Cliente;
import model.entities.Produto;

public class AdminProdutoMenu extends  JFrame{
	
	private JFrame container;
	private ImageIcon imgFundoTela;
    private JLabel lblFundoTela;
    private JTable table;
    
    
    private String[] columnNames = {"Id", "Modelo", "Categoria", "Marca", "Setor", "Cor", 
    		"Tamanho", "Preço", "Unidades", "Fornecedor_CNPJ"};
    
    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnUpdate;
    private JButton btnSearch;
    private JButton btnVoltar;
    private int buttonWidth = 170;
    private int buttonHeight = 50;
    private ControllerAdminProdutoMenu controller;
    
    DefaultTableModel model = new DefaultTableModel() {
	    public boolean isCellEditable(int row, int column) {
	       return false;
	    }
	};

 public AdminProdutoMenu(ControllerAdminProdutoMenu ctrl) {
    	
    	container = new JFrame();
    	
        setDefaultScreenSettings();
        setImageBackground();
        
        controller = ctrl;
        
        model.setColumnIdentifiers(columnNames);
        JTable table = createTable();
        JScrollPane scroll = new JScrollPane(table);
        setScroolPaneDefaultSettings(scroll);
        
        //fillTableWithDataBaseInformation();
        
        btnAdd = createButton("Adicionar Produto", 75, 100, buttonWidth, buttonHeight);
        btnDelete = createButton("Excluir Produto", 275, 100, buttonWidth, buttonHeight);
        btnSearch = createButton("Filtrar", 755, 100, buttonWidth, buttonHeight);
        btnVoltar = createButton("Voltar", 10, 10, 80, 50);
        btnUpdate = createButton("Adicionar Produtos ao Estoque", 475, 100, 250, 50);
        
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
        table.getColumnModel().getColumn(0).setPreferredWidth(70);
        table.getColumnModel().getColumn(1).setPreferredWidth(130);
        table.getColumnModel().getColumn(2).setPreferredWidth(130);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(60);
        table.getColumnModel().getColumn(7).setPreferredWidth(80);
        table.getColumnModel().getColumn(8).setPreferredWidth(80);
        table.getColumnModel().getColumn(9).setPreferredWidth(110);
        
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
    
    public void fillTableWithAllDataBaseInformation(List<Produto> produtos) {
    	try {
    	    model.getDataVector().removeAllElements();
    	    model.fireTableDataChanged();
    	    revalidate();
    	
        	String nome = "";
        	String cpfCnpj = "";
        	String endereco = "";
        	String telefone = "";
        	String cep = "";
        	char sexo;
        	LocalDate dataNascimento;
        	LocalDate dataCadastro;
        	
        	for(Produto p: produtos) {
                nome = c.getNome();
                cpfCnpj = c.getCpfCnpj();
                endereco = c.getEndereco();
                telefone = c.getTelefone();
                cep = c.getCep();
                sexo = c.getSexo();
                dataNascimento = c.getDataNascimento();
                dataCadastro = c.getDataCadastro();
                model.addRow(new Object[]{nome, cpfCnpj, endereco, telefone, cep, 
                		sexo, dataNascimento, dataCadastro});
        	}
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }
    
    public void findRowWithDataBaseInformationByCpf(String cpfSearch, List<Produto> produtos) {
    	try {
    	    model.getDataVector().removeAllElements();
    	    model.fireTableDataChanged();
    	    revalidate();
        	
        	String nome = "";
        	String cpfCnpj = "";
        	String endereco = "";
        	String telefone = "";
        	String cep = "";
        	char sexo;
        	LocalDate dataNascimento;
        	LocalDate dataCadastro;
        	
        	for(Produto p: produtos) {
        		cpfCnpj = c.getCpfCnpj().strip();
        		if(cpfCnpj.equals(cpfSearch.strip())) {
        			 nome = c.getNome();
                     endereco = c.getEndereco();
                     telefone = c.getTelefone();
                     cep = c.getCep();
                     sexo = c.getSexo();
                     dataNascimento = c.getDataNascimento();
                     dataCadastro = c.getDataCadastro();
                     model.addRow(new Object[]{nome, cpfCnpj, endereco, telefone, cep, 
                     		sexo, dataNascimento, dataCadastro});
        		}
        	}
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }
    
    public void findRowWithDataBaseInformationByName(String nameSearch, List<Produto> produtos) {
    	try {
    	    model.getDataVector().removeAllElements();
    	    model.fireTableDataChanged();
    	    revalidate();
        	
        	String nome = "";
        	String cpfCnpj = "";
        	String endereco = "";
        	String telefone = "";
        	String cep = "";
        	char sexo;
        	LocalDate dataNascimento;
        	LocalDate dataCadastro;
        	
        	if(nameSearch.equals("")) {
        		nameSearch = "456";
        	}
        	
        	for(Produto p: produtos) {
        		nome = c.getNome();
        		cpfCnpj = c.getCpfCnpj();
        		if(nome.toLowerCase().contains(nameSearch.toLowerCase())) {
        			cpfCnpj = c.getCpfCnpj();
                     endereco = c.getEndereco();
                     telefone = c.getTelefone();
                     cep = c.getCep();
                     sexo = c.getSexo();
                     dataNascimento = c.getDataNascimento();
                     dataCadastro = c.getDataCadastro();
                     model.addRow(new Object[]{nome, cpfCnpj, endereco, telefone, cep, 
                     		sexo, dataNascimento, dataCadastro});
        		}
        	}
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }

	public JFrame getContainer() {
		return container;
	}

	public void setContainer(JFrame container) {
		this.container = container;
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

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
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
