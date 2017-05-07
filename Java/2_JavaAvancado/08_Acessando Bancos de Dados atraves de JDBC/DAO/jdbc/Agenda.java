package javaavancado.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javaavancado.util.Console;

/**
 * Classe que representa a agenda
 */
public class Agenda {

	/**
	 * Inicia a execução da aplicação
	 * @throws SQLException
	 */
	public void iniciar() throws SQLException {
		//mostra um menu de opções
		int opcao = mostrarMenu();

		//de acordo com a opção escolhida, chama o método correspondente
		do {
			switch (opcao) {
			case 1:
				inserir();
				break;
			case 2:
				atualizar();
				break;
			case 3:
				excluir();
				break;
			case 4:
				listar();
				break;
			case 5:
				procurar();
				break;
			}

			System.out.println();
			opcao = mostrarMenu();
		} while (opcao != 6);

		System.out.println("Fim do programa");
	}

	/**
	 * Insere um registro na agenda
	 * @throws SQLException
	 */
	private void inserir() throws SQLException {
		//cria um registro e lê os dados do console
		
		ItemAgenda i = new ItemAgenda();
		
		System.out.print("Nome: ");
		i.setNome(Console.readString());
		
		System.out.print("Telefone: ");
		i.setTelefone(Console.readString());
		
		System.out.print("E-mail: ");
		i.setEmail(Console.readString());
		
		Connection conn = null;
			
		try {
			//obtém uma conexão com o banco de dados e usa o DAO para fazer a operação
			conn = ConnectionFactory.getConnection();
			AgendaDAO dao = new AgendaDAO(conn);
			dao.inserir(i);
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}

	/**
	 * Atualiza um registro na agenda
	 * @throws SQLException
	 */
	private void atualizar() throws SQLException {
		System.out.print("Nome: ");
		String nome = Console.readString();
		
		Connection conn = null;
			
		try {
			//obtém uma conexão com o banco de dados e usa o DAO para fazer a operação
			conn = ConnectionFactory.getConnection();
			AgendaDAO dao = new AgendaDAO(conn);
			
			//procura o registro pelo nome
			ItemAgenda i = dao.carregar(nome);
			
			if(i == null) {
				System.out.println("Nome não encontrado!");
			} else {
				//lê os novos dados do registro e atualiza
				System.out.print("Telefone: ");
				i.setTelefone(Console.readString());
				
				System.out.print("E-mail: ");
				i.setEmail(Console.readString());
				
				dao.atualizar(i);
				System.out.println("Registro atualizado!");
			}
			
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}

	/**
	 * Exclui um registro da agenda
	 * @throws SQLException
	 */
	private void excluir() throws SQLException {
		System.out.print("Nome: ");
		String nome = Console.readString();
		
		Connection conn = null;
			
		try {
			//obtém uma conexão com o banco de dados e usa o DAO para fazer a operação
			conn = ConnectionFactory.getConnection();
			AgendaDAO dao = new AgendaDAO(conn);
			
			//busca o registro por nome para excluir
			ItemAgenda i = dao.carregar(nome);
			
			if(i == null) {
				System.out.println("Nome não encontrado!");
			} else {
				dao.excluir(i);
				System.out.println("Registro excluído!");
			}
			
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}

	/**
	 * Lista os itens cadastrados na agenda
	 * @throws SQLException
	 */
	private void listar() throws SQLException {
		
		Connection conn = null;
			
		try {
			//obtém uma conexão com o banco de dados e usa o DAO para fazer a operação
			conn = ConnectionFactory.getConnection();
			AgendaDAO dao = new AgendaDAO(conn);
			
			//traz uma lista de registros e itera sobre ela, imprimindo cada um deles
			List<ItemAgenda> itens = dao.listar();
			
			for (ItemAgenda i : itens) {
				imprimir(i);
			}
			
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	/**
	 * Procura por registros na agenda através do nome
	 * @throws SQLException
	 */
	private void procurar() throws SQLException {
		
		System.out.print("Nome: ");
		String nome = Console.readString();
		
		Connection conn = null;
			
		try {
			//obtém uma conexão com o banco de dados e usa o DAO para fazer a operação
			conn = ConnectionFactory.getConnection();
			AgendaDAO dao = new AgendaDAO(conn);
			
			//procura um registro por nome
			ItemAgenda i = dao.carregar(nome);
			
			if(i == null) {
				System.out.println("Nome não encontrado!");
			} else {
				imprimir(i);
			}
			
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	/**
	 * Imprime na tela um determinado registro da agenda
	 * @param i Registro a ser impresso
	 */
	private void imprimir(ItemAgenda i) {
		System.out.println("Nome = " + i.getNome());
		System.out.println("Telefone = " + i.getTelefone());
		System.out.println("E-mail = " + i.getEmail());
		System.out.println("-------------------------------------");
	}

	/**
	 * Mostra o menu de opções e aguarda a escolha do usuário
	 * @return Opção escolhida do menu
	 */
	private int mostrarMenu() {
		System.out.println("##########");
		System.out.println("# AGENDA #");
		System.out.println("##########");
		System.out.println();

		System.out.println("1 - Inserir");
		System.out.println("2 - Atualizar");
		System.out.println("3 - Excluir");
		System.out.println("4 - Listar");
		System.out.println("5 - Procurar");
		System.out.println("6 - Sair");
		System.out.println();
		System.out.print("Escolha uma opçao: ");
		
		int opcao = Console.readInt();
		System.out.println();
		return opcao;
	}

	public static void main(String[] args) throws Exception {
		//instancia a agenda e inicia a aplicação
		new Agenda().iniciar();
	}
}
