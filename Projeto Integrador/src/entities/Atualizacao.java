package entities;

import java.time.LocalDate;

public class Atualizacao {
	
	private String id;
	private Integer numItensAtualizados;
	private String tipoAtualizacao;
	private LocalDate data;
	private Float valorDaCompra;
	private Usuario usuario;
	private Produto produto;
	
	public Atualizacao() {}
	
	public Atualizacao(String id, Integer numItensAtualizados, String tipoAtualizacao, LocalDate data,
			Float valorDaCompra, Usuario usuario, Produto produto) {
		setId(id);
		setNumItensAtualizados(numItensAtualizados);
		setTipoAtualizacao(tipoAtualizacao);
		setData(data);
		setValorDaCompra(valorDaCompra);
		setUsuario(usuario);
		setProduto(produto);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getNumItensAtualizados() {
		return numItensAtualizados;
	}

	public void setNumItensAtualizados(Integer numItensAtualizados) {
		this.numItensAtualizados = numItensAtualizados;
	}

	public String getTipoAtualizacao() {
		return tipoAtualizacao;
	}

	public void setTipoAtualizacao(String tipoAtualizacao) {
		this.tipoAtualizacao = tipoAtualizacao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Float getValorDaCompra() {
		return valorDaCompra;
	}

	public void setValorDaCompra(Float valorDaCompra) {
		this.valorDaCompra = valorDaCompra;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	
}
