package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ControllerAdminClienteCadastro;

public class AdminProdutoCadastro extends JFrame{
	
	private JFrame container;
	private JTextField txtModelo, txtCategoria, txtSetor, txtMarca, txtCor;
	private JTextField txtTamanho, txtPreco, txtUnidades, txtFornecedor;
	private JLabel lblModelo, lblCategoria, lblSetor, lblMarca, lblCor;
	private JLabel lblTamanho, lblPreco, lblUnidades, lblFornecedor; 
	private JButton btnCadastrarProduto;
	private ImageIcon imgFundoTela;
	private ControllerAdminClienteCadastro controller;



    public AdminProdutoCadastro(/*ControllerAdminClienteCadastro ctrl*/) {
    	
    	container = new JFrame();
    	
    	//controller = ctrl;
    	
    	setBackgroundImage();
    	setDefaultScreenSettings();
    	
    	lblModelo = setLabel("Modelo:", 52,25,60,35); /* <---------- */
    	txtModelo = setTextField(98,28,240,30);
    	
    	lblCategoria = setLabel("Categoria:", 50,120,100,35);
    	txtCategoria = setTextField(116,123,110,30);
    	
    	lblSetor = setLabel("Setor:", 52, 215, 100,35);
    	txtSetor = setTextField(115, 220, 135,30);
    	
    	lblMarca = setLabel("Marca:", 270, 215, 100,35);
    	txtMarca = setTextField(312, 220, 85,30);
		
    	lblCor = setLabel("Cor:", 315, 313, 100,35);
		txtCor = setTextField(420, 316, 130,30);
    	
		lblTamanho = setLabel("Tamanho:", 52, 313, 100,35);
    	txtTamanho = setTextField(82, 316, 200,30);
    	
    	lblPreco = setLabel("Preco:", 245, 120, 150,35);
    	txtPreco = setTextField(325, 123, 87,30, "dd/MM/yyyy");
    	
    	lblUnidades = setLabel("Unidades:", 360, 25, 100,35);
    	txtUnidades = setTextField(418, 28, 130,30);
		
    	lblFornecedor = setLabel("Fornecedor:", 420, 215, 100,35);
		txtFornecedor = setTextField(450, 220, 100,30);
    	
    	setCreateProductButton();

    	container.setVisible(true);
    }
    
    private void setBackgroundImage() {
    	imgFundoTela = new ImageIcon(".\\src\\imagens\\fundoCadastroCliente.png");
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
    
    private JTextField setTextField(int xText, int yText, int width, int height, String Mensagem) {
    	JTextField txt = new JTextField();
    	txt.setBounds(xText,yText,width,height);
    	container.add(txt);
    	return txt;
    }
   
    private void setCreateProductButton() {
        btnCadastrarProduto = new JButton("Cadastrar");
        btnCadastrarProduto.setBounds(450,360,100,40);
        btnCadastrarProduto.addActionListener(controller);
        container.add(btnCadastrarProduto);

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

}
