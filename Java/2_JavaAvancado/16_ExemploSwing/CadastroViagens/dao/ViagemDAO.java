package curso.java.viagem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import curso.java.viagem.entity.Viagem;
import curso.java.viagem.entity.Viagem.Tipo;

/**
 * Métodos que interagem com a tabela 'viagem'
 */
public class ViagemDAO extends DAO {

	/**
	 * Cadastra uma viagem na tabela
	 * @param viagem Viagem a ser cadastrada
	 * @throws DAOException
	 */
	public void create(Viagem viagem) throws DAOException {
		try {
			String sql = "INSERT INTO viagem (data_ida, data_volta, tipo, info) VALUES (?, ?, ?, ?)";
			Object[] params = { viagem.getDataIda(), viagem.getDataVolta(), viagem.getTipo().toString(), viagem.getInfo() };
			executeUpdate(sql, params);
		
		} finally {
			cleanUp();
		}
	}
	
	/**
	 * Atualiza uma viagem na tabela
	 * @param viagem Viagem a ser atualizada
	 * @throws DAOException
	 */
	public void update(Viagem viagem) throws DAOException {
		try {
			String sql = "UPDATE viagem SET data_ida = ?, data_volta = ?, tipo = ?, info = ? WHERE id = ?";
			Object[] params = { viagem.getDataIda(), viagem.getDataVolta(), viagem.getTipo().toString(), viagem.getInfo(), viagem.getId() };
			int n = executeUpdate(sql, params);
			
			if (n < 1) {
				throw new DAOException("O registro com ID " + viagem.getId() + " não pode ser atualizado");
			}
		} finally {
			cleanUp();
		}
	}
	
	/**
	 * Exclui uma viagem da tabela
	 * @param id ID da viagem a ser excluída
	 * @throws DAOException
	 */
	public void delete(int id) throws DAOException {
		try {
			String sql = "DELETE FROM viagem WHERE id = ?";
			Object[] params = { id };
			int n = executeUpdate(sql, params);
			
			if (n < 1) {
				// Se n for menor que 1, é porque o registro não foi encontrado
				throw new DAOException("O registro com ID " + id + " não pode ser excluído");
			}
		} finally {
			cleanUp();
		}
	}
	
	/**
	 * Procura uma viagem com base na data de ida
	 * @param dataIda Data de ida da viagem
	 * @return Viagem encontrada ou null, se não for encontrada
	 * @throws DAOException
	 */
	public Viagem findByDataIda(Date dataIda) throws DAOException {
		try {
			// Cria um objeto java.sql.Date, pois a comparação utilizando o objeto java.util.Date
			// não funciona adequadamente
			java.sql.Date sqlDate = new java.sql.Date(dataIda.getTime());
			
			String sql = "SELECT id, data_ida, data_volta, tipo, info FROM viagem WHERE data_ida = ?";
			Object[] params = { sqlDate };
			ResultSet rs = executeQuery(sql, params);
			
			if (!rs.next()) {
				// Registro não foi encontrado
				return null;
			}
			
			// Cria um objeto Viagem e popula com os dados vindos da tabela
			Viagem viagem = new Viagem();
			populateObject(viagem, rs);
			return viagem;
			
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			cleanUp();
		}
	}
	
	/**
	 * Verifica se já existe uma viagem cadastrada com uma determinada data de ida
	 * @param dataIda Data de ida a ser verificada
	 * @return true se uma viagem existe; false, caso contrário
	 * @throws DAOException
	 */
	public boolean existsViagem(Date dataIda) throws DAOException {
		try {
			// Cria um objeto java.sql.Date, pois a comparação utilizando o objeto java.util.Date
			// não funciona adequadamente
			java.sql.Date sqlDate = new java.sql.Date(dataIda.getTime());
			
			String sql = "SELECT COUNT(*) FROM viagem WHERE data_ida = ?";
			Object[] params = { sqlDate };
			ResultSet rs = executeQuery(sql, params);
			rs.next();
			
			// Se o count(*) retornou maior que zero, retorna true. Senão retorna false.
			return rs.getInt(1) > 0 ? true : false;
		
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			cleanUp();
		}
	}
	
	/**
	 * Popula um objeto Viagem com base nos dados vindos da tabela
	 * @param viagem Objeto a ser populado
	 * @param rs ResultSet com os dados que serão extraídos
	 * @throws DAOException
	 */
	private void populateObject(Viagem viagem, ResultSet rs) throws DAOException {
		try {
			viagem.setId(rs.getInt("id"));
			viagem.setDataIda(rs.getDate("data_ida"));
			viagem.setDataVolta(rs.getDate("data_volta"));
			viagem.setTipo(Tipo.valueOf(rs.getString("tipo")));
			viagem.setInfo(rs.getString("info"));
		
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
