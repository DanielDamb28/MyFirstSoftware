package testes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import conexaopostgree.ConexaoCliente;
import entities.Cliente;

public class TesteTabela extends JFrame implements ActionListener{

	ImageIcon imgFundoTela;
    JLabel lblFundoTela;
    JTable table;
    List<Cliente> clientes = new ArrayList<Cliente>();
    String[] columnNames = {"teste1", "teste2", "teste3"};
    
	
    public TesteTabela() {
    	
    	imgFundoTela = new ImageIcon(".\\src\\screens\\fundo_menu.png");
        lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 1000, 750 );
        this.setContentPane(lblFundoTela);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 750);
        this.setTitle("Menu para a edicao dos clientes");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        setResizable(false);
    	DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table = new JTable();
        table.setModel(model);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
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
        
        setLayout(new BorderLayout());
        add(scroll, BorderLayout.SOUTH);
        setVisible(true);
    }
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
