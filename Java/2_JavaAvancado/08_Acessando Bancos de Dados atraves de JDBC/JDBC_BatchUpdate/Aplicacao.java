import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Aplicacao {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/db";

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(url, "softblue", "softblue");
			
			stmt = conn.prepareStatement("INSERT INTO produto VALUES (?, ?, ?)");
			
			for (int i = 1; i <= 10; i++) {
				stmt.setInt(1, i);
				stmt.setString(2, "Produto " + i);
				stmt.setDouble(3, 50.0);
				
				//Coloca o insert em uma fila, que será processada em lote depois
				stmt.addBatch();
			}
			
			//Processa todos os inserts da fila
			stmt.executeBatch();
			
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
