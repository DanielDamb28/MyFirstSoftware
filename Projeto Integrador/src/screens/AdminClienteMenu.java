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

public class AdminClienteMenu extends JFrame implements ActionListener{

	ImageIcon imgFundoTela;
    JLabel lblFundoTela;
    JTable table;
    
    List<Cliente> clientes = new ArrayList<Cliente>();
    String[] columnNames = {"Nome", "Cpf-Cnpj", "Endereço", "Telefone", "Cep", "Sexo", 
    		"Data_Nascimento", "Data_Cadastro"};
    
    JButton btnAdd;
    
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
        
        fillTableWithDataBaseInformation();
        
        createButton("Adicionar Cliente", 50, 80, 170, 50);
        
        setTableLayout(scroll);
        setVisible(true);
    }
    
    public void setImageBackground() {
    	imgFundoTela = new ImageIcon(".\\src\\screens\\fundo_menu.png");
        lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 1000, 750 );
        this.setContentPane(lblFundoTela);
    }
    
    public void setDefaultScreenSettings() {
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 750);
        this.setTitle("Menu para a edicao dos clientes");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        setResizable(false);
    }
    
    public JTable createTable() {
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
    
    public void setScroolPaneDefaultSettings(JScrollPane scroll) {
    	scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setPreferredSize(new Dimension(480, 500));
    }
    
    private void fillTableWithDataBaseInformation() {
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
    
    public void setTableLayout(JScrollPane scroll) {
    	setLayout(new BorderLayout());
        add(scroll, BorderLayout.SOUTH);
        scroll.setBounds(200, 200, 600, 400);
    }
    
    
    public void createButton(String text, int xPosition, int yPosition, int width, int height) {
        btnAdd = new JButton(text);
        btnAdd.setBounds(xPosition,yPosition,width,height);
        btnAdd.addActionListener(this);
        this.add(btnAdd);
    }
    
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	
}