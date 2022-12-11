package view;

import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.ControllerAdminClienteCadastro;

public class AdminAdicionaProdutoNoEstoque extends JFrame{
	
	private JFrame container;
	private JLabel lblIdProduto, lblUnidades; 
	private JTextField txtIdProduto, txtUnidades; 
	private JButton btnAdicionarProduto;
	private ImageIcon imgFundoTela;
	private ControllerAdminClienteCadastro controller;
	private MaskFormatter mascaraData = null;


    public AdminAdicionaProdutoNoEstoque(/*ControllerAdminClienteCadastro ctrl*/) {
    	
    	container = new JFrame();
    	
    	//controller = ctrl;
    	
    	setBackgroundImage();
    	setDefaultScreenSettings();
    	
    	lblIdProduto = setLabel("Id do produto:", 50, 170, 100, 35);
    	txtIdProduto = setTextField(130, 175, 270, 30); 
    	
    	lblUnidades = setLabel("Unidades: ", 425, 170, 100, 35);
    	txtUnidades = setTextField(485, 175, 70, 30);
    	
    	setCreateProdutoButton();

    	container.setVisible(true);
    }
    
    private void setBackgroundImage() {
    	imgFundoTela = new ImageIcon(".\\src\\imagens\\AdicionarProduto.png");
        JLabel lblFundoTela = new JLabel();
        lblFundoTela.setIcon(imgFundoTela);
        lblFundoTela.setBounds(0 , 0, 600, 450 );
        container.setResizable(false);
        container.setContentPane(lblFundoTela);
    }
    
    private void setDefaultScreenSettings() {
    	container.setSize(600, 450);
    	container.setTitle("Cadastro de cliente");
    	container.setLocationRelativeTo(null);
    	container.setLayout(null);

    }
    
    private JLabel setLabel(String mensagem, int xLabel, int yLabel, int width, int height) {
    	JLabel lbl = new JLabel();
    	lbl = new JLabel(mensagem);
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
   
    private void setCreateProdutoButton() {
    	btnAdicionarProduto = new JButton("Cadastrar");
    	btnAdicionarProduto.setBounds(450,300,100,40);
    	//btnAdicionarProduto.addActionListener(controller);
        container.add(btnAdicionarProduto);
    }
    
}

