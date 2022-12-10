package view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
	
	private JLabel precoTotal;
	private JButton fazerVenda;
	
	
	public LancaVendaInfo(){
		container = new JFrame();
    	
        setScreenDefaultSettings();
        setImageBackground();
        
        setLabel("Id", 20, 20, 50, 30);
        setTextField(70, 20, 150, 30);
        
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
    	lbl.setFont(Font());
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
	
	public static void main(String args[]) {
		new LancaVendaInfo();
	}
}
