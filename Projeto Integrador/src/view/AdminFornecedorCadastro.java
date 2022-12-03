package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ControllerAdminClienteCadastro;
import controller.ControllerAdminFornecedorCadastro;

public class AdminFornecedorCadastro extends JFrame{
	
	private JFrame container;
	private JTextField txtNome, txtCnpj, txtEmail, txtTelefone, txtCep; 
	private JLabel lblNome, lblCnpj, lblEmail, lblTelefone, lblCep; 
	private JLabel lblRua, lblCidadeUF, lblBairro, lblNumero, mensagem; 
	private JTextField txtRua, txtCidadeUF, txtBairro, txtNumero; 
	private JButton btnCadastrarFornecedor;
	private ImageIcon imgFundoTela;
	private ControllerAdminFornecedorCadastro controller;

    public AdminFornecedorCadastro(ControllerAdminFornecedorCadastro ctrl) {
    	
    	container = new JFrame();
    	
    	controller = ctrl;
    	
    	setBackgroundImage();
    	setDefaultScreenSettings();
    	lblNome = setLabel("Nome:", 52,25,60,35);
    	txtNome = setTextField(98,28,240,30);
    	
    	lblCnpj = setLabel("CNPJ:", 50,120,100,35);
    	txtCnpj = setTextField(116,123,110,30);
    	
    	lblEmail = setLabel("Nascimento:", 245, 120, 150,35);
    	txtEmail = setTextField(325, 123, 87,30, "dd/MM/yyyy");
    	
    	lblTelefone = setLabel("Telefone:", 360, 25, 100,35);
    	txtTelefone = setTextField(418, 28, 130,30);
    	
    	lblCidadeUF = setLabel("Cidade-UF:", 52, 215, 100,35);
    	txtCidadeUF = setTextField(115, 220, 135,30);
    	
    	lblBairro = setLabel("Bairro:", 270, 215, 100,35);
    	txtBairro = setTextField(312, 220, 85,30);
		
    	lblNumero = setLabel("Numero/Qdr/Lote:", 315, 313, 100,35);
		txtNumero = setTextField(420, 316, 130,30);
    	
		lblRua = setLabel("Rua:", 52, 313, 100,35);
    	txtRua = setTextField(82, 316, 200,30);
    	
		
    	lblCep = setLabel("Cep:", 420, 215, 100,35);
		txtCep = setTextField(450, 220, 100,30);
    	
    	mensagem = setLabel("", 50, 360, 300, 40);
    	
    	setCreateFornecedorButton();

    	container.setVisible(true);
    }
    
    private void setBackgroundImage() {
    	imgFundoTela = new ImageIcon(".\\src\\imagens\\CadastroFornecedor.png");
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
   
    private void setCreateFornecedorButton() {
        btnCadastrarFornecedor = new JButton("Cadastrar");
        btnCadastrarFornecedor.setBounds(450,360,100,40);
        btnCadastrarFornecedor.addActionListener(controller);
        container.add(btnCadastrarFornecedor);

    }
    
	public JButton getBtnCadastrarFornecedor() {
		return btnCadastrarFornecedor;
	}

	public void setBtnCadastrarFornecedor(JButton btnCadastrarFornecedor) {
		this.btnCadastrarFornecedor = btnCadastrarFornecedor;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JTextField getTxtCnpj() {
		return txtCnpj;
	}

	public void setTxtCnpj(JTextField txtCnpj) {
		this.txtCnpj = txtCnpj;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtDataNasc(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JTextField getTxtTelefone() {
		return txtTelefone;
	}

	public void setTxtTelefone(JTextField txtTelefone) {
		this.txtTelefone = txtTelefone;
	}

	public JTextField getTxtCep() {
		return txtCep;
	}

	public void setTxtCep(JTextField txtCep) {
		this.txtCep = txtCep;
	}
    
    public String getEndereco() {
    	return txtCidadeUF.getText() + ";" + txtBairro.getText() + ";" + txtRua.getText() + ";" + txtNumero.getText();
    }

	public JLabel getMensagem() {
		return mensagem;
	}

	public void setMensagem(JLabel mensagem) {
		this.mensagem = mensagem;
	}
    
}

