package javaavancado.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de DAO que gerencia a tabela Agenda.
 * A classe de DAO encapsula todo o acesso ao banco de dados. Ela é responsável pela execução das queries
 * no banco de dados.
 */
public class AgendaDAO {
	/**
	 * Conexão com o banco de dados
	 */
	private Connection conn;

	/**
	 * Construtor
	 * @param conn Conexão com o banco de dados
	 * @throws SQLException
	 */
	public AgendaDAO(Connection conn) throws SQLException {
		this.conn = conn;
	}

	/**
	 * Exclui um registro da agenda
	 * @param i Registro a ser excluído
	 * @throws SQLException
	 */
	public void excluir(ItemAgenda i) throws SQLException {
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement("DELETE FROM agenda WHERE nome = ?");
			stmt.setString(1, i.getNome());
			stmt.executeUpdate();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	/**
	 * Insere um registro na agenda
	 * @param i Registro a ser inserido
	 * @throws SQLException
	 */
	public void inserir(ItemAgenda i) throws SQLException {
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement("INSERT INTO agenda (nome, telefone, email) VALUES (?, ?, ?)");
			stmt.setString(1, i.getNome());
			stmt.setString(2, i.getTelefone());
			stmt.setString(3, i.getEmail());
			stmt.executeUpdate();

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	/**
	 * Atualiza um registro da agenda
	 * @param i Registro a ser atualizado
	 * @throws SQLException
	 */
	public void atualizar(ItemAgenda i) throws SQLException {
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement("UPDATE agenda SET telefone = ?, email = ? WHERE nome = ?");
			stmt.setString(1, i.getTelefone());
			stmt.setString(2, i.getEmail());
			stmt.setString(3, i.getNome());
			stmt.executeUpdate();

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	/**
	 * Carrega um registro da agenda
	 * @param nome Nome do registro
	 * @return Registro carregado ou null se o registro não existir
	 * @throws SQLException
	 */
	public ItemAgenda carregar(String nome) throws SQLException {
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement("SELECT nome, telefone, email FROM agenda WHERE nome = ?");
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();

			if (!rs.next()) {
				return null;
			}

			ItemAgenda i = new ItemAgenda();
			i.setNome(rs.getString(1));
			i.setTelefone(rs.getString(2));
			i.setEmail(rs.getString(3));
			return i;
			
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}
	
	/**
	 * Lista os registros cadastrados na agenda
	 * @return Lista de registros
	 * @throws SQLException
	 */
	public List<ItemAgenda> listar() throws SQLException {
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement("SELECT nome, telefone, email FROM agenda ORDER BY nome");
			ResultSet rs = stmt.executeQuery();

			List<ItemAgenda> itens = new ArrayList<ItemAgenda>();
			
			while(rs.next()) {
				ItemAgenda i = new ItemAgenda();
				i.setNome(rs.getString(1));
				i.setTelefone(rs.getString(2));
				i.setEmail(rs.getString(3));
				itens.add(i);
			}
			
			return itens;
			
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}
}
