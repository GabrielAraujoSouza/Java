package br.com.siger.stationery.model.to;

import javax.money.MonetaryAmount;

import br.com.siger.stationery.model.Produto;

public class ItemCarrinhoTO {

	private Integer indice;
	private Long id;
	private String produto;
	private Integer quantidade;
	private MonetaryAmount preco;
	private MonetaryAmount total;
	
	
	
	public ItemCarrinhoTO(Produto produto, Integer indice, Integer quantidade) {
		this.indice = indice;
		this.id = produto.getId();
		this.produto = produto.getDescricao();
		this.quantidade = quantidade;
		this.preco = produto.getPreco();
		this.total = preco.multiply(quantidade);
	}
	public Integer getIndice() {
		return indice;
	}
	public Long getId() {
		return id;
	}
	public String getProduto() {
		return produto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public MonetaryAmount getPreco() {
		return preco;
	}
	public MonetaryAmount getTotal() {
		return total;
	}
	
	
}
