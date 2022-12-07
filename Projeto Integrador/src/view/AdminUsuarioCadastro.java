package view;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.ControllerAdminClienteCadastro;
import controller.ControllerAdminFornecedorCadastro;

public class AdminUsuarioCadastro extends JFrame{
	
	private JFrame container;
	private JLabel lblId, lblSenha, lblAcesso, lblUsuario, lblAdministrador; 
	private JTextField txtId; 
	private JPasswordField pswSenha; 
	private JButton btnCadastrarUsuario;
	private ImageIcon imgFundoTela;
	//private ControllerAdminFornecedorCadastro controller;
	private JRadioButton rbGerente;
    private JRadioButton rbUsuario;
    private ButtonGroup tipoFiltragem;

    public AdminUsuarioCadastro(/*ControllerAdminUsuarioCadastro ctrl*/) {
    	
    	container = new JFrame();
    	
    	//controller = ctrl;
    	
    	setBackgroundImage();
    	setDefaultScreenSettings();
    	
    	lblId = setLabel("Id:", 52,110,60,35);
        txtId = setTextField(80,115,280,30);

        
        lblSenha = setLabel("Senha:", 52,170,100,35);
        pswSenha = setPasswordField(100,173,250,30);

        lblAcesso = setLabel("Acesso:", 390, 110, 100, 35);
        
        rbGerente = setRadioButton(390, 140, 25, 30);
        lblAdministrador = setLabel("Gerente", 420, 135, 100 ,35); 

		rbUsuario = setRadioButton(390, 170, 25, 30);
		lblUsuario = setLabel("Usuario", 420, 170, 100 ,35);
    	
		setCreateUsuarioButton();
		
		tipoFiltragem = new ButtonGroup();
		tipoFiltragem.add(rbGerente);
		tipoFiltragem.add(rbUsuario);
    	container.setVisible(true);
    }
    
    private void setBackgroundImage() {
    	imgFundoTela = new ImageIcon(".\\src\\imagens\\FundoCadastroUsuario.png");
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
    
    private JPasswordField setPasswordField(int xPassword, int yPassword, int width, int height) {
    	JPasswordField password = new JPasswordField();
    	password = new JPasswordField();
    	password.setBounds(xPassword,yPassword,width,height);
        container.add(password);
        return password; 
    }
   
    private JRadioButton setRadioButton(int xRb, int yRb, int width, int height) {
    	JRadioButton rb = new JRadioButton(); 
    	rb = new JRadioButton(); 
    	rb.setBounds(xRb, yRb, width, height); 
    	container.add(rb); 
    	return rb; 
    }
    
    
    private void setCreateUsuarioButton() {
        btnCadastrarUsuario = new JButton("Cadastrar");
        btnCadastrarUsuario.setBounds(450,280,100,40);
        //btnCadastrarUsuario.addActionListener(/*controller*/);
        container.add(btnCadastrarUsuario);

    }

    
}

