package br.com.siger.stationery.db;

import java.math.BigDecimal;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.javamoney.moneta.Money;

import br.com.siger.stationery.model.Produto;
import br.com.siger.stationery.model.Setor;

public class CriaProdutos {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		CurrencyUnit currency = Monetary.getCurrency("BRL");
		transaction.begin();
		Setor setor1 = manager.find(Setor.class, 1l);
	
		BigDecimal valor = new BigDecimal("13.99");
		Produto produto1 = new Produto(null, "minas grafite 0.5 ml/HP",setor1,"Faber Castell","cx 12 et",Money.of(valor, currency),false);
		
		valor = new BigDecimal("20.40");
		Produto produto2 = new Produto(null, "caneta esferográfica cristal vermelha",setor1,"Bic","cx 50 un",Money.of(valor, currency),true);

		Setor setor2 = manager.find(Setor.class, 2l);
		valor = new BigDecimal("5.12");
		Produto produto3 = new Produto(null, "Pasta plástica en l",setor2,"Plastpark","pp 0.15, 220x 330mm várias cores, pacote 10 un",Money.of(valor, currency),false);
		
		valor = new BigDecimal("13.9");
		Produto produto4 = new Produto(null, "Papel sulfite A4",setor2,"Chamex","alcalino 90g, pacote 500fl",Money.of(valor, currency),false);
		
		Setor setor3 = manager.find(Setor.class, 3l);
		valor = new BigDecimal("65.2");
		Produto produto5 = new Produto(null, "Envelope comercial 114x 162",setor3,"Celocat","s/spc 90g aba ades. 135sf",Money.of(valor, currency),false);
		
		valor = new BigDecimal("28.0");
		Produto produto6 = new Produto(null, "Etiqueta adesiva glossy p/ link-jet 127x 88,9mm",setor3,"Pimaco","a4100g, pt 10 fl",Money.of(valor, currency),false);
		
		valor = new BigDecimal("9.38");
		Setor setor4 = manager.find(Setor.class, 4l);
		Produto produto7 = new Produto(null, "tinta p/ tecido metalica conj. c/ 6 cores glitter",setor4,"squizz","bt 1 cj",Money.of(valor, currency),false);
		
		valor = new BigDecimal("18.10");
		Produto produto8 = new Produto(null, "Pincel chato n.14 amarelo 815",setor4,"Tigre","sc 12un",Money.of(valor, currency),false);
		
		Setor setor5 = manager.find(Setor.class, 5l);
		valor = new BigDecimal("19.3");
		Produto produto9 = new Produto(null, "Caderno universitário 10x1 200fl moranguinho",setor5,"spiral mo","pacote 3 un",Money.of(valor, currency),false);
		
		valor = new BigDecimal("12.5");
		Produto produto10 = new Produto(null, "grampeador de mesa grande 26/6",setor5,"Genmes","cx 1un",Money.of(valor, currency),true);
		
		Setor setor6 = manager.find(Setor.class, 6l);
		valor = new BigDecimal("299");
		Produto produto11 = new Produto(null, "Monitor covencional 15\'' t530s",setor6,"LG","flatron tela plana",Money.of(valor, currency),true);
		
		valor = new BigDecimal("1170");
		Produto produto12 = new Produto(null, "Computador celeron d315",setor6,"Semp toshiba","hd de 40gb, 256 mb ram cd-rw",Money.of(valor, currency),false);
		
		Setor setor7 = manager.find(Setor.class, 7l);
		valor = new BigDecimal("10.9");
		Produto produto13 = new Produto(null, "Estojo de laminas olfa asb-10",setor7,"Microservice","bt 1un",Money.of(valor, currency),false);
		
		valor = new BigDecimal("8.33");
		Produto produto14 = new Produto(null, "fita adesiva polisil 10x 30 polipropileno amarela",setor7,"Adelbras","pt 10 rl",Money.of(valor, currency),false);
		
		manager.persist(produto1);
		manager.persist(produto2);
		manager.persist(produto3);
		manager.persist(produto4);
		manager.persist(produto5);
		manager.persist(produto6);
		manager.persist(produto7);
		manager.persist(produto8);
		manager.persist(produto9);
		manager.persist(produto10);
		manager.persist(produto11);
		manager.persist(produto12);
		manager.persist(produto13);
		manager.persist(produto14);
		
		transaction.commit();
		manager.close();
	}
}
