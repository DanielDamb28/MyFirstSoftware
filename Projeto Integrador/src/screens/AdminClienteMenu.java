package screens;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import conexaopostgree.ConexaoCliente;
import entities.Cliente;
import factorys.FactoryScreens;

public class AdminClienteMenu extends JFrame implements ActionListener{

	private ImageIcon imgFundoTela;
    private JLabel lblFundoTela;
    private JTable table;
    
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private String[] columnNames = {"Nome", "Cpf-Cnpj", "Endereço", "Telefone", "Cep", "Sexo", 
    		"Data_Nascimento", "Data_Cadastro"};
    
    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnUpdate;
    private JButton btnSearch;
    private int buttonWidth = 170;
    private int buttonHeight = 50;
    
    
    DefaultTableModel model = new DefaultTableModel() {
	    public boolean isCellEditable(int row, int column) {
	       return false;
	    }
	};
    
    public AdminClienteMenu() {
    	
    	setImageBackground();
        setDefaultScreenSettings();
        
        model.setColumnIdentifiers(columnNames);
        JTable table = createTable();
        JScrollPane scroll = new JScrollPane(table);
        setScroolPaneDefaultSettings(scroll);
        
        //fillTableWithDataBaseInformation();
        
        btnAdd = createButton("Adicionar Cliente", 120, 80, buttonWidth, buttonHeight);
        btnDelete = createButton("Excluir Cliente", 310, 80, buttonWidth, buttonHeight);
        btnUpdate = createButton("Atualizar Cliente", 510, 80, buttonWidth, buttonHeight);
        btnSearch = createButton("Filtrar", 710, 80, buttonWidth, buttonHeight);
        
        
        setTableLayout(scroll);
        setVisible(true);
    }
    
    private void setImageBackground() {
    	imgFundoTela = new ImageIcon(".\\src\\imagens\\fundo_menu.png");
        lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 1000, 750 );
        this.setContentPane(lblFundoTela);
    }
    
    private void setDefaultScreenSettings() {
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 750);
        this.setTitle("Menu para a edicao dos clientes");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
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
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(110);
        table.getColumnModel().getColumn(4).setPreferredWidth(90);
        table.getColumnModel().getColumn(5).setPreferredWidth(60);
        table.getColumnModel().getColumn(6).setPreferredWidth(140);
        table.getColumnModel().getColumn(7).setPreferredWidth(140);
        
        return table;
    }
    
    private void setScroolPaneDefaultSettings(JScrollPane scroll) {
    	scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setPreferredSize(new Dimension(480, 500));
    }
    
    public void fillTableWithDataBaseInformation() {
    	try {
        	ConexaoCliente conexao = new ConexaoCliente();
        	
        	clientes = conexao.retornaClientes();
        	
        	String nome = "";
        	String cpfCnpj = "";
        	String endereco = "";
        	String telefone = "";
        	String cep = "";
        	char sexo;
        	LocalDate dataNascimento;
        	LocalDate dataCadastro;
        	
        	for(Cliente c: clientes) {
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
    
    private void setTableLayout(JScrollPane scroll) {
    	setLayout(new BorderLayout());
        add(scroll, BorderLayout.SOUTH);
        scroll.setBounds(200, 200, 600, 400);
    }
    
    
    private JButton createButton(String text, int xPosition, int yPosition, int width, int height) {
        JButton btn = new JButton(text);
        btn.setBounds(xPosition,yPosition,width,height);
        btn.addActionListener(this);
        this.add(btn);
        return btn;
    }
    
	public void actionPerformed(ActionEvent e) {
		FactoryScreens chamaTela = new FactoryScreens();
		if(e.getSource() == btnSearch) {
			chamaTela.chamaAdminClienteFiltrar();
		}
	}
	
}