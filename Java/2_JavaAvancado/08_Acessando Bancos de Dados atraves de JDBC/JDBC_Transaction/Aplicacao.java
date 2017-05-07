import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Aplicacao {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/db";

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DriverManager.getConnection(url, "softblue", "softblue");
			stmt = conn.createStatement();
			
			//Inicia a transação
			conn.setAutoCommit(false);
			
			stmt.executeUpdate("INSERT INTO produto VALUES (1, 'N1', 50.0)");
			stmt.executeUpdate("INSERT INTO log VALUES (1)");
			
			//Encerra a transação com sucesso
			conn.commit();
		
		} catch (Exception e) {
			//Desfaz o que estava sendo feito durante a transação
			conn.rollback();
			throw e;
		
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
}
