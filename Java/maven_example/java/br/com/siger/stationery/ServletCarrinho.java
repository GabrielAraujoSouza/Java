package br.com.siger.stationery;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.money.MonetaryAmount;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.javamoney.moneta.Money;

import br.com.siger.stationery.model.Carrinho;
import br.com.siger.stationery.model.ItemCarrinho;
import br.com.siger.stationery.model.Produto;
import br.com.siger.stationery.model.to.ItemCarrinhoTO;
import br.com.siger.stationery.util.MonetaryUtil;

/**
 * Servlet implementation class ServletCarrinho
 */
public class ServletCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CARRINHO_KEY = "stationary.carrinho";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(true);
		Carrinho carrinho = (Carrinho) session.getAttribute(CARRINHO_KEY);
		if (carrinho == null) {
			carrinho = new Carrinho();
			session.setAttribute(CARRINHO_KEY, carrinho);
		}
		
		String msg = null;
		String idProduto = request.getParameter("Remove");
		if(idProduto!=null){
			Produto produto = carrinho.remove(idProduto);
			if(produto != null){
				msg = String.format("Foi removido de seu carrinho: <b>%s</b>", produto.getDescricao());
			}
		} else if(request.getParameter("Clear")!=null){
			carrinho.clear();
			msg = "Seu carrinho foi esvaziado!";
		}

		int totalItens = carrinho.getTotalIntens();
		int i = 1;
		MonetaryAmount total = Money.zero(MonetaryUtil.CURRENCY_BRL);
		List<ItemCarrinhoTO> itensCarrinho = new ArrayList<>();
		if (totalItens != 0) {
			ItemCarrinhoTO itemTO = null;
			for (ItemCarrinho<Produto> item : carrinho.getConteudo()) {
				itemTO = new ItemCarrinhoTO(item.getItem(), i ++, item.getQuantidade());
				itensCarrinho.add(itemTO);
				total = total.add(itemTO.getTotal());
			}
		} 
		
		ServletContext sc = getServletContext();
		RequestDispatcher dispatcher = sc.getRequestDispatcher("/WEB-INF/templates/carrinho.jsp");
		request.setAttribute("ItensCarrinho", itensCarrinho);
		request.setAttribute("TotalProdutos", total);
		request.setAttribute("msg", msg);
		dispatcher.forward(request, response);
	}

	public String getServletInfo() {
		return "Servlet de exibição do conteudo do carrinho de compras " + "que tambem permite exclusão deitens";
	}

}
