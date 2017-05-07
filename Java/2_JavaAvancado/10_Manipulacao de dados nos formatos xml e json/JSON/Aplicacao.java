

import com.google.gson.Gson;


public class Aplicacao {

	public static void main(String[] args) {
		
		CarrinhoDeCompras carrinho1 = new CarrinhoDeCompras();
		carrinho1.addProduto(new Produto(1, "Feij�o"));
		carrinho1.addProduto(new Produto(2, "Arroz"));
		carrinho1.addProduto(new Produto(3, "Caf�"));
		carrinho1.imprimirProdutos();
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(carrinho1);
		System.out.println(jsonStr);
		
		CarrinhoDeCompras carrinho2 = gson.fromJson(jsonStr, CarrinhoDeCompras.class);
		carrinho2.imprimirProdutos();
	}
}
