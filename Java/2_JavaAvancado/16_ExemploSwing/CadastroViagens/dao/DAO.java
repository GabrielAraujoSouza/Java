package curso.java.viagem.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Classe base das classes de acesso a dados
 */
public abstract class DAO {
	
	/**
	 * Objeto que contém as propriedades de conexão com o banco de dados
	 */
	private static Properties props;

	/**
	 * Conexão com o banco de dados
	 */
	private Connection conn;
	
	/**
	 * Statement utilizado para executar queries 
	 */
	private PreparedStatement stmt;
	
	static {
		// Carrega as propriedades de conexão do arquivo de configuração
		props = new Properties();
		try {
			props.load(new FileInputStream("db.properties"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Construtor protegido 
	 */
	protected DAO() {
	}
	
	/**
	 * Obtém uma conexão com o banco de dados
	 * @return Conexão aberta
	 * @throws DAOException
	 */
	private Connection getConnection() throws DAOException {
		try {
			if (conn == null) {
				// Se uma conexão não existir, cria
				String driver = props.getProperty("db_driver");
				String url = props.getProperty("db_url");
				String user = props.getProperty("db_user");
				String password = props.getProperty("db_password");
				Class.forName(driver);
				this.conn = DriverManager.getConnection(url, user, password);
			}
			return conn;
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException();
		}
	}
	
	/**
	 * Obtém um PreparedStatement
	 * @param sql Query a ser executada
	 * @return PreparedStatement criado
	 * @throws DAOException
	 */
	private PreparedStatement getStatement(String sql) throws DAOException {
		try {
			if (stmt == null) {
				// Cria o PreparedStatement
				stmt = getConnection().prepareStatement(sql);
			}
			return stmt;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Fecha o PreparedStatement e a conexão
	 * @throws DAOException
	 */
	protected void cleanUp() throws DAOException {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	/**
	 * Executa uma query do tipo SELECT
	 * @param sql Query a ser executada
	 * @param params Parâmetros a serem utilizados na query 
	 * @return ResultSet criado
	 * @throws DAOException
	 */
	protected ResultSet executeQuery(String sql, Object[] params) throws DAOException {
		try {
			return getPopulatedStatement(sql, params).executeQuery();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	/**
	 * Executa uma query do tipo UPDATE, INSERT ou DELETE
	 * @param sql Query a ser executada
	 * @param params Parâmetros a serem utilizados na query
	 * @return Número de registros afetados pela query
	 * @throws DAOException
	 */
	protected int executeUpdate(String sql, Object[] params) throws DAOException {
		try {
			return getPopulatedStatement(sql, params).executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	/**
	 * Obtém um PreparedStatement já populado com os parâmetros da query
	 * @param sql Query a ser executada
	 * @param params Parâmetros a serem utilizados na query
	 * @return PreparedStatement criado
	 * @throws DAOException
	 */
	private PreparedStatement getPopulatedStatement(String sql, Object[] params) throws DAOException {
		try {
			// Cria o PreparedStatement
			PreparedStatement stmt = getStatement(sql);
			
			int count = 1;
			
			// Itera sobre os parâmetros, inserindo-os dentro do PreparedStatement
			if (params != null) {
				for (Object param : params) {
					if (param != null && param instanceof String) {
						// Se o parâmetro for uma String, remove os espaços em branco
						param = ((String) param).trim();
					}
					stmt.setObject(count++, param);
				}
			}
			
			return stmt;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
