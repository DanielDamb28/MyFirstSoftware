package view;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ControllerAdminClienteMenu;

public class AdminClienteEditar extends JFrame{
	
	private JFrame container;
	private JTextField txtNome, txtCpfCnpj, txtDataNasc, txtTelefone, txtCep, txtSexo; 
	private JLabel lblNome, lblCpfCnpj, lblDataNasc, lblTelefone, lblCep, lblSexo; 
	private JLabel lblRua, lblCidadeUF, lblBairro, lblNumero; 
	private JTextField txtRua, txtCidadeUF, txtBairro, txtNumero; 
	private JButton btnCadastrarCliente;
	private ImageIcon imgFundoTela;
	private ActionListener controller;



    public AdminClienteEditar(ControllerAdminClienteMenu ctrl) {
    	
    	container = new JFrame();
    	
    	setBackgroundImage();
    	setDefaultScreenSettings();
    	lblCpfCnpj = setLabel("Nome:", 52,25,60,35);
    	txtNome = setTextField(98,28,240,30);
    	txtNome.setEditable(true);
    	
    	lblCpfCnpj = setLabel("CPF/CNPJ:", 50,120,100,35);
    	txtCpfCnpj = setTextField(116,123,110,30);
    	txtCpfCnpj.setEditable(false);
    	
    	lblCidadeUF = setLabel("Cidade-UF:", 52, 215, 100,35);
    	txtCidadeUF = setTextField(115, 220, 135,30);
    	txtCidadeUF.setEditable(true);
    	
    	lblBairro = setLabel("Bairro:", 270, 215, 100,35);
    	txtBairro = setTextField(312, 220, 85,30);
    	txtBairro.setEditable(true);
		
    	lblNumero = setLabel("Numero/Qdr/Lote:", 315, 313, 100,35);
		txtNumero = setTextField(420, 316, 130,30);
		txtNumero.setEditable(true);
    	
		lblRua = setLabel("Rua:", 52, 313, 100,35);
    	txtRua = setTextField(82, 316, 200,30);
    	txtRua.setEditable(true);
    	
    	lblDataNasc = setLabel("Nascimento:", 245, 120, 150,35);
    	txtDataNasc = setTextField(325, 123, 87,30);
    	txtDataNasc.setEditable(false);
    	
    	lblTelefone = setLabel("Telefone:", 360, 25, 100,35);
    	txtTelefone = setTextField(418, 28, 130,30);
    	txtTelefone.setEditable(true);
		
    	lblCep = setLabel("Cep:", 420, 215, 100,35);
		txtCep = setTextField(450, 220, 100,30);
		txtCep.setEditable(true);
    	
		lblSexo = setLabel("Sexo:", 430, 122, 100,35);
    	txtSexo = setTextField(467, 125, 85,30);
    	txtSexo.setEditable(true);
    	
    	setCreateClientButton();

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
    	container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
   
    private void setCreateClientButton() {
        btnCadastrarCliente = new JButton("Cadastrar");
        btnCadastrarCliente.setBounds(450,360,100,40);
        btnCadastrarCliente.addActionListener(controller);
        container.add(btnCadastrarCliente);

    }
    
}
