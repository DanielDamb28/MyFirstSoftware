package entities;

public class ItensVendidos {
	
	private Produto produto;
	private Venda venda;
	private Integer numProdutos;
	private Float precoNaData;
	
	public ItensVendidos() {}

	public ItensVendidos(Produto produto, Venda venda, Integer numProdutos, Float precoNaData) {
		setProduto(produto);
		setVenda(venda);
		setNumProdutos(numProdutos);
		setPrecoNaData(precoNaData);
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Integer getNumProdutos() {
		return numProdutos;
	}

	public void setNumProdutos(Integer numProdutos) {
		this.numProdutos = numProdutos;
	}

	public Float getPrecoNaData() {
		return precoNaData;
	}

	public void setPrecoNaData(Float precoNaData) {
		this.precoNaData = precoNaData;
	}
	
	
	
	
}
