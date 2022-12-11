package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.ControllerAdicionaProdutoAoEstoque;
import controller.ControllerAdminClienteCadastro;

public class AdminAdicionaProdutoNoEstoque extends JFrame{
	
	private JFrame container;
	private JLabel lblIdProduto, lblUnidades, mensagem; 
	private JTextField txtIdProduto, txtUnidades; 
	private JButton btnAdicionarProduto;
	private ImageIcon imgFundoTela;
	private ControllerAdicionaProdutoAoEstoque controller;
	private MaskFormatter mascaraData = null;


    public AdminAdicionaProdutoNoEstoque(ControllerAdicionaProdutoAoEstoque ctrl) {
    	
    	container = new JFrame();
    	
    	controller = ctrl;
    	
    	setBackgroundImage();
    	setDefaultScreenSettings();
    	
    	lblIdProduto = setLabel("Id do produto:", 50, 170, 100, 35);
    	txtIdProduto = setTextField(130, 175, 270, 30); 
    	
    	lblUnidades = setLabel("Unidades: ", 425, 170, 100, 35);
    	txtUnidades = setTextField(485, 175, 70, 30);
    	
    	mensagem = setLabel("...", 20, 500, 100,30); 
    	
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
    	btnAdicionarProduto.addActionListener(controller);
        container.add(btnAdicionarProduto);
    }

	public JFrame getContainer() {
		return container;
	}

	public void setContainer(JFrame container) {
		this.container = container;
	}

	public JLabel getLblIdProduto() {
		return lblIdProduto;
	}

	public void setLblIdProduto(JLabel lblIdProduto) {
		this.lblIdProduto = lblIdProduto;
	}

	public JLabel getLblUnidades() {
		return lblUnidades;
	}

	public void setLblUnidades(JLabel lblUnidades) {
		this.lblUnidades = lblUnidades;
	}

	public JTextField getTxtIdProduto() {
		return txtIdProduto;
	}

	public void setTxtIdProduto(JTextField txtIdProduto) {
		this.txtIdProduto = txtIdProduto;
	}

	public JTextField getTxtUnidades() {
		return txtUnidades;
	}

	public void setTxtUnidades(JTextField txtUnidades) {
		this.txtUnidades = txtUnidades;
	}

	public JButton getBtnAdicionarProduto() {
		return btnAdicionarProduto;
	}

	public void setBtnAdicionarProduto(JButton btnAdicionarProduto) {
		this.btnAdicionarProduto = btnAdicionarProduto;
	}

	public ImageIcon getImgFundoTela() {
		return imgFundoTela;
	}

	public void setImgFundoTela(ImageIcon imgFundoTela) {
		this.imgFundoTela = imgFundoTela;
	}

	public ControllerAdicionaProdutoAoEstoque getController() {
		return controller;
	}

	public void setController(ControllerAdicionaProdutoAoEstoque controller) {
		this.controller = controller;
	}

	public MaskFormatter getMascaraData() {
		return mascaraData;
	}

	public void setMascaraData(MaskFormatter mascaraData) {
		this.mascaraData = mascaraData;
	}

	public JLabel getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem.setText(mensagem);
	}
    
    
    
}

