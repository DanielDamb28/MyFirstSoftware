package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.time.LocalDate;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.entities.HistoricoVendas;

public class HistoricoDeVendas extends JFrame{
	
	private JFrame container;
	private ImageIcon imgFundoTela;
	private JLabel lblFundoTela;
	
	private JTable table;
    
    
	private String[] columnNames = {"ID_VENDA", "ID_USUARIO", "CPF_CNPJ_CLIENTE", "PREÇO_TOTAL", "NUMERO_PRODUTOS", "DATA"};
	
    DefaultTableModel model = new DefaultTableModel() {
	    public boolean isCellEditable(int row, int column) {
	       return false;
	    }
	};
	
	public HistoricoDeVendas() {
		container = new JFrame();
		
        setScreenDefaultSettings();
        setImageBackground();
        
        model.setColumnIdentifiers(columnNames);
        JTable table = createTable();
        JScrollPane scroll = new JScrollPane(table);
        setScroolPaneDefaultSettings(scroll);
        setTableLayout(scroll);
        container.add(scroll);
        
        container.setVisible(true);
	}
	
	private void setScreenDefaultSettings() {
        container.setSize(800, 600);
        container.setTitle("Menu");
        container.setLocationRelativeTo(null);
        container.setLayout(null);
        container.setResizable(false);
    }

	private void setImageBackground() {
		imgFundoTela = new ImageIcon(".\\src\\imagens\\fundo_menu.png");
        lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 1000, 750 );
        container.setContentPane(lblFundoTela);
    }
	
	private JTable createTable() {
        table = new JTable();
        table.setDefaultRenderer(Object.class, new CellRenderer());
        table.setModel(model);
        table.setFillsViewportHeight(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	
        table.setRowHeight(50);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(110);
        table.getColumnModel().getColumn(4).setPreferredWidth(170);
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
        scroll.setBounds(20, 20, 760, 520);
    }
    
    public void fillTableWithAllDataBaseInformation(List<HistoricoVendas> vendas) {
    	try {
    	    model.getDataVector().removeAllElements();
    	    model.fireTableDataChanged();
    	    revalidate();
    	
        	int idVenda = 0;
        	float precoTotal = 0;
        	String cliente = "";
        	String usuario = "";
        	int numProdutos = 0;
        	LocalDate data;
        	
        	for(HistoricoVendas c: vendas) {
                idVenda = c.getVenda_id();
                precoTotal = c.getPreco_total();
                cliente = c.getCliente();
                usuario = c.getUsuario();
                numProdutos = c.getNum_produtos();
                data = c.getData();
                model.addRow(new Object[]{idVenda, usuario, cliente,precoTotal, numProdutos, data});
        	}
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
