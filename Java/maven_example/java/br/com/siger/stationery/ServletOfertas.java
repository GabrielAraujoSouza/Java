package br.com.siger.stationery;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.siger.stationery.db.Database;
import br.com.siger.stationery.db.JPAUtil;
import br.com.siger.stationery.model.Carrinho;
import br.com.siger.stationery.model.Produto;
import br.com.siger.stationery.repository.Produtos;

/**
 * Servlet implementation class ServletCarrinho
 */
public class ServletOfertas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DecimalFormat df = new DecimalFormat("0.00");
	private Database db;
	private static final String DB_KEY = "stationary.db";
	private static final String CARRINHO_KEY = "stationary.carrinho";

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Carrinho carrinho = (Carrinho) session.getAttribute(CARRINHO_KEY);
		if (carrinho == null) {
			carrinho = new Carrinho();
			session.setAttribute(CARRINHO_KEY, carrinho);
		}
		EntityManager manager = JPAUtil.getEntityManager();
		Produtos produtos = new Produtos(manager);
		
		Produto produto = null;
		String msg = null;
		String idProduto = request.getParameter("Add");
		if(idProduto != null){
			produto = produtos.porId(Long.parseLong(idProduto));
			carrinho.add(produto);
			msg = "Produto adicionado ao carrinho com sucesso!";
		}
		List<Produto> listaProdutos = produtos.emOferta();
		ServletContext sc = getServletContext();
		RequestDispatcher dispatcher = sc.getRequestDispatcher("/WEB-INF/templates/ofertas.jsp");
		request.setAttribute("Produtos", listaProdutos);
		request.setAttribute("msg", msg);
		dispatcher.forward(request, response);

	}

	public String getServletInfo() {
		return "Servlet de exibição do conteudo do carrinho de compras " + "que tambem permite exclusão deitens";
	}

}
