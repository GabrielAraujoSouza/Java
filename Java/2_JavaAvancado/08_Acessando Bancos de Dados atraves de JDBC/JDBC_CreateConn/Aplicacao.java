import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Aplicacao {

	public static void main(String[] args) throws Exception {

		//Exemplo do uso de Statement
		usingStatement();
		
		//Exemplo do uso de PreparedStatement
		usingPreparedStatement();
		
		//Exemplo do uso de PreparedStatement com parâmetros
		usingPreparedStatementWithParams();
	}

	private static void usingStatement() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/db";

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DriverManager.getConnection(url, "softblue", "softblue");
			stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO produto VALUES (1, 'Produto 1', 10.50)");
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

	private static void usingPreparedStatement() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/db";

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(url, "softblue", "softblue");
			stmt = conn.prepareStatement("INSERT INTO produto VALUES (2, 'Produto 2', 100)");
			stmt.executeUpdate();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	private static void usingPreparedStatementWithParams() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/db";

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(url, "softblue", "softblue");
			stmt = conn.prepareStatement("INSERT INTO produto VALUES (?, ?, ?)");
			
			//Os parâmetros substituem os caracteres '?' na expressão SQL
			stmt.setInt(1, 3);
			stmt.setString(2, "Nome 3");
			stmt.setDouble(3, 50.0);
			
			stmt.executeUpdate();
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
