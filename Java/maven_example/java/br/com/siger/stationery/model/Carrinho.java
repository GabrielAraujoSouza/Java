package br.com.siger.stationery.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Carrinho {
	private Map<String, ItemCarrinho<Produto>> conteudo = null;
	private int totalDeItens = 0;
	private int totalProdutos = 0;
	
	public Carrinho() {
		conteudo = new HashMap<>();
	}
	public void add(Produto produto) {
		String key = produto.getId().toString();
		if(conteudo.containsKey(key)) {
			ItemCarrinho<Produto> item = conteudo.get(key);
			item.setQuantidade(item.getQuantidade() + 1);
		} else {
			ItemCarrinho<Produto> item = new ItemCarrinho<Produto>(produto);
			conteudo.put(key, item);
			totalProdutos++;
		}
		totalDeItens++;
		
	}
	
	public Produto remove(String key) {
		Produto produto = null;
		if(conteudo.containsKey(key)) {
			ItemCarrinho<Produto> item = conteudo.get(key);
			item.setQuantidade(item.getQuantidade() -1);
			totalDeItens--;
			if(item.getQuantidade() <= 0) {
				conteudo.remove(key);
				totalProdutos--;
			}
			produto = item.getItem();
		}
		return produto;
	}
	
	public Produto remove(Produto produto){
		String key = produto.getId().toString();
		return remove(key);
	}
	
	public Collection<ItemCarrinho<Produto>> getConteudo(){
		return conteudo.values();
	}
	
	public int getTotalIntens() {
		return totalDeItens;
	}
	
	public int geTotalProdutos() {
		return totalProdutos;
	}
	
	public double getValorTotal() {
		double total = 0.0;
		for(ItemCarrinho<Produto> item : getConteudo()) {
			Produto produto = item.getItem();
			total += produto.getPreco().multiply(item.getQuantidade()).getNumber().doubleValue();
		}
		return Math.round(total*100)/100.0;
	}
	
	public void clear () {
		conteudo.clear();
		totalDeItens = 0;
		totalProdutos = 0;
	}
	
	protected void finalize() throws Throwable {
		clear();
	}
}
