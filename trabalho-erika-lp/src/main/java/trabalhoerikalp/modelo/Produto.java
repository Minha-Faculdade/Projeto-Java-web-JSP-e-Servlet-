package trabalhoerikalp.modelo;

import java.util.Date;

public class Produto {
	
	private Long id;
	private String descricao;
	private String categoria;
	private Date dataEntrada;
	private String preco_custo;
	private String preco_venda;
	private String quantidade;
	
	
	
	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Produto(String descricao, String categoria, Date dataEntrada, String preco_custo, String preco_venda,
			String quantidade) {
		super();
		this.descricao = descricao;
		this.categoria = categoria;
		this.dataEntrada = dataEntrada;
		this.preco_custo = preco_custo;
		this.preco_venda = preco_venda;
		this.quantidade = quantidade;
	}




	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public String getPreco_custo() {
		return preco_custo;
	}
	public void setPreco_custo(String preco_custo) {
		this.preco_custo = preco_custo;
	}
	public String getPreco_venda() {
		return preco_venda;
	}
	public void setPreco_venda(String preco_venda) {
		this.preco_venda = preco_venda;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}




	@Override
	public String toString() {
		return "Produto [descricao=" + descricao + ", categoria=" + categoria + ", dataEntrada=" + dataEntrada
				+ ", preco_custo=" + preco_custo + ", preco_venda=" + preco_venda + ", quantidade=" + quantidade + "]";
	}
	
	
	
}
