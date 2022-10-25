package entities;

public class Produto {
	
	private String modelo;
	private String categoria;
	private String marca;
	private String setor;
	private String cor;
	private String tamanho;
	private Float preco;
	private	Integer unidadesEstoque;
	private String id;
	private Fornecedor fornecedor;
	
	public Produto() {}
	
	public Produto(String modelo, String categoria, String marca, String setor, String cor, String tamanho, Float preco,
			Integer unidadesEstoque, String id, Fornecedor fornecedor) {
		setModelo(modelo);
		setCategoria(categoria);
		setMarca(marca);
		setSetor(setor);
		setCor(cor);
		setTamanho(tamanho);
		setPreco(preco);
		setUnidadesEstoque(unidadesEstoque);
		setId(id);
		setFornecedor(fornecedor);
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Integer getUnidadesEstoque() {
		return unidadesEstoque;
	}

	public void setUnidadesEstoque(Integer unidadesEstoque) {
		this.unidadesEstoque = unidadesEstoque;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	

}
