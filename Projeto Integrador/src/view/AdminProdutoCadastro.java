package view;

import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ControllerAdminProdutoCadastro;

public class AdminProdutoCadastro extends JFrame{
	
	private JFrame container;
	private JTextField txtModelo, txtCategoria, txtSetor, txtMarca, txtCor;
	private JTextField txtTamanho, txtPreco, txtUnidades, txtFornecedor;
	private JLabel lblModelo, lblCategoria, lblSetor, lblMarca, lblCor;
	private JLabel lblTamanho, lblPreco, lblUnidades, lblFornecedor; 
	private JButton btnCadastrarProduto;
	private JComboBox cnpjs;
	private ImageIcon imgFundoTela;
	private ControllerAdminProdutoCadastro controller;



    public AdminProdutoCadastro(ControllerAdminProdutoCadastro ctrl) {
    	
    	container = new JFrame();
    	
    	controller = ctrl;
    	
    	setBackgroundImage();
    	setDefaultScreenSettings();
    	
    	lblModelo = setLabel("Modelo:", 50,25,60,35); /* <---------- */
    	txtModelo = setTextField(100 ,28,120, 30);
    	
    	lblCategoria = setLabel("Categoria:", 240, 25,100,35);
    	txtCategoria = setTextField(300, 28, 95, 30);
    	
    	lblSetor = setLabel("Setor:", 415, 25, 100,35);
    	txtSetor = setTextField(455, 28, 95, 30);
    	
    	lblMarca = setLabel("Marca:", 50, 135, 100,35);
    	txtMarca = setTextField(100, 138, 160, 30);
		
    	lblCor = setLabel("Cor:", 285, 135, 100,35);
		txtCor = setTextField(315, 138, 90, 30);
    
		lblTamanho = setLabel("Tamanho:", 425, 135, 100,35);
    	txtTamanho = setTextField(485, 138, 65, 30);
    	
    	lblPreco = setLabel("Preco:", 50, 245, 150,35);
    	txtPreco = setTextField(95, 247, 60,30);
    	
    	lblUnidades = setLabel("Unidades:", 185, 245, 100,35);
    	txtUnidades = setTextField(245, 247, 45,30);
		
    	lblFornecedor = setLabel("Fornecedor:", 325, 245, 100,35);
    	
    	setCreateProductButton();

    	container.setVisible(true);
    }
    
    private void setBackgroundImage() {
    	imgFundoTela = new ImageIcon(".\\src\\imagens\\CadastroProduto.png");
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
    
   
    private void setCreateProductButton() {
        btnCadastrarProduto = new JButton("Cadastrar");
        btnCadastrarProduto.setBounds(450,325,100,40);
        btnCadastrarProduto.addActionListener(controller);
        container.add(btnCadastrarProduto);

    }
    
    public void setComboBox(List<String> list) {
    	Vector<String> vect = new Vector();
    	for(String a: list) {
    		vect.add(a);
    	}
    	cnpjs = new JComboBox<String>(vect);
    	cnpjs.setSelectedIndex(0);
    	cnpjs.addActionListener(controller);
    	cnpjs.setBounds(400, 247, 150,30);
    	container.add(cnpjs);
    }
    
	public JFrame getContainer() {
		return container;
	}

	public void setContainer(JFrame container) {
		this.container = container;
	}

	public JTextField getTxtModelo() {
		return txtModelo;
	}

	public void setTxtModelo(JTextField txtModelo) {
		this.txtModelo = txtModelo;
	}

	public JTextField getTxtCategoria() {
		return txtCategoria;
	}

	public void setTxtCategoria(JTextField txtCategoria) {
		this.txtCategoria = txtCategoria;
	}

	public JTextField getTxtSetor() {
		return txtSetor;
	}

	public void setTxtSetor(JTextField txtSetor) {
		this.txtSetor = txtSetor;
	}

	public JTextField getTxtMarca() {
		return txtMarca;
	}

	public void setTxtMarca(JTextField txtMarca) {
		this.txtMarca = txtMarca;
	}

	public JTextField getTxtCor() {
		return txtCor;
	}

	public void setTxtCor(JTextField txtCor) {
		this.txtCor = txtCor;
	}

	public JTextField getTxtTamanho() {
		return txtTamanho;
	}

	public void setTxtTamanho(JTextField txtTamanho) {
		this.txtTamanho = txtTamanho;
	}

	public JTextField getTxtPreco() {
		return txtPreco;
	}

	public void setTxtPreco(JTextField txtPreco) {
		this.txtPreco = txtPreco;
	}

	public JTextField getTxtUnidades() {
		return txtUnidades;
	}

	public void setTxtUnidades(JTextField txtUnidades) {
		this.txtUnidades = txtUnidades;
	}

	public JTextField getTxtFornecedor() {
		return txtFornecedor;
	}

	public void setTxtFornecedor(JTextField txtFornecedor) {
		this.txtFornecedor = txtFornecedor;
	}

	public JButton getBtnCadastrarProduto() {
		return btnCadastrarProduto;
	}

	public void setBtnCadastrarProduto(JButton btnCadastrarProduto) {
		this.btnCadastrarProduto = btnCadastrarProduto;
	}

	public JComboBox getCnpjs() {
		return cnpjs;
	}

	public void setCnpjs(JComboBox cnpjs) {
		this.cnpjs = cnpjs;
	}
	
	
}
